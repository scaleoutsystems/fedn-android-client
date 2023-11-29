package com.example.fedndemo

import android.content.Context
import androidx.work.CoroutineWorker
import androidx.work.WorkerParameters
import androidx.work.workDataOf
import com.example.fedn_client.AttachState
import com.example.fedn_client.FednClient
import com.example.fedn_client.IFednClient
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withContext
import java.io.BufferedReader
import java.io.FileInputStream
import java.io.InputStreamReader
import java.nio.FloatBuffer
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.Json
import kotlinx.serialization.encodeToString
import java.io.InputStream


@Serializable
data class ModelWeights(
    var layer0: List<Float>,
    var layer1: List<Float>,
    var layer2: List<Float>,
    var layer3: List<Float>
) {}

const val IMAGES_PATH = "images.csv"
const val LABELS_PATH = "labels.csv"


class FednWorker(appContext: Context, workerParams: WorkerParameters) :
    CoroutineWorker(appContext, workerParams) {

    private val interpreterWrapper: InterpreterWrapper = InterpreterWrapper(appContext)

    private fun readCsvFile(fileName: String): List<List<Float>> {

        var fileInputStream: InputStream = applicationContext.assets.open(fileName)
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

        val images: List<List<Float>> = readCsvFile(IMAGES_PATH)
        val labels: List<List<Float>> = readCsvFile(LABELS_PATH)

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

            val weightsAfterTraining = interpreterWrapper.runTraining(images, labels, inputs)

            if (weightsAfterTraining != null) {

                val weights: ModelWeights = toWeightsModel(weightsAfterTraining)

                val json = objectToJson(weights)
                result = json.toByteArray()
            }
        }

        result
    }

    companion object {
        const val Progress = "Progress"
    }

    override suspend fun doWork(): Result = withContext(Dispatchers.IO) {
        val connectionString: String? = inputData.getString("CONNECTION_STRING")
        val token: String? = inputData.getString("TOKEN")
        val name: String? = inputData.getString("NAME")
        val timeoutAfterMillis: Long = inputData.getLong("TIMEOUT_AFTER_MILLIS", 30000)

        if (connectionString != null && token != null) {

            val fednClient: IFednClient = FednClient(
                connectionString, token, name = name
            )

            setProgress(workDataOf(Progress to "Client connecting"))

            launch {

                val result =
                    fednClient.runProcess(runTrainingProcess, onAttachStateChanged = { state ->

                        launch {
                            setProgress(workDataOf(Progress to state.toString()))
                        }
                        println("onAssignStateChanged: $state")

                    }, onUpdateModelStateChanged = { state ->

                        launch {
                            setProgress(workDataOf(Progress to state.toString()))
                        }
                        println("onUpdateModelStateChanged $state")

                    }, timeoutAfterMillis = timeoutAfterMillis)

                println(result)
            }
        }

        return@withContext Result.success()
    }
}