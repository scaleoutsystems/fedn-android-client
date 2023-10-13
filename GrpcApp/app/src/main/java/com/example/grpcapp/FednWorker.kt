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
import java.nio.FloatBuffer
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.Json
import kotlinx.serialization.encodeToString


@Serializable
data class ModelWeights(
    var layer0: List<Float>,
    var layer1: List<Float>,
    var layer2: List<Float>,
    var layer3: List<Float>
) {}

class FednWorker(appContext: Context, workerParams: WorkerParameters) :
    CoroutineWorker(appContext, workerParams) {

    private val interpreterWrapper: InterpreterWrapper = InterpreterWrapper(applicationContext)

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

    private fun byteArrayToJsonString(byteArray: ByteArray): String {
        return String(byteArray, Charsets.UTF_8)
    }

    private fun convertFromByteArray(modelIn: ByteArray): Pair<ModelWeights?, Boolean> {

        var result: ModelWeights? = null
        var success: Boolean = false

        try {
            val json: String = byteArrayToJsonString(modelIn)
            result = Json.decodeFromString(json)
            success = true
        } catch (e: Exception) {
            println(e.message)
        }

        return Pair(result, success)
    }

    private fun objectToJson(obj: ModelWeights): String {
        return Json.encodeToString(obj)
    }

    private fun toWeightsModel(weights: MutableMap<String, Any>): ModelWeights {

        val layer0 = weights["layer0"] as FloatBuffer
        val layer1 = weights["layer1"] as FloatBuffer
        val layer2 = weights["layer2"] as FloatBuffer
        val layer3 = weights["layer3"] as FloatBuffer

        var listLayer0 = mutableListOf<Float>()

        for (f in layer0.array()) {
            listLayer0.add(f)
        }

        var listLayer1 = mutableListOf<Float>()

        for (f in layer1.array()) {
            listLayer1.add(f)
        }

        var listLayer2 = mutableListOf<Float>()

        for (f in layer2.array()) {
            listLayer2.add(f)
        }

        var listLayer3 = mutableListOf<Float>()

        for (f in layer3.array()) {
            listLayer3.add(f)
        }

        return ModelWeights(listLayer0, listLayer1, listLayer2, listLayer3)
    }

    private val runTrainingProcess: (ByteArray) -> ByteArray = { modelIn ->
        //run training here

        val images: List<List<Float>> = readCsvFile("fashionmnist.csv")
        val labels: List<List<Float>> = readCsvFile("fashionmnist_labels_new.csv")

        var result: ByteArray = modelIn
        val (weights, success) = convertFromByteArray(modelIn)

        if (success && weights != null) {

            val inputs: MutableMap<String, Any> = HashMap()

            val input0: FloatBuffer = FloatBuffer.wrap(weights.layer0.toFloatArray())
            val input1: FloatBuffer = FloatBuffer.wrap(weights.layer1.toFloatArray())
            val input2: FloatBuffer = FloatBuffer.wrap(weights.layer2.toFloatArray())
            val input3: FloatBuffer = FloatBuffer.wrap(weights.layer3.toFloatArray())
            inputs["layer0"] = input0
            inputs["layer1"] = input1
            inputs["layer2"] = input2
            inputs["layer3"] = input3

            interpreterWrapper.setWeights(inputs)
            interpreterWrapper.runTraining(images, labels)
            val weightsAfterTraining = interpreterWrapper.getWeights()

            if (weightsAfterTraining != null) {

                val weights: ModelWeights =
                    toWeightsModel(weightsAfterTraining)

                val json = objectToJson(weights)
                result = json.toByteArray()
            }
        }

        result
    }

    override suspend fun doWork(): Result = withContext(Dispatchers.IO) {

        val connectionString: String? = inputData.getString("CONNECTION_STRING")
        val token: String? = inputData.getString("TOKEN")
        val name: String? = inputData.getString("NAME")

        if (connectionString != null && token != null) {

            val fednClient: IFednClient = FednClient(
                connectionString, token, name = name
            )

            launch {

                val result =
                    fednClient.runProcess(runTrainingProcess, onAttachStateChanged = { state ->

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