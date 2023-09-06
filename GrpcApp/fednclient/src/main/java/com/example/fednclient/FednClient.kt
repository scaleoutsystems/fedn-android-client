package com.example.fednclient

import io.ktor.client.HttpClient
import io.ktor.client.engine.cio.CIO
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withContext
import kotlinx.serialization.json.Json
import io.ktor.serialization.kotlinx.json.json


enum class ModelUpdateState {
    IDLE, SESSION_STARTED, SESSION_FINISHED, SESSION_ABORTED
}

interface IFednClient {
    suspend fun doWork(
        onAssignStateChanged: (state: AssignState) -> Unit,
        onUpdateModelStateChanged: (state: ModelUpdateState) -> Unit
    ): Pair<String, Boolean>

    suspend fun assign(onStateChanged: (state: AssignState) -> Unit): Pair<String, Boolean>
    suspend fun listenToModelUpdateRequestStream(onStateChanged: (state: ModelUpdateState) -> Unit): Pair<String, Boolean>
}

class FednClient(
    private val connectionString: String,
    private val name: String,
    private val token: String,
    private val defaultDispatcher: CoroutineDispatcher = Dispatchers.IO,
) : IFednClient {

    private var _client: IClient? = null
    private val client: IClient
        get() {

            if (_client == null) {

                val httpClientWrapper: IHttpClientWrapper<AssignResponse> =
                    HttpClientAssignWrapper()
                _client = Client(httpClientWrapper)
            }

            return _client!!
        }


    private var grpcHandler: IGrpcHandler? = null

    override suspend fun doWork(
        onAssignStateChanged: (state: AssignState) -> Unit,
        onUpdateModelStateChanged: (state: ModelUpdateState) -> Unit
    ): Pair<String, Boolean> = withContext(defaultDispatcher) {
        val (result, response) = client.assign(connectionString, name, token)
        onAssignStateChanged(AssignState.ASSIGNED)

        if (response == AssignResponseStatus.OK && result?.fqdn != null && result.port != null) {

            val fqdn = result.fqdn
            grpcHandler = GrpcHandler(name, fqdn, 443, token)

            launch {

                sendHeartbeats()
            }

            grpcHandler?.listenToModelUpdateRequestStream()
            onUpdateModelStateChanged(ModelUpdateState.SESSION_FINISHED)
        }

        return@withContext Pair("Success", true)
    }

    private suspend fun sendHeartbeats() {
//        TODO Should be able to set timeout
        while (true) {

            grpcHandler?.sendHeartbeat()
            delay(4000)
        }
    }

    override suspend fun assign(onStateChanged: (state: AssignState) -> Unit): Pair<String, Boolean> {
        TODO("Not yet implemented")
    }

    override suspend fun listenToModelUpdateRequestStream(onStateChanged: (state: ModelUpdateState) -> Unit): Pair<String, Boolean> {
        TODO("Not yet implemented")
    }


}