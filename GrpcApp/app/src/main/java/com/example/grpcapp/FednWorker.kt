package com.example.grpcapp

import android.content.Context
import androidx.work.CoroutineWorker
import androidx.work.WorkerParameters
import com.example.fednclient.FednClient
import com.example.fednclient.IFednClient
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.io.BufferedReader
import java.io.FileInputStream
import java.io.InputStreamReader

class FednWorker(appContext: Context, workerParams: WorkerParameters) :
    CoroutineWorker(appContext, workerParams) {

    private fun readCsvFile(fileName: String): List<List<Float>> {

        var fileInputStream: FileInputStream? = applicationContext.openFileInput(fileName)
        var inputStreamReader: InputStreamReader = InputStreamReader(fileInputStream)
        val bufferedReader: BufferedReader = BufferedReader(inputStreamReader)
        var text: String? = null

        val result: MutableList<List<Float>> = mutableListOf()

        while (run {
                text = bufferedReader.readLine()
                text
            } != null) {

            if (text != null) {

                val list: MutableList<Float> = mutableListOf()
                val arr: List<String> = text!!.split(",")

                for (item in arr) {

                    val n: Float = item.toFloat()
                    list.add(n)
                }

                result.add(list)
            }
        }

        return result
    }

    override suspend fun doWork(): Result = withContext(Dispatchers.IO) {

        val connectionString: String? = inputData.getString("CONNECTION_STRING")
        val token: String? = inputData.getString("TOKEN")
        val name: String? = inputData.getString("NAME")

        val images: List<List<Float>> = readCsvFile("fashionmnist.csv")
        val labels: List<List<Float>> = readCsvFile("fashionmnist_labels.csv")

        if (connectionString != null && token != null) {

            val fednClient: IFednClient = FednClient(
                connectionString, token, name = name
            )

            val trainModel: (ByteArray) -> ByteArray = { modelIn ->
                //run training here
                val interpreterWrapper: InterpreterWrapper = InterpreterWrapper(applicationContext)
                interpreterWrapper.runTraining(images, labels)
                modelIn
            }

            launch {

                val result = fednClient.runProcess(trainModel, onAttachStateChanged = { state ->

                    println("onAssignStateChanged: $state")

                }, onUpdateModelStateChanged = { state ->

                    println("onUpdateModelStateChanged $state")

                }, timeoutAfterMillis = 30000
                )

                println(result)
            }
        }

        return@withContext Result.success()
    }
}