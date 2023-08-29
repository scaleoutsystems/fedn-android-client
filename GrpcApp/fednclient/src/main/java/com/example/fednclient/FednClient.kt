package com.example.fednclient

import com.example.fednclient.grpc.response
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.GlobalScope
import java.security.cert.X509Certificate

class FednClient(
    connectionString: String,
    name: String,
    preferredCombiner: String?,
    token: String
) {

    private val client: IClient = Client()
    private val certificate: Certificate = Certificate()
    private var grpcHandler: IGrpcHandler? = null

    init {


        GlobalScope.launch {

            val response = client.assign(connectionString, name, preferredCombiner, token)

            println(response)

            if (response?.fqdn != null && response.port != null) {

                val fqdn = response.fqdn
                val port = response.port

                println(response.fqdn)
                println(response.port)

                grpcHandler = GrpcHandler(fqdn, 443, token)

                var counter: Int = 0

                while (counter < 100) {

                    grpcHandler?.sendHeartbeat(name)
                    counter++
                    delay(1000)
                }


            }
        }


    }
}