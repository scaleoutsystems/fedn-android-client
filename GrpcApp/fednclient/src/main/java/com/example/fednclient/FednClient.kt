package com.example.fednclient

import android.content.Context
import com.example.fednclient.grpc.response
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.async
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.withContext
import java.security.cert.X509Certificate

interface IFednClient {
    fun doWork()
}

class FednClient(
    private val connectionString: String,
    private val name: String,
    private val preferredCombiner: String?,
    private val token: String,
    private val heartBeatInterval: Long = 1000
) : IFednClient {

    private val client: IClient = Client()
    private var grpcHandler: IGrpcHandler? = null

    private val scope = CoroutineScope(Job() + Dispatchers.Main)

    override fun doWork() {

        scope.launch {

            doWorkInternal()
        }
    }

    private suspend fun doWorkInternal() = withContext(Dispatchers.Default) {

        val response = client.assign(connectionString, name, preferredCombiner, token)

        if (response?.fqdn != null && response.port != null) {

            val fqdn = response.fqdn
            grpcHandler = GrpcHandler(name, fqdn, 443, token)

            async {

                sendHeartbeats()
            }

            grpcHandler?.listenToModelUpdateRequestStream()
        }
    }

    private suspend fun sendHeartbeats() {

        while (true) {

            grpcHandler?.sendHeartbeat()
            delay(heartBeatInterval)
        }
    }
}