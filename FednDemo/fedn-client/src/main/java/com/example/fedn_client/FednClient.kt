package com.example.fedn_client

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.cancelAndJoin
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.selects.select
import kotlinx.coroutines.withContext
import kotlinx.coroutines.withTimeoutOrNull

const val MESSAGE_RUN_PROCESS_OK = "runProcess ran to completion"
const val MESSAGE_GRPC_HANDLER_NOT_INITIALIZED =
    "Grpc handler not initialized, attachClientToNetwork must run first"
const val MESSAGE_HEARTBEATS_NOT_INITIALIZED =
    "Heartbeats not initialized, sendHeartbeats must run (in background) first"

const val MESSAGE_MODEL_UPDATE_STREAM_RAN_TO_COMPLETION = "Model update stream ran to completion"
const val CHECK_TRAINING_INTERVAL_MILLISECONDS: Long = 1000

interface IFednClient {
    suspend fun runProcess(
        trainModel: (ByteArray) -> ByteArray,
        onAttachStateChanged: ((state: AttachState) -> Unit)? = null,
        onUpdateModelStateChanged: ((state: ModelUpdateState) -> Unit)? = null,
        timeoutAfterMillis: Long = 60000
    ): Pair<String, Boolean>
    fun stopProcess()
    suspend fun attachClientToNetwork(onStateChanged: ((state: AttachState) -> Unit)? = null): Pair<String, Boolean>
    suspend fun sendHeartbeats(timeoutAfterMillis: Long = 60000)
    suspend fun sendTelemetry(values: Map<String, Float>)
    suspend fun listenToModelUpdateRequestStream(
        trainModel: (ByteArray) -> ByteArray,
        onStateChanged: ((state: ModelUpdateState) -> Unit)? = null,
        timeoutAfterMillis: Long = 60000
    ): Pair<String, Boolean>
}

class FednClient(
    private val connectionString: String,
    private val token: String,
    private val name: String? = null,
    private val id: String? = null,
    private val heartbeatInterval: Long = 5000,
    private val secureGrpcConnection: Boolean = true,
    private val defaultDispatcher: CoroutineDispatcher = Dispatchers.IO,
    private var _httpHandler: IHttpHandler? = null,
    private var _grpcHandler: IGrpcHandler? = null,
) : IFednClient {

    private var running: Boolean = false
    private var attached: Boolean = false
    private var training: Boolean = false
    private var heartbeatsInitiated: Boolean = false
    private var listeningToModelUpdate: Boolean = false

    private val httpHandler: IHttpHandler
        get() {

            if (_httpHandler == null) {
                _httpHandler = HttpHandler()
            }

            return _httpHandler ?: throw AssertionError("Set to null by another thread")
        }

    private var grpcHandler: IGrpcHandler?
        get() {
            return _grpcHandler
        }
        set(value) {
            _grpcHandler = value
        }

    private val onStateChangedInternal: (state: ModelUpdateState) -> Unit = { state ->
        if (state == ModelUpdateState.SERVER_MODEL_DOWNLOADED) {
            training = true
        } else if (listOf(
                ModelUpdateState.TRAINING_COMPLETED, ModelUpdateState.TRAINING_ROUND_FINISHED
            ).contains(state)
        ) {
            training = false
        }
    }

    override suspend fun runProcess(
        trainModel: (ByteArray) -> ByteArray,
        onAttachStateChanged: ((state: AttachState) -> Unit)?,
        onUpdateModelStateChanged: ((state: ModelUpdateState) -> Unit)?,
        timeoutAfterMillis: Long
    ): Pair<String, Boolean> = withContext(defaultDispatcher) {

        running = true

        val (msgAttach, successfullyAttached) = attachClientToNetwork(onAttachStateChanged)

        if (!successfullyAttached) {

            return@withContext Pair(msgAttach, false)
        }

        launch {

            sendHeartbeats(timeoutAfterMillis)
        }

        heartbeatsInitiated = true

        val (msgModelUpdate, successfullyListedToModelUpdate) = listenToModelUpdateRequestStream(
            trainModel = trainModel, onUpdateModelStateChanged, timeoutAfterMillis
        )

        stopProcess()

        if (!successfullyListedToModelUpdate) {

            return@withContext Pair(msgModelUpdate, false)
        }

        return@withContext Pair(MESSAGE_RUN_PROCESS_OK, true)
    }

    override suspend fun attachClientToNetwork(onStateChanged: ((state: AttachState) -> Unit)?): Pair<String, Boolean> {

        var result = true
        val clientId: String = id ?: generateRandomString()

        val (response, responseStatus) = httpHandler.attach(
            connectionString = connectionString,
            id = clientId,
            token = token,
            name = name,
            onStateChanged = onStateChanged
        )

        val (statusCode, statusMessage) = responseStatus

        val msg: String = statusMessage

        if (statusCode == AttachResponseStatus.OK && response?.fqdn != null && response.port != null && response.host != null) {

            val fqdn = response.fqdn

            grpcHandler = GrpcHandler(
                name = name ?: clientId,
                clientId,
                fqdn,
                port = if (secureGrpcConnection) 443 else response.port,
                token,
                response.host,
                secureGrpcConnection = secureGrpcConnection
            )

            attached = true

        } else {

            result = false
        }

        return Pair(msg, result)
    }

    override suspend fun sendHeartbeats(timeoutAfterMillis: Long) {

        heartbeatsInitiated = true

        withTimeoutOrNull(timeoutAfterMillis) {

            while (running) {

                grpcHandler?.sendHeartbeat()
                delay(heartbeatInterval)
            }
        }
    }

    override suspend fun sendTelemetry(values: Map<String, Float>) {

        grpcHandler?.sendTelemetry(values)
    }

    override suspend fun listenToModelUpdateRequestStream(
        trainModel: (ByteArray) -> ByteArray,
        onStateChanged: ((state: ModelUpdateState) -> Unit)?,
        timeoutAfterMillis: Long
    ): Pair<String, Boolean> {

        return if (!attached || grpcHandler == null) {

            Pair(MESSAGE_GRPC_HANDLER_NOT_INITIALIZED, false)
        } else if (!heartbeatsInitiated) {

            Pair(MESSAGE_HEARTBEATS_NOT_INITIALIZED, false)
        } else {

            listeningToModelUpdate = true

            withTimeoutOrNullCustom(timeoutAfterMillis) {

                grpcHandler?.listenToTaskStream(
                    trainModel,
                    onStateChanged,
                    onStateChangedInternal,
                )
            }

            Pair(MESSAGE_MODEL_UPDATE_STREAM_RAN_TO_COMPLETION, true)
        }
    }

    private suspend fun <T> withTimeoutOrNullCustom(
        timeoutMillis: Long, block: suspend () -> T
    ): T? {
        return withContext(Dispatchers.IO) {
            val result = async { block() }

            val timeoutJob = async {
                delay(timeoutMillis)
                null
            }

            val resultOrNull = select {
                result.onAwait { it }
                timeoutJob.onAwait { it }
            }

            while (true) {

                if (!training) {

                    result.cancelAndJoin()
                    timeoutJob.cancelAndJoin()
                    break
                }

                delay(CHECK_TRAINING_INTERVAL_MILLISECONDS)
            }

            resultOrNull
        }
    }

    override fun stopProcess() {

        running = false
        grpcHandler?.close()
    }
}