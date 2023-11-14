package com.example.grpcapp

import android.content.Context
import kotlinx.serialization.json.Json
import java.io.BufferedReader
import java.io.File
import java.io.FileInputStream
import java.io.InputStreamReader
import java.nio.FloatBuffer

class InternalTraining(private val appContext: Context) {

    private val interpreterWrapper: InterpreterWrapper = InterpreterWrapper(appContext)

    private fun readCsvFile(fileName: String): List<List<Float>> {

        var fileInputStream: FileInputStream? = appContext.openFileInput(fileName)
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

    fun runTrainingProcess() {

        val images: List<List<Float>> = readCsvFile("fashionmnist.csv")
        val labels: List<List<Float>> = readCsvFile("fashionmnist_labels_new.csv")
        val weights = getWeights()

        if (weights != null) {

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

        }

    }

    private fun getWeights(): ModelWeights? {

        var result: ModelWeights? = null

        try {
            val jsonFile = File(appContext.filesDir,"weights")
            val json = jsonFile.readText()
            result = Json.decodeFromString(json)
        } catch (e: Exception) {
            println(e.message)
        }

        return result
    }
}