package com.example.fednclient

import io.ktor.http.HttpHeaders
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.Json
import io.ktor.client.HttpClient
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.statement.HttpResponse
import io.ktor.client.engine.cio.CIO
import io.ktor.client.request.get
import io.ktor.serialization.kotlinx.json.json
import io.ktor.client.request.headers
import io.ktor.client.call.body

interface IClient {
    suspend fun assign(
        connectionString: String,
        name: String,
        preferredCombiner: String?,
        token: String
    ): AssignResponse?
}

class Client : IClient {

    private fun getUrl(
        connectionString: String,
        name: String,
        preferredCombiner: String?
    ): String? {

        val valid = connectionString.isNotEmpty() && name.isNotEmpty()

        val preferredCombinerStr: String =
            if (!preferredCombiner.isNullOrEmpty()) "&combiner=$preferredCombiner" else ""

        val connectionStringStr =
            if (connectionString.contains("http")) connectionString else "http://$connectionString"

        return if (valid) "$connectionStringStr/assign?name=$name$preferredCombinerStr" else null
    }

    private fun getVerifiedToken(token: String): String {

        var result = ""

        if (token.isNotEmpty()) {
            result = if (token.startsWith("Token ")) token else "Token $token"
        }

        return result
    }

    override suspend fun assign(
        connectionString: String,
        name: String,
        preferredCombiner: String?,
        token: String
    ): AssignResponse? {

        val url = getUrl(connectionString, name, preferredCombiner)

        val verifiedToken: String = getVerifiedToken(token)

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
