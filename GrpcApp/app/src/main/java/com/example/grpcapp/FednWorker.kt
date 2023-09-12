package com.example.grpcapp

import android.content.Context
import androidx.work.CoroutineWorker
import androidx.work.WorkerParameters
import com.example.fednclient.FednClient
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class FednWorker(appContext: Context, workerParams: WorkerParameters) :
    CoroutineWorker(appContext, workerParams) {

    override suspend fun doWork(): Result =
        withContext(Dispatchers.IO) {

            val fednClient: FednClient = FednClient(
                "https://r80ea7a19.studio.scaleoutsystems.com",
                "niklastestclient2",
                "393fc4d2973c52b785870276e2a701a71bcc29c5",
                maxNumberOfHearbeats = 500
            )

            val trainModel: (ByteArray) -> ByteArray = { modelIn ->
                //run training here
                modelIn
            }

            fednClient.runProcess(trainModel, onAttachStateChanged = { state ->

                println("onAssignStateChanged: $state")

            }, onUpdateModelStateChanged = { state ->

                println("onUpdateModelStateChanged $state")

            })

            return@withContext Result.success()
        }
}