package com.example.fednclient

import io.ktor.http.HttpStatusCode
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.runBlocking
import org.junit.Assert
import org.junit.Test


class HttpHandlerUnitTests {
    private val connectionString = "connectionString"
    private val name = "name"
    private val token = "token"

    @Test
    fun assign() {

        val httpClientWrapper = mockk<IHttpClientWrapper<AssignResponse>>()

        val assignResponse: AssignResponse? = AssignResponse()

        val response = Triple(
            assignResponse, HttpStatusCode.OK, null
        )

        coEvery { httpClientWrapper.httpGet(any(), any()) } returns response

        val client: IHttpHandler = HttpHandler(httpClientWrapper)

        val onStateChanged: ((state: AssignState) -> Unit)? = { state ->
            Assert.assertNotEquals(AssignState.FAILED, state)
        }

        runBlocking {

            val (response, responseStatus) = client.assign(
                connectionString, name, token, onStateChanged
            )

            val (statusCode, statusMessage) = responseStatus

            Assert.assertEquals(AssignResponseStatus.OK, statusCode)
            Assert.assertEquals(MESSAGE_OK, statusMessage)
            Assert.assertNotNull(response)
        }
    }

    @Test
    fun assignServerIssues() {

        val httpClientWrapper = mockk<IHttpClientWrapper<AssignResponse>>()

        val assignResponse: AssignResponse? = null

        val response = Triple(
            assignResponse, HttpStatusCode.ServiceUnavailable, null
        )

        coEvery { httpClientWrapper.httpGet(any(), any()) } returns response

        val client: IHttpHandler = HttpHandler(httpClientWrapper)

        val onStateChanged: ((state: AssignState) -> Unit)? = { state ->
            Assert.assertNotEquals(AssignState.ASSIGNED, state)
        }

        runBlocking {

            val (response, responseStatus) = client.assign(
                connectionString, name, token, onStateChanged
            )

            val (statusCode, statusMessage) = responseStatus

            Assert.assertEquals(AssignResponseStatus.SERVER_RESPONSE_NOT_200, statusCode)
            Assert.assertEquals(MESSAGE_SERVER_RESPONSE_NOT_200, statusMessage)
            Assert.assertNull(response)
        }
    }

    @Test
    fun assignNetworkIssues() {

        val httpClientWrapper = mockk<IHttpClientWrapper<AssignResponse>>()

        val expectedMessage: String = "Error message"

        val response = Triple(
            null, null, expectedMessage
        )

        coEvery { httpClientWrapper.httpGet(any(), any()) } returns response

        val client: IHttpHandler = HttpHandler(httpClientWrapper)

        val onStateChanged: ((state: AssignState) -> Unit)? = { state ->
            Assert.assertNotEquals(AssignState.ASSIGNED, state)
        }

        runBlocking {

            val (response, responseStatus) = client.assign(
                connectionString, name, token, onStateChanged
            )
            val (statusCode, statusMessage) = responseStatus

            Assert.assertEquals(AssignResponseStatus.ERROR, statusCode)
            Assert.assertEquals(expectedMessage, statusMessage)
            Assert.assertNull(response)
        }
    }
}