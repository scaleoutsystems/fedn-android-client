package com.example.fednclient

import io.ktor.http.HttpStatusCode
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.runBlocking
import org.junit.Assert
import org.junit.Test


class ClientUnitTests {
    private val connectionString = "connectionString"
    private val name = "name"
    private val token = "token"

    @Test
    fun assign() {

        val httpClientWrapper = mockk<IHttpClientWrapper<AssignResponse>>()

        val assignResponse: AssignResponse? = AssignResponse()

        val response = Triple(
            assignResponse, HttpStatusCode.OK, true
        )

        coEvery { httpClientWrapper.httpGet(any(), any()) } returns response

        val client: IClient = Client(httpClientWrapper)

        val onStateChanged: ((state: AssignState) -> Unit)? = { state ->
            Assert.assertNotEquals(AssignState.FAILED, state)
        }

        runBlocking {

            val (response, responseStatus) = client.assign(
                connectionString, name, token, onStateChanged
            )

            Assert.assertEquals(AssignResponseStatus.OK, responseStatus)
            Assert.assertNotNull(response)
        }
    }

    @Test
    fun assignServerIssues() {

        val httpClientWrapper = mockk<IHttpClientWrapper<AssignResponse>>()

        val assignResponse: AssignResponse? = null

        val response = Triple(
            assignResponse, HttpStatusCode.ServiceUnavailable, true
        )

        coEvery { httpClientWrapper.httpGet(any(), any()) } returns response

        val client: IClient = Client(httpClientWrapper)

        val onStateChanged: ((state: AssignState) -> Unit)? = { state ->
            Assert.assertNotEquals(AssignState.ASSIGNED, state)
        }

        runBlocking {

            val (response, responseStatus) = client.assign(
                connectionString, name, token, onStateChanged
            )

            Assert.assertEquals(AssignResponseStatus.SERVER_RESPONSE_NOT_200, responseStatus)
            Assert.assertNull(response)
        }
    }

    @Test
    fun assignNetworkIssues() {

        val httpClientWrapper = mockk<IHttpClientWrapper<AssignResponse>>()

        val assignResponse: AssignResponse? = null

        val response = Triple(
            assignResponse, null, false
        )

        coEvery { httpClientWrapper.httpGet(any(), any()) } returns response

        val client: IClient = Client(httpClientWrapper)

        val onStateChanged: ((state: AssignState) -> Unit)? = { state ->
            Assert.assertNotEquals(AssignState.ASSIGNED, state)
        }

        runBlocking {

            val (response, responseStatus) = client.assign(
                connectionString, name, token, onStateChanged
            )

            Assert.assertEquals(AssignResponseStatus.ERROR, responseStatus)
            Assert.assertNull(response)
        }
    }
}