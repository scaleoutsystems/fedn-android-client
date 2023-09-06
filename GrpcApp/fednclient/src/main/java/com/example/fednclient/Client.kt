package com.example.fednclient

import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.client.request.headers
import io.ktor.client.statement.HttpResponse
import io.ktor.http.HttpHeaders
import io.ktor.http.HttpStatusCode
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable


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

internal interface IClient {
    suspend fun assign(
        connectionString: String,
        name: String,
        token: String,
        onStateChanged: ((state: AssignState) -> Unit)? = null
    ): Pair<AssignResponse?, AssignResponseStatus>
}

internal class Client(private val httpClientWrapper: IHttpClientWrapper<AssignResponse>) : IClient {

    override suspend fun assign(
        connectionString: String,
        name: String,
        token: String,
        onStateChanged: ((state: AssignState) -> Unit)?
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

            onStateChanged?.invoke(AssignState.INITIALIZED)

            val (assignResponse, statusCode, successful) = httpClientWrapper.httpGet(
                url,
                verifiedToken
            )

            result = assignResponse

            if (successful) {

                if (statusCode == HttpStatusCode.OK) {

                    onStateChanged?.invoke(AssignState.ASSIGNED)
                } else {
                    onStateChanged?.invoke(AssignState.FAILED)
                    response = AssignResponseStatus.SERVER_RESPONSE_NOT_200
                }
            } else {
                response = AssignResponseStatus.ERROR
            }
        }

        return Pair(result, response)
    }
}
