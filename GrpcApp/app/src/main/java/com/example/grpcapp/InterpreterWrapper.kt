package com.example.grpcapp

import android.content.Context
import androidx.compose.ui.unit.dp
import org.tensorflow.lite.Interpreter
import org.tensorflow.lite.Tensor
import org.tensorflow.lite.support.common.FileUtil
import org.tensorflow.lite.support.tensorbuffer.TensorBuffer
import java.nio.ByteBuffer
import java.nio.FloatBuffer

const val IMG_SIZE = 28

const val MODEL_PATH = "fashionmodel.tflite"

class InterpreterWrapper(private val context: Context) {

    fun runTraining(images: List<List<Float>>, labels: List<List<Float>>) {

        Interpreter(FileUtil.loadMappedFile(context, MODEL_PATH)).use { interpreter ->

            try {


                for (i in 0..99) {
                    val trainImage: FloatBuffer =
                        FloatBuffer.allocate(IMG_SIZE * IMG_SIZE)

                    val trainLabel: FloatBuffer = FloatBuffer.allocate(1)

                    val startIdx = i * 28
                    val endIdx = startIdx + 28

                    val image = images.subList(startIdx, endIdx)
                    val label = labels[i]

                    for (row in image) {
                        for (pixel in row) {

                            trainImage.put(pixel)
                        }
                    }

                    for (value in label) {

                        trainLabel.put(value)
                    }

                    trainImage.rewind()
                    trainLabel.rewind()

                    val inputs: MutableMap<String, Any> = HashMap()
                    inputs["x"] = trainImage
                    inputs["y"] = trainLabel

                    val outputs: MutableMap<String, Any> = HashMap()
                    val loss = FloatBuffer.allocate(1)
                    outputs["loss"] = loss

                    interpreter.runSignature(inputs, outputs, "train")

                    println(loss.get(0))
                }

            } catch (e: Exception) {
                println(e.message)
            }
        }
    }


    fun setWeights(
        inputs:
        MutableMap<String, Any>
    ) {

        try {

            Interpreter(FileUtil.loadMappedFile(context, MODEL_PATH)).use { interpreter ->

                val outputs: MutableMap<String, Any> = HashMap()

                interpreter.runSignature(inputs, outputs, "set_weights")
            }
        } catch (e: Exception) {
            println(e.message)
        }
    }

    fun getWeights(): (MutableMap<String, Any>)? {

        try {

            Interpreter(FileUtil.loadMappedFile(context, MODEL_PATH)).use { interpreter ->

                val input: FloatBuffer = FloatBuffer.allocate(1)
                // Run encoding signature.
                val inputs: MutableMap<String, Any> = HashMap()
                inputs["x"] = input

                val outputs: MutableMap<String, Any> = HashMap()

                val output0: FloatBuffer = FloatBuffer.allocate(100352)
                val output1: FloatBuffer = FloatBuffer.allocate(128)
                val output2: FloatBuffer = FloatBuffer.allocate(1280)
                val output3: FloatBuffer = FloatBuffer.allocate(10)
                outputs["layer0"] = output0
                outputs["layer1"] = output1
                outputs["layer2"] = output2
                outputs["layer3"] = output3

                interpreter.runSignature(inputs, outputs, "get_weights")

                return outputs
            }
        } catch (e: Exception) {
            println(e.message)
        }

        return null
    }
}