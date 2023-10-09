package com.example.fednclient

import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.engine.cio.CIO
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.request.get
import io.ktor.client.request.headers
import io.ktor.http.HttpHeaders
import io.ktor.http.HttpStatusCode
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json

interface IHttpClientWrapper<T> {

    suspend fun httpGet(
        url: String, token: String
    ): Triple<T?, HttpStatusCode?, String?>
}

class HttpClientAssignWrapper : IHttpClientWrapper<AttachResponse> {

    override suspend fun httpGet(
        url: String, token: String
    ): Triple<AttachResponse?, HttpStatusCode?, String?> {

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

            val httpResponse = httpClient.get(url) {
                headers {
                    append(HttpHeaders.Authorization, token)
                    append(HttpHeaders.Accept, "application/json")
                }
            }

            val result: AttachResponse? = if (httpResponse.status == HttpStatusCode.OK) {
                httpResponse.body<AttachResponse>()
            } else null

            Triple(result, httpResponse.status, null)

        } catch (e: Exception) {

            println(e.message)
            Triple(null, null, e.message)
        }

        httpClient.close()

        return result
    }
}