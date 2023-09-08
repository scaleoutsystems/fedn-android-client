package com.example.fednclient

import io.ktor.http.HttpStatusCode
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.test.runTest
import org.junit.Assert
import org.junit.Test


class HttpHandlerUnitTests {
    private val connectionString = "connectionString"
    private val name = "name"
    private val token = "token"

    @Test
    fun assign() = runTest {

        val httpClientWrapper = mockk<IHttpClientWrapper<AttachResponse>>()

        val attachResponse: AttachResponse? = AttachResponse()

        val mockResponse = Triple(
            attachResponse, HttpStatusCode.OK, null
        )

        coEvery { httpClientWrapper.httpGet(any(), any()) } returns mockResponse

        val client: IHttpHandler = HttpHandler(httpClientWrapper)

        val onStateChanged: ((state: AttachState) -> Unit)? = { state ->
            Assert.assertNotEquals(AttachState.FAILED, state)
        }


        val (response, responseStatus) = client.attach(
            connectionString, name, token, onStateChanged
        )

        val (statusCode, statusMessage) = responseStatus

        Assert.assertEquals(AttachResponseStatus.OK, statusCode)
        Assert.assertEquals(MESSAGE_OK, statusMessage)
        Assert.assertNotNull(response)
    }

    @Test
    fun assignServerIssues() = runTest {

        val httpClientWrapper = mockk<IHttpClientWrapper<AttachResponse>>()

        val attachResponse: AttachResponse? = null

        val mockResponse = Triple(
            attachResponse, HttpStatusCode.ServiceUnavailable, null
        )

        coEvery { httpClientWrapper.httpGet(any(), any()) } returns mockResponse

        val client: IHttpHandler = HttpHandler(httpClientWrapper)

        val onStateChanged: ((state: AttachState) -> Unit)? = { state ->
            Assert.assertNotEquals(AttachState.ASSIGNED, state)
        }


        val (response, responseStatus) = client.attach(
            connectionString, name, token, onStateChanged
        )

        val (statusCode, statusMessage) = responseStatus

        Assert.assertEquals(AttachResponseStatus.SERVER_RESPONSE_NOT_200, statusCode)
        Assert.assertEquals(MESSAGE_SERVER_RESPONSE_NOT_200, statusMessage)
        Assert.assertNull(response)
    }

    @Test
    fun assignNetworkIssues() = runTest {

        val httpClientWrapper = mockk<IHttpClientWrapper<AttachResponse>>()

        val expectedMessage: String = "Error message"

        val mockResponse = Triple(
            null, null, expectedMessage
        )

        coEvery { httpClientWrapper.httpGet(any(), any()) } returns mockResponse

        val client: IHttpHandler = HttpHandler(httpClientWrapper)

        val onStateChanged: ((state: AttachState) -> Unit)? = { state ->
            Assert.assertNotEquals(AttachState.ASSIGNED, state)
        }

        val (response, responseStatus) = client.attach(
            connectionString, name, token, onStateChanged
        )
        val (statusCode, statusMessage) = responseStatus

        Assert.assertEquals(AttachResponseStatus.ERROR, statusCode)
        Assert.assertEquals(expectedMessage, statusMessage)
        Assert.assertNull(response)
    }
}