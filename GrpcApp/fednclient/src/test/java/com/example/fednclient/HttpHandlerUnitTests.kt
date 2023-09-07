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

        val httpClientWrapper = mockk<IHttpClientWrapper<AssignResponse>>()

        val assignResponse: AssignResponse? = AssignResponse()

        val mockResponse = Triple(
            assignResponse, HttpStatusCode.OK, null
        )

        coEvery { httpClientWrapper.httpGet(any(), any()) } returns mockResponse

        val client: IHttpHandler = HttpHandler(httpClientWrapper)

        val onStateChanged: ((state: AssignState) -> Unit)? = { state ->
            Assert.assertNotEquals(AssignState.FAILED, state)
        }


        val (response, responseStatus) = client.assign(
            connectionString, name, token, onStateChanged
        )

        val (statusCode, statusMessage) = responseStatus

        Assert.assertEquals(AssignResponseStatus.OK, statusCode)
        Assert.assertEquals(MESSAGE_OK, statusMessage)
        Assert.assertNotNull(response)
    }

    @Test
    fun assignServerIssues() = runTest {

        val httpClientWrapper = mockk<IHttpClientWrapper<AssignResponse>>()

        val assignResponse: AssignResponse? = null

        val mockResponse = Triple(
            assignResponse, HttpStatusCode.ServiceUnavailable, null
        )

        coEvery { httpClientWrapper.httpGet(any(), any()) } returns mockResponse

        val client: IHttpHandler = HttpHandler(httpClientWrapper)

        val onStateChanged: ((state: AssignState) -> Unit)? = { state ->
            Assert.assertNotEquals(AssignState.ASSIGNED, state)
        }


        val (response, responseStatus) = client.assign(
            connectionString, name, token, onStateChanged
        )

        val (statusCode, statusMessage) = responseStatus

        Assert.assertEquals(AssignResponseStatus.SERVER_RESPONSE_NOT_200, statusCode)
        Assert.assertEquals(MESSAGE_SERVER_RESPONSE_NOT_200, statusMessage)
        Assert.assertNull(response)
    }

    @Test
    fun assignNetworkIssues() = runTest {

        val httpClientWrapper = mockk<IHttpClientWrapper<AssignResponse>>()

        val expectedMessage: String = "Error message"

        val mockResponse = Triple(
            null, null, expectedMessage
        )

        coEvery { httpClientWrapper.httpGet(any(), any()) } returns mockResponse

        val client: IHttpHandler = HttpHandler(httpClientWrapper)

        val onStateChanged: ((state: AssignState) -> Unit)? = { state ->
            Assert.assertNotEquals(AssignState.ASSIGNED, state)
        }

        val (response, responseStatus) = client.assign(
            connectionString, name, token, onStateChanged
        )
        val (statusCode, statusMessage) = responseStatus

        Assert.assertEquals(AssignResponseStatus.ERROR, statusCode)
        Assert.assertEquals(expectedMessage, statusMessage)
        Assert.assertNull(response)
    }
}