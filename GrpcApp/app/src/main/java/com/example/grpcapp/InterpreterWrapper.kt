package com.example.grpcapp

import android.content.Context
import androidx.compose.ui.unit.dp
import org.tensorflow.lite.Interpreter
import org.tensorflow.lite.support.common.FileUtil
import java.nio.FloatBuffer


const val IMG_SIZE = 28
const val MODEL_PATH = "model.tflite"
const val MODEL_PATH2 = "fashionmodel.tflite"
const val BATCH_SIZE = 10
const val NUM_BATCHES = 10
const val NUM_EPOCHS = 100

class InterpreterWrapper(private val context: Context) {

    fun runTraining(images: List<List<Float>>, labels: List<List<Float>>) {

        Interpreter(FileUtil.loadMappedFile(context, MODEL_PATH)).use { interpreter ->

            try {

                val trainImageBatches: MutableList<FloatBuffer> =
                    ArrayList<FloatBuffer>(NUM_BATCHES)
                val trainLabelBatches: MutableList<FloatBuffer> =
                    ArrayList<FloatBuffer>(NUM_BATCHES)

                // Prepare training batches.
                for (i in 0 until NUM_BATCHES) {
                    val trainImages: FloatBuffer =
                        FloatBuffer.allocate(BATCH_SIZE * IMG_SIZE * IMG_SIZE)

                    val trainLabels: FloatBuffer = FloatBuffer.allocate(BATCH_SIZE * 10)

                    // Fill the data values...
                    for (batchIndex in 0 until BATCH_SIZE) {
                        val startIndex = batchIndex * 28

                        val image = images.subList(startIndex, startIndex + 28)
                        val label = labels[batchIndex]

                        for (row in image) {
                            for (pixel in row) {

                                trainImages.put(pixel)
                            }
                        }

                        for (value in label) {

                            trainLabels.put(value)
                        }
                    }

                    trainImages.rewind()
                    trainLabels.rewind()

                    trainImageBatches.add(trainImages)
                    trainLabelBatches.add(trainLabels)
                }

                val losses: MutableList<Float> = mutableListOf()

                for (epoch in 0..NUM_EPOCHS) {

                    for (batchIndex in 0..NUM_BATCHES) {

                        val inputs: MutableMap<String, Any> = HashMap()
                        inputs["x"] = trainImageBatches[batchIndex]
                        inputs["y"] = trainLabelBatches[batchIndex]

                        val outputs: MutableMap<String, Any> = HashMap()
                        val loss = FloatBuffer.allocate(1)
                        outputs["loss"] = loss

                        interpreter.runSignature(inputs, outputs, "train")

                        // Record the last loss.
                        if (batchIndex == NUM_BATCHES - 1) {
                            losses[epoch] = loss.get(0)
                        }
                    }
                }

                for (loss in losses) {

                    println(loss.dp)
                }

            } catch (e: Exception) {
                println(e.message)
            }
        }
    }

    fun runInference(images: List<List<Float>>) {

        Interpreter(FileUtil.loadMappedFile(context, MODEL_PATH2)).use { interpreter ->

            try {

                for (i in 0..99) {

                    val startIndex: Int = i * 28
                    val endIndex: Int = startIndex + 28

                    val image = images.subList(startIndex, endIndex)


                    val trainImages: FloatBuffer = FloatBuffer.allocate(IMG_SIZE * IMG_SIZE)

                    for (row in image) {
                        for (pixel in row) {

                            trainImages.put(pixel)
                        }
                    }

                    trainImages.rewind()

                    // Run encoding signature.
                    val inputs: MutableMap<String, Any> = HashMap()
                    inputs["x"] = trainImages

                    val outputs: MutableMap<String, Any> = HashMap()

                    val output = FloatBuffer.allocate(10)
                    val logits = FloatBuffer.allocate(10)
                    outputs["output"] = output
                    outputs["logits"] = logits

                    interpreter.runSignature(inputs, outputs, "infer")

                    val output1 = outputs["output"]
                    val confidences = outputs["logits"]

                    println(output1)
                    println(confidences)
                }
            } catch (e: Exception) {
                println(e.message)
            }
        }
    }
}