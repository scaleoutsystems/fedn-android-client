package com.example.grpcapp

import android.content.Context
import androidx.work.Worker
import androidx.work.WorkerParameters
import com.example.fednclient.FednClient
import kotlinx.coroutines.runBlocking

class FednWorker(appContext: Context, workerParams: WorkerParameters) :
    Worker(appContext, workerParams) {

    override fun doWork(): Result {

        val fednClient: FednClient = FednClient(
            "https://r80ea7a19.studio.scaleoutsystems.com",
            "niklastestclient2",
            "393fc4d2973c52b785870276e2a701a71bcc29c5",
            maxNumberOfHearbeats = 500
        )

        runBlocking {

            fednClient.runProcess(onAttachStateChanged = { state ->

                println("onAssignStateChanged: $state")

            }, onUpdateModelStateChanged = { state ->

                println("onUpdateModelStateChanged $state")

            })
        }

        return Result.success()
    }
}