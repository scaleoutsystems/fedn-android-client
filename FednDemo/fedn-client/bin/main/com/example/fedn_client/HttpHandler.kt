package com.example.fedn_client

import io.ktor.http.HttpStatusCode
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable


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
    val msg: String? = null,
    val helper_type: String? = null,
    @SerialName("package") val myPackage: String? = null,
    @SerialName("model_type") val modelType: String? = null
)

interface IHttpHandler {
    suspend fun attach(
        connectionString: String,
        name: String,
        token: String,
        onStateChanged: ((state: AttachState) -> Unit)? = null
    ): Pair<AddClientResponse?, Pair<AttachResponseStatus, String>>
}

internal class HttpHandler(private val httpClientWrapper: IHttpClientWrapper<AddClientResponse>) :
    IHttpHandler {

    override suspend fun attach(
        connectionString: String,
        name: String,
        token: String,
        onStateChanged: ((state: AttachState) -> Unit)?
    ): Pair<AddClientResponse?, Pair<AttachResponseStatus, String>> {

        var response: Pair<AttachResponseStatus, String> =
            Pair(AttachResponseStatus.OK, AttachResponseStatus.OK.toString())
        var result: AddClientResponse? = null

        val url: String? = getUrl(connectionString)
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

            val (attachResponse, statusCode, msg) = httpClientWrapper.httpPost(
                url, verifiedToken, name
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
}
