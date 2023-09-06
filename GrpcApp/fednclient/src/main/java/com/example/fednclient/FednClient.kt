package com.example.fednclient

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext


enum class ModelUpdateState {
    IDLE, SESSION_STARTED, SESSION_FINISHED, SESSION_ABORTED
}

interface IFednClient {
    suspend fun doWork(
        onAssignStateChanged: (state: AssignState) -> Unit,
        onUpdateModelStateChanged: (state: ModelUpdateState) -> Unit
    ): Pair<String, Boolean>

    suspend fun attachClientToNetwork(onStateChanged: (state: AssignState) -> Unit): Pair<String, Boolean>
    suspend fun listenToModelUpdateRequestStream(onStateChanged: (state: ModelUpdateState) -> Unit): Pair<String, Boolean>
}

class FednClient(
    private val connectionString: String,
    private val name: String,
    private val token: String,
    private val maxTimeConnected: Long? = null,
    private val heartbeatInterval: Long = 5000,
    private val port: Int = 443,
    private val defaultDispatcher: CoroutineDispatcher = Dispatchers.IO,
    private var _client: IHttpHandler? = null,
    private var _grpcHandler: IGrpcHandler? = null
) : IFednClient {

    private val client: IHttpHandler
        get() {

            if (_client == null) {

                val httpClientWrapper: IHttpClientWrapper<AssignResponse> =
                    HttpClientAssignWrapper()
                _client = HttpHandler(httpClientWrapper)
            }

            return _client ?: throw AssertionError("Set to null by another thread")
        }

    private var grpcHandler: IGrpcHandler?
        get() {
            return _grpcHandler
        }
        set(value) {
            _grpcHandler = value
        }

    override suspend fun doWork(
        onAssignStateChanged: (state: AssignState) -> Unit,
        onUpdateModelStateChanged: (state: ModelUpdateState) -> Unit
    ): Pair<String, Boolean> = withContext(defaultDispatcher) {
        val (response, responseStatus) = client.assign(connectionString, name, token)

        val (statusCode, statusMessage) = responseStatus

        if (statusCode == AssignResponseStatus.OK && response?.fqdn != null && response.port != null) {

            val fqdn = response.fqdn
            _grpcHandler = GrpcHandler(name, fqdn, 443, token)

            launch {

                sendHeartbeats()
            }

            _grpcHandler?.listenToModelUpdateRequestStream()
            onUpdateModelStateChanged(ModelUpdateState.SESSION_FINISHED)
        }

        return@withContext Pair("Success", true)
    }

    override suspend fun attachClientToNetwork(onStateChanged: (state: AssignState) -> Unit): Pair<String, Boolean> =
        withContext(defaultDispatcher) {

            var result: Boolean = true

            val (response, responseStatus) = client.assign(
                connectionString, name, token, onStateChanged
            )

            val (statusCode, statusMessage) = responseStatus

            val msg: String = statusMessage


            if (statusCode == AssignResponseStatus.OK && response?.fqdn != null && response.port != null) {

                val fqdn = response.fqdn

                grpcHandler = GrpcHandler(name, fqdn, port, token)

                launch {

                    sendHeartbeats()
                }
            } else {

                result = false
            }

            return@withContext Pair(msg, result)
        }

    override suspend fun listenToModelUpdateRequestStream(onStateChanged: (state: ModelUpdateState) -> Unit): Pair<String, Boolean> {
        TODO("Not yet implemented")
    }

    private suspend fun sendHeartbeats() {
//        TODO Should be able to set timeout
        while (true) {

            grpcHandler?.sendHeartbeat()
            delay(4000)
        }
    }

}