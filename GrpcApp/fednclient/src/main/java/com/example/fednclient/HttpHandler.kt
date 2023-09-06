package com.example.fednclient

import io.ktor.http.HttpStatusCode
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable


enum class AssignState {
    INITIALIZED, ASSIGNED, FAILED
}

const val MESSAGE_OK = "Success"
const val MESSAGE_INVALID_URL = "Invalid url"
const val MESSAGE_INVALID_TOKEN = "Invalid token"
const val MESSAGE_SERVER_RESPONSE_NOT_200 = "Server response not 200"
const val MESSAGE_ERROR = "Unknown error. Possibly serialization problems or service unavailable"

enum class AssignResponseStatus(private val displayName: String) {
    OK(MESSAGE_OK), INVALID_URL(MESSAGE_INVALID_URL), INVALID_TOKEN(MESSAGE_INVALID_TOKEN), SERVER_RESPONSE_NOT_200(
        MESSAGE_SERVER_RESPONSE_NOT_200
    ),
    ERROR(MESSAGE_ERROR);

    override fun toString(): String {
        return displayName
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

interface IHttpHandler {
    suspend fun assign(
        connectionString: String,
        name: String,
        token: String,
        onStateChanged: ((state: AssignState) -> Unit)? = null
    ): Pair<AssignResponse?, Pair<AssignResponseStatus, String>>
}

internal class HttpHandler(private val httpClientWrapper: IHttpClientWrapper<AssignResponse>) :
    IHttpHandler {

    override suspend fun assign(
        connectionString: String,
        name: String,
        token: String,
        onStateChanged: ((state: AssignState) -> Unit)?
    ): Pair<AssignResponse?, Pair<AssignResponseStatus, String>> {

        var response: Pair<AssignResponseStatus, String> =
            Pair(AssignResponseStatus.OK, AssignResponseStatus.OK.toString())
        var result: AssignResponse? = null

        val url: String? = getUrl(connectionString, name)
        val verifiedToken: String? = getVerifiedToken(token)

        if (url.isNullOrBlank()) {
            response =
                Pair(AssignResponseStatus.INVALID_URL, AssignResponseStatus.INVALID_URL.toString())
        } else if (verifiedToken.isNullOrBlank()) {
            response = Pair(
                AssignResponseStatus.INVALID_TOKEN,
                AssignResponseStatus.INVALID_TOKEN.toString()
            )
        } else {

            onStateChanged?.invoke(AssignState.INITIALIZED)

            val (assignResponse, statusCode, msg) = httpClientWrapper.httpGet(
                url, verifiedToken
            )

            result = assignResponse

            if (statusCode != null) {

                if (statusCode == HttpStatusCode.OK) {

                    onStateChanged?.invoke(AssignState.ASSIGNED)
                } else {
                    onStateChanged?.invoke(AssignState.FAILED)
                    response = Pair(
                        AssignResponseStatus.SERVER_RESPONSE_NOT_200,
                        AssignResponseStatus.SERVER_RESPONSE_NOT_200.toString()
                    )
                }
            } else {

                response =
                    Pair(AssignResponseStatus.ERROR, msg ?: AssignResponseStatus.ERROR.toString())
            }
        }

        return Pair(result, response)
    }
}
