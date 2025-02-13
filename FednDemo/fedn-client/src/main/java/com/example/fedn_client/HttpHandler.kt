package com.example.fedn_client

import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.engine.cio.CIO
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.request.headers
import io.ktor.client.request.post
import io.ktor.client.request.setBody
import io.ktor.http.ContentType
import io.ktor.http.HttpHeaders
import io.ktor.http.HttpStatusCode
import io.ktor.http.contentType
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.Json


enum class AttachState {
    INITIALIZED, ASSIGNED, FAILED
}

const val MESSAGE_OK = "Success"
const val MESSAGE_INVALID_URL = "Invalid url"
const val MESSAGE_INVALID_TOKEN = "Invalid token"
const val MESSAGE_SERVER_RESPONSE_NOT_200 = "Server response not 200"
const val MESSAGE_ERROR = "Unknown error. Possibly serialization problems or service unavailable"

enum class AttachResponseStatus(private val displayName: String) {
    OK(MESSAGE_OK), INVALID_URL(MESSAGE_INVALID_URL), INVALID_TOKEN(MESSAGE_INVALID_TOKEN), SERVER_RESPONSE_NOT_200(
        MESSAGE_SERVER_RESPONSE_NOT_200
    ),
    ERROR(MESSAGE_ERROR);

    override fun toString(): String {
        return displayName
    }
}

@Serializable
data class AddClientResponse(
    val status: String? = null,
    val host: String? = null,
    val fqdn: String? = null,
    val ip: String? = null,
    val port: Int? = null,
    val certificate: String? = null,
    @SerialName("helper_type") val helperType: String? = null,
    @SerialName("package") val myPackage: String? = null,
)

@Serializable
data class AddClientBody(val client_id: String, val preferred_combiner: String?, val name: String?)

@Serializable
data class AnalyticsResponse(
    val id: String? = null,
    val status: String? = null,
    val type: String? = null,
    @SerialName("client_id") val clientId: String? = null,
    @SerialName("model_id") val modelId: String? = null,
)

@Serializable
data class AnalyticsBody(
    val client_id: String,
    val model_id: String,
    val type: String,
    val execution_duration: Long
)


interface IHttpHandler {
    suspend fun attach(
        connectionString: String,
        id: String,
        token: String,
        name: String?,
        onStateChanged: ((state: AttachState) -> Unit)? = null
    ): Pair<AddClientResponse?, Pair<AttachResponseStatus, String>>

    suspend fun sendAnalytics(
        connectionString: String,
        token: String,
        id: String,
        executionDuration: Long,
        modelId: String,
        type: String
    ): Pair<AnalyticsResponse?, Boolean>
}

internal class HttpHandler() :
    IHttpHandler {

    override suspend fun attach(
        connectionString: String,
        id: String,
        token: String,
        name: String?,
        onStateChanged: ((state: AttachState) -> Unit)?
    ): Pair<AddClientResponse?, Pair<AttachResponseStatus, String>> {

        var response: Pair<AttachResponseStatus, String> =
            Pair(AttachResponseStatus.OK, AttachResponseStatus.OK.toString())
        var result: AddClientResponse? = null

        val url: String? = getAddClientUrl(connectionString)
        val verifiedToken: String? = getVerifiedToken(token)

        if (url.isNullOrBlank()) {
            response =
                Pair(AttachResponseStatus.INVALID_URL, AttachResponseStatus.INVALID_URL.toString())
        } else if (verifiedToken.isNullOrBlank()) {
            response = Pair(
                AttachResponseStatus.INVALID_TOKEN, AttachResponseStatus.INVALID_TOKEN.toString()
            )
        } else {

            onStateChanged?.invoke(AttachState.INITIALIZED)

            val (attachResponse, statusCode, msg) = attachClientPost(
                url, verifiedToken, id, name
            )

            result = attachResponse

            if (statusCode != null) {

                if (statusCode == HttpStatusCode.OK) {

                    onStateChanged?.invoke(AttachState.ASSIGNED)
                } else {
                    onStateChanged?.invoke(AttachState.FAILED)
                    response = Pair(
                        AttachResponseStatus.SERVER_RESPONSE_NOT_200,
                        AttachResponseStatus.SERVER_RESPONSE_NOT_200.toString()
                    )
                }
            } else {

                response =
                    Pair(AttachResponseStatus.ERROR, msg ?: AttachResponseStatus.ERROR.toString())
            }
        }

        return Pair(result, response)
    }

    private suspend fun attachClientPost(
        url: String,
        token: String,
        id: String,
        name: String?,
    ): Triple<AddClientResponse?, HttpStatusCode?, String?> {

        val httpClient: HttpClient = HttpClient(CIO) {
            install(ContentNegotiation) {
                json(Json {
                    prettyPrint = true
                    isLenient = true
                })
            }
            followRedirects = true
        }

        val result = try {

            val httpResponse = httpClient.post(url) {
                headers {
                    append(HttpHeaders.Authorization, token)
                    append(HttpHeaders.Accept, "application/json")
                }
                contentType(ContentType.Application.Json)
                setBody(AddClientBody(client_id = id, preferred_combiner = null, name = name))
            }

            val result: AddClientResponse? = if (httpResponse.status == HttpStatusCode.OK) {
                httpResponse.body<AddClientResponse>()
            } else null

            Triple(result, httpResponse.status, null)

        } catch (e: Exception) {

            println(e.message)
            Triple(null, null, e.message)
        }

        httpClient.close()

        return result
    }

    override suspend fun sendAnalytics(
        connectionString: String,
        token: String,
        id: String,
        executionDuration: Long,
        modelId: String,
        type: String
    ): Pair<AnalyticsResponse?, Boolean> {
        val url: String? = getAnalyticsUrl(connectionString)
        val verifiedToken: String? = getVerifiedToken(token)

        if (url.isNullOrBlank() || verifiedToken.isNullOrBlank()) {
            return Pair(null, false)
        }

        val httpClient: HttpClient = HttpClient(CIO) {
            install(ContentNegotiation) {
                json(Json {
                    prettyPrint = true
                    isLenient = true
                })
            }
            followRedirects = true
        }

        val result = try {

            val httpResponse = httpClient.post(url) {
                headers {
                    append(HttpHeaders.Authorization, token)
                    append(HttpHeaders.Accept, "application/json")
                }
                contentType(ContentType.Application.Json)
                setBody(
                    AnalyticsBody(
                        client_id = id,
                        model_id = modelId,
                        type = type,
                        execution_duration = executionDuration
                    )
                )
            }

            val result: AnalyticsResponse? = if (httpResponse.status == HttpStatusCode.OK) {
                httpResponse.body<AnalyticsResponse>()
            } else null

            Pair(result, httpResponse.status == HttpStatusCode.OK)

        } catch (e: Exception) {

            println(e.message)
            Pair(null, false)
        }

        httpClient.close()

        return result
    }
}
