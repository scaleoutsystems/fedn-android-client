package com.example.fednclient

import com.google.protobuf.ByteString
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withContext

const val MESSAGE_RUN_PROCESS_OK = "runProcess ran to completion"
const val MESSAGE_GRPC_HANDLER_NOT_INITIALIZED =
    "Grpc handler not initialized, attachClientToNetwork must run first"
const val MESSAGE_HEARTBEATS_NOT_INITIALIZED =
    "Heartbeats not initialized, sendHeartbeats must run (in background) first"

interface IFednClient {
    suspend fun runProcess(
        trainModel: (ByteString?) -> ByteString?,
        onAttachStateChanged: ((state: AttachState) -> Unit)? = null,
        onUpdateModelStateChanged: ((state: ModelUpdateState) -> Unit)? = null
    ): Pair<String, Boolean>

    suspend fun attachClientToNetwork(onStateChanged: ((state: AttachState) -> Unit)? = null): Pair<String, Boolean>
    suspend fun sendHeartbeats()
    suspend fun listenToModelUpdateRequestStream(
        trainModel: (ByteString?) -> ByteString?,
        onStateChanged: ((state: ModelUpdateState) -> Unit)? = null
    ): Pair<String, Boolean>
}

class FednClient(
    private val connectionString: String,
    private val name: String,
    private val token: String,
    private val maxNumberOfHearbeats: Long? = null,
    private val heartbeatInterval: Long = 5000,
    private val port: Int = 443,
    private val defaultDispatcher: CoroutineDispatcher = Dispatchers.IO,
    private var _httpHandler: IHttpHandler? = null,
    private var _grpcHandler: IGrpcHandler? = null
) : IFednClient {

    var attached: Boolean = false
    var heartbeatsInitiated: Boolean = false
    var listeningToModelUpdate: Boolean = false

    private val httpHandler: IHttpHandler
        get() {

            if (_httpHandler == null) {

                val httpClientWrapper: IHttpClientWrapper<AttachResponse> =
                    HttpClientAssignWrapper()
                _httpHandler = HttpHandler(httpClientWrapper)
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

    override suspend fun runProcess(
        trainModel: (ByteString?) -> ByteString?,
        onAttachStateChanged: ((state: AttachState) -> Unit)?,
        onUpdateModelStateChanged: ((state: ModelUpdateState) -> Unit)?
    ): Pair<String, Boolean> = withContext(defaultDispatcher) {

        val (msgAttach, successfullyAttached) = attachClientToNetwork(onAttachStateChanged)

        if (!successfullyAttached) {

            return@withContext Pair(msgAttach, false)
        }

        launch {

            sendHeartbeats()
        }


        val trainModel: (ByteString?) -> ByteString? = { modelIn ->
            modelIn
        }

        val (msgModelUpdate, successfullyListedToModelUpdate) = listenToModelUpdateRequestStream(
            trainModel = trainModel,
            onUpdateModelStateChanged
        )

        if (!successfullyListedToModelUpdate) {

            return@withContext Pair(msgModelUpdate, false)
        }

        return@withContext Pair(MESSAGE_RUN_PROCESS_OK, true)
    }

    override suspend fun attachClientToNetwork(onStateChanged: ((state: AttachState) -> Unit)?): Pair<String, Boolean> {

        var result: Boolean = true

        val (response, responseStatus) = httpHandler.attach(
            connectionString, name, token, onStateChanged
        )

        val (statusCode, statusMessage) = responseStatus

        val msg: String = statusMessage

        if (statusCode == AttachResponseStatus.OK && response?.fqdn != null && response.port != null) {

            val fqdn = response.fqdn

            grpcHandler = GrpcHandler(name, fqdn, port, token)

            attached = true

        } else {

            result = false
        }

        return Pair(msg, result)
    }

    override suspend fun sendHeartbeats() {

        heartbeatsInitiated = true
        var counter: Long = 0

        while (maxNumberOfHearbeats == null || counter < maxNumberOfHearbeats) {

            grpcHandler?.sendHeartbeat()
            delay(heartbeatInterval)
            counter++
        }
    }

    override suspend fun listenToModelUpdateRequestStream(
        trainModel: (ByteString?) -> ByteString?,
        onStateChanged: ((state: ModelUpdateState) -> Unit)?
    ): Pair<String, Boolean> {


        return if (!attached || grpcHandler == null) {

            Pair(MESSAGE_GRPC_HANDLER_NOT_INITIALIZED, false)
        } else if (!heartbeatsInitiated) {

            Pair(MESSAGE_HEARTBEATS_NOT_INITIALIZED, false)
        } else {

            listeningToModelUpdate = true

            grpcHandler?.listenToModelUpdateRequestStream(trainModel, onStateChanged)

            Pair("Success", true)
        }
    }
}