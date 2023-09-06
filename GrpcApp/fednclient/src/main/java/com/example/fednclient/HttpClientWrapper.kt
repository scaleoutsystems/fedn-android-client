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
import kotlinx.serialization.json.Json
import java.io.Closeable

interface IHttpClientWrapper<T> : Closeable {

    suspend fun httpGet(
        url: String, token: String
    ): Triple<T?, HttpStatusCode?, String?>
}


class HttpClientAssignWrapper : IHttpClientWrapper<AssignResponse> {

    private val httpClient: HttpClient = HttpClient(CIO) {
        install(ContentNegotiation) {
            json(Json {
                prettyPrint = true
                isLenient = true
            })
        }
        followRedirects = true
    }

    override suspend fun httpGet(
        url: String, token: String
    ): Triple<AssignResponse?, HttpStatusCode?, String?> {

        try {

            val httpResponse: HttpResponse = httpClient.get(url) {
                headers {
                    append(HttpHeaders.Authorization, token)
                    append(HttpHeaders.Accept, "application/json")
                }
            }

            val result: AssignResponse? = if (httpResponse.status == HttpStatusCode.OK) {
                httpResponse.body<AssignResponse>()
            } else null

            return Triple(result, httpResponse.status, null)

        } catch (e: Exception) {

            println(e.message)

            return Triple(null, null, e.message)
        }
    }

    override fun close() {
        httpClient.close()
    }
}