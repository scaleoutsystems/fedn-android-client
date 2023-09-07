package com.example.fednclient

import io.ktor.http.HttpStatusCode
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.mockk
import io.mockk.verify
import kotlinx.coroutines.runBlocking
import org.junit.Assert
import org.junit.Test
import kotlin.system.measureTimeMillis
import kotlinx.coroutines.test.runTest

class FednClientUnitTest {

    private val connectionString = "connectionString"
    private val name = "name"
    private val token = "token"

    @Test
    fun attachClientToNetwork() = runTest {

        val httpHandler = mockk<IHttpHandler>()
        val grpcHandler = mockk<IGrpcHandler>()

        val assignResponse: AssignResponse = AssignResponse(fqdn = "fqdn", port = 80)
        val assignResponseStatusCode: AssignResponseStatus = AssignResponseStatus.OK
        val assignResponseMessage: String = AssignResponseStatus.OK.toString()

        coEvery { httpHandler.assign(any(), any(), any()) } returns Pair(
            assignResponse, Pair(assignResponseStatusCode, assignResponseMessage)
        )

        coEvery { grpcHandler.sendHeartbeat() } returns Unit

        val fednClient = FednClient(
            connectionString,
            name,
            token,
            1,
            0,
            _grpcHandler = grpcHandler,
            _httpHandler = httpHandler
        )

        val (msg, result) = fednClient.attachClientToNetwork()

        coVerify(exactly = 1) { httpHandler.assign(any(), any(), any()) }

        Assert.assertTrue(result)
        Assert.assertEquals(msg, MESSAGE_OK)
    }

    @Test
    fun sendHeartbeats() = runTest {

        var grpcHandler = mockk<IGrpcHandler>()
        Assert.assertTrue(true)

        coEvery { grpcHandler.sendHeartbeat() } returns Unit
        Assert.assertTrue(true)

        val fednClient: FednClient = FednClient(
            connectionString, name, token, 10, 0, _grpcHandler = grpcHandler
        )

        fednClient.sendHeartbeats()
        coVerify(exactly = 10) { grpcHandler.sendHeartbeat() }
    }
}