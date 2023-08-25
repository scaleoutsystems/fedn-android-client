package com.example.fednclient

import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.engine.cio.CIO
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.request.get
import io.ktor.client.request.headers
import io.ktor.client.statement.HttpResponse
import io.ktor.http.HttpHeaders
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.Json

interface IClient {
    suspend fun assign(
        connectionString: String,
        name: String,
        preferredCombiner: String?,
        token: String
    ): AssignResponse?
}

class Client : IClient {

    private val clientHelper: IClientHelper = ClientHelper()

    override suspend fun assign(
        connectionString: String,
        name: String,
        preferredCombiner: String?,
        token: String
    ): AssignResponse? {

        val url = clientHelper.getUrl(connectionString, name, preferredCombiner)

        val verifiedToken: String = clientHelper.getVerifiedToken(token)

        if (!url.isNullOrBlank() && verifiedToken.isNotEmpty()) {

            val client = HttpClient(CIO) {
                install(ContentNegotiation) {
                    json(Json {
                        prettyPrint = true
                        isLenient = true
                    })
                }
                followRedirects = true
            }

            val response: HttpResponse = client.get(url) {
                headers {
                    append(HttpHeaders.Authorization, verifiedToken)
                    append(HttpHeaders.Accept, "application/json")
                }
            }

            val res = response.body<AssignResponse>()
            client.close()

            return res
        }

        return null
    }
}

@Serializable
data class AssignResponse(
    val status: String? = null,
    val host: String? = null,
    val fqdn: String? = null,
    val ip: String? = null,
    val port: Int? = null,
    val certificate: String? = null,
    val msg: String? = null,
    @SerialName("package") val myPackage: String? = null,
    @SerialName("model_type") val modelType: String? = null
)
