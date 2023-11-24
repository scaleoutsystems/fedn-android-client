package com.example.fedn_client

import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.engine.cio.CIO
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.request.get
import io.ktor.client.request.headers
import io.ktor.client.request.post
import io.ktor.client.request.setBody
import io.ktor.http.ContentType
import io.ktor.http.HttpHeaders
import io.ktor.http.HttpStatusCode
import io.ktor.http.contentType
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json
import kotlinx.serialization.Serializable

@Serializable
data class AddClientBody(val client_id: String, val preferred_combiner: String?)
interface IHttpClientWrapper<T> {

    suspend fun httpGet(
        url: String, token: String
    ): Triple<T?, HttpStatusCode?, String?>

    suspend fun httpPost(
        url: String, token: String, name: String
    ): Triple<T?, HttpStatusCode?, String?>
}

class HttpClientAssignWrapper : IHttpClientWrapper<AddClientResponse> {

    override suspend fun httpGet(
        url: String, token: String
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

            val httpResponse = httpClient.get(url) {
                headers {
                    append(HttpHeaders.Authorization, token)
                    append(HttpHeaders.Accept, "application/json")
                }
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

    override suspend fun httpPost(
        url: String,
        token: String,
        name: String
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
                setBody(AddClientBody(client_id = name, preferred_combiner = null))
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
}