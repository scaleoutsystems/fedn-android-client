package com.example.fednclient

import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.mockk
import org.junit.Assert
import org.junit.Test
import kotlinx.coroutines.test.runTest

class FednClientUnitTest {

    private val connectionString = "connectionString"
    private val name = "name"
    private val token = "token"

    @Test
    fun listenToModelUpdateRequestStream() = runTest {

        val grpcHandler = mockk<IGrpcHandler>()

        coEvery { grpcHandler.listenToModelUpdateRequestStream() } returns Unit

        val fednClient = FednClient(
            connectionString,
            name,
            token,
            1,
            0,
            _grpcHandler = grpcHandler,
        )

        fednClient.attached = true
        fednClient.heartbeatsInitiated = true

        val (_, result) = fednClient.listenToModelUpdateRequestStream()
        coVerify(exactly = 1) { grpcHandler.listenToModelUpdateRequestStream() }

        Assert.assertTrue(result)
        Assert.assertTrue(fednClient.listeningToModelUpdate)
    }

    @Test
    fun listenToModelUpdateRequestStreamNoGrpcHandler() = runTest {

        val fednClient = FednClient(
            connectionString,
            name,
            token,
            1,
            0,
        )

        val (msg, result) = fednClient.listenToModelUpdateRequestStream()

        Assert.assertFalse(result)
        Assert.assertEquals(msg, MESSAGE_GRPC_HANDLER_NOT_INITIALIZED)
    }

    @Test
    fun listenToModelUpdateRequestStreamHeartbeatsNotInitialized() = runTest {

        val grpcHandler = mockk<IGrpcHandler>()

        coEvery { grpcHandler.listenToModelUpdateRequestStream() } returns Unit

        val fednClient = FednClient(
            connectionString,
            name,
            token,
            1,
            0,
            _grpcHandler = grpcHandler,
        )

        fednClient.attached = true

        val (msg, result) = fednClient.listenToModelUpdateRequestStream()

        Assert.assertFalse(result)
        Assert.assertEquals(msg, MESSAGE_HEARTBEATS_NOT_INITIALIZED)
    }

    @Test
    fun attachClientToNetwork() = runTest {

        val httpHandler = mockk<IHttpHandler>()
        val grpcHandler = mockk<IGrpcHandler>()

        val attachResponse: AttachResponse = AttachResponse(fqdn = "fqdn", port = 80)
        val attachResponseStatusCode: AttachResponseStatus = AttachResponseStatus.OK
        val assignResponseMessage: String = AttachResponseStatus.OK.toString()

        coEvery { httpHandler.attach(any(), any(), any()) } returns Pair(
            attachResponse, Pair(attachResponseStatusCode, assignResponseMessage)
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

        coVerify(exactly = 1) { httpHandler.attach(any(), any(), any()) }

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