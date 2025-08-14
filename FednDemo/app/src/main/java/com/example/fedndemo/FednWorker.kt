package com.example.fedndemo

import android.content.Context
import androidx.work.CoroutineWorker
import androidx.work.WorkerParameters
import androidx.work.workDataOf
import com.example.fedn_client.FednClient
import com.example.fedn_client.IFednClient
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.io.BufferedReader
import java.io.InputStreamReader
import java.nio.FloatBuffer
import kotlinx.serialization.Serializable
import java.io.InputStream
import java.nio.ByteBuffer
import java.nio.ByteOrder

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
        var text: String?

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

    private fun convertFromByteArray(modelIn: ByteArray): Pair<ModelWeights?, Boolean> {

        var result: ModelWeights? = null
        var success: Boolean = false

        try {
            val floatArray = FloatArray(modelIn.size / 4)
            ByteBuffer.wrap(modelIn).order(ByteOrder.LITTLE_ENDIAN).asFloatBuffer().get(floatArray)

            val floatArrayList = floatArray.toList()

            val layer0 = floatArrayList.subList(0, 100352)
            val layer1 = floatArrayList.subList(100352, 100352 + 128)
            val layer2 = floatArrayList.subList(100352 + 128, 100352 + 128 + 1280)
            val layer3 = floatArrayList.subList(100352 + 128 + 1280, 100352 + 128 + 1280 + 10)

            result = ModelWeights(
                layer0 = layer0,
                layer1 = layer1,
                layer2 = layer2,
                layer3 = layer3
            )

            success = true
        } catch (e: Exception) {
            println(e.message)
        }

        return Pair(result, success)
    }

    private fun floatArrayToByteArray(floatArray: FloatArray): ByteArray {
        val byteBuffer = ByteBuffer.allocate(floatArray.size * 4) // 4 bytes per float
        byteBuffer.order(ByteOrder.LITTLE_ENDIAN) // Choose the byte order (little-endian or big-endian)

        for (value in floatArray) {
            byteBuffer.putFloat(value)
        }

        return byteBuffer.array()
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

                val modelWeightsAfterTraining
                        : ModelWeights = toWeightsModel(weightsAfterTraining)

                val oneDimensional: FloatArray = (modelWeightsAfterTraining
                    .layer0 + modelWeightsAfterTraining
                    .layer1 + modelWeightsAfterTraining
                    .layer2 + modelWeightsAfterTraining
                    .layer3).toFloatArray()

                result = floatArrayToByteArray(oneDimensional)
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
        val id: String? = inputData.getString("ID")
        val timeoutAfterMillis: Long = inputData.getLong("TIMEOUT_AFTER_MILLIS", 30000)

        if (connectionString != null && token != null) {

            val client = FednClientManager.getOrCreate(
                FednParams(connectionString = connectionString, token = token, name = name, id = id)
            )


            setProgress(workDataOf(Progress to "Client connecting"))

            launch {

                val result =
                    client.runProcess(runTrainingProcess, onAttachStateChanged = { state ->

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