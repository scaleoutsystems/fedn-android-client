package com.example.fednclient

import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.engine.cio.CIO
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.request.get
import io.ktor.client.request.headers
import io.ktor.client.statement.HttpResponse
import io.ktor.http.HttpHeaders
import io.ktor.http.HttpStatusCode
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.Json


enum class AssignState {
    INITIALIZED,
    ASSIGNED,
    FAILED
}

enum class AssignResponseStatus {
    OK,
    INVALID_URL,
    INVALID_TOKEN,
    SERVER_RESPONSE_NOT_200,
    ERROR
}

internal interface IClient {
    suspend fun assign(
        connectionString: String,
        name: String,
        token: String
    ): Pair<AssignResponse?, AssignResponseStatus>
}

internal class Client : IClient {

    override suspend fun assign(
        connectionString: String,
        name: String,
        token: String
    ): Pair<AssignResponse?, AssignResponseStatus> {

        var response: AssignResponseStatus = AssignResponseStatus.OK
        var result: AssignResponse? = null

        val url: String? = getUrl(connectionString, name)
        val verifiedToken: String? = getVerifiedToken(token)

        if (url.isNullOrBlank()) {
            response = AssignResponseStatus.INVALID_URL
        } else if (verifiedToken.isNullOrBlank()) {
            response = AssignResponseStatus.INVALID_TOKEN
        } else {

            try {

                val client = HttpClient(CIO) {
                    install(ContentNegotiation) {
                        json(Json {
                            prettyPrint = true
                            isLenient = true
                        })
                    }
                    followRedirects = true
                }

                val httpResponse: HttpResponse = client.get(url) {
                    headers {
                        append(HttpHeaders.Authorization, verifiedToken)
                        append(HttpHeaders.Accept, "application/json")
                    }
                }

                if (httpResponse.status == HttpStatusCode.OK) {
                    result = httpResponse.body<AssignResponse>()
                } else {
                    response = AssignResponseStatus.SERVER_RESPONSE_NOT_200
                }

                client.close()
            } catch (e: Exception) {
                response = AssignResponseStatus.ERROR
            }
        }

        return Pair(result, response)
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
