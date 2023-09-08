package com.example.fednclient

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withContext


enum class ModelUpdateState {
    IDLE, SESSION_STARTED, SESSION_FINISHED, SESSION_ABORTED
}

const val MESSAGE_RUN_PROCESS_OK = "runProcess ran to completion"
const val MESSAGE_GRPC_HANDLER_NOT_INITIALIZED =
    "Grpc handler not initialized, attachClientToNetwork must run first"

interface IFednClient {
    suspend fun runProcess(
        onAttachStateChanged: ((state: AttachState) -> Unit)?,
        onUpdateModelStateChanged: ((state: ModelUpdateState) -> Unit)?
    ): Pair<String, Boolean>

    suspend fun attachClientToNetwork(onStateChanged: ((state: AttachState) -> Unit)? = null): Pair<String, Boolean>
    suspend fun listenToModelUpdateRequestStream(onStateChanged: ((state: ModelUpdateState) -> Unit)? = null): Pair<String, Boolean>
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

        val (msgModelUpdate, successfullyListedToModelUpdate) = listenToModelUpdateRequestStream(
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

        } else {

            result = false
        }

        return Pair(msg, result)
    }

    override suspend fun listenToModelUpdateRequestStream(onStateChanged: ((state: ModelUpdateState) -> Unit)?): Pair<String, Boolean> {

        if (grpcHandler != null) {

            grpcHandler?.listenToModelUpdateRequestStream()

            return Pair("Success", true)
        }

        return Pair(MESSAGE_GRPC_HANDLER_NOT_INITIALIZED, false)
    }

    internal suspend fun sendHeartbeats() {

        var counter: Long = 0

        while (maxNumberOfHearbeats == null || counter < maxNumberOfHearbeats) {

            grpcHandler?.sendHeartbeat()
            delay(heartbeatInterval)
            counter++
        }
    }

}