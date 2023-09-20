package com.example.fednclient

import android.content.Context
import org.tensorflow.lite.Interpreter
import org.tensorflow.lite.support.common.FileUtil
import java.nio.FloatBuffer


const val IMG_SIZE = 28
const val MODEL_PATH = "model.tflite"

class InterpreterWrapper(private val context: Context) {

    fun runInference(images: List<List<Float>>) {

        Interpreter(FileUtil.loadMappedFile(context, MODEL_PATH)).use { interpreter ->

            try {

                val image = images.take(28)

                val trainImages: FloatBuffer =
                    FloatBuffer.allocate(IMG_SIZE * IMG_SIZE)

                for (row in image) {
                    for (pixel in row) {

                        trainImages.put(pixel)
                    }
                }

                trainImages.rewind()

                // Run encoding signature.
                val inputs: MutableMap<String, Any> =
                    HashMap()
                inputs["x"] = trainImages

                val outputs: MutableMap<String, Any> =
                    HashMap()

                val output = FloatBuffer.allocate(10)
                val logits = FloatBuffer.allocate(10)
                outputs["output"] = output
                outputs["logits"] = logits

                interpreter.runSignature(inputs, outputs, "infer")

                val output1 = outputs["output"]
                val confidences = outputs["logits"]

                println(output1)
                println(confidences)

            } catch (e: Exception) {
                println(e.message)
            }
        }
    }
}