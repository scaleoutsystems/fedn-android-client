package com.example.fednclient

import android.content.Context
import com.example.grpcapp.ml.Model
import org.tensorflow.lite.DataType
import org.tensorflow.lite.InterpreterApi
import org.tensorflow.lite.support.common.FileUtil
import org.tensorflow.lite.support.tensorbuffer.TensorBuffer
import java.io.Closeable
import java.nio.ByteBuffer
import java.nio.ByteOrder

const val IMG_SIZE = 28
const val MODEL_PATH = "model.tflite"

class InterpreterWrapper(private val context: Context) : Closeable {

    private val interpreterInitializer = lazy {
        val interpreterOptions = InterpreterApi.Options()
            .setRuntime(InterpreterApi.Options.TfLiteRuntime.FROM_SYSTEM_ONLY)
        InterpreterApi.create(FileUtil.loadMappedFile(context, MODEL_PATH), interpreterOptions)
    }

    private val interpreter: InterpreterApi by interpreterInitializer

    override fun close() {
        if (interpreterInitializer.isInitialized()) {
            interpreter.close()
        }
    }

    fun classify(images: List<List<Float>>) {

        try {
            val image = images.take(28)


//            interpreter.run()
        } catch (e: Exception) {
            println(e.message)
        }
    }


    fun runInference(images: List<List<Float>>) {

        try {
            val image = images.take(28)

            val model = Model.newInstance(context)

            // Creates inputs for reference.
            val inputFeature0 =
                TensorBuffer.createFixedSize(intArrayOf(1, 28, 28), DataType.FLOAT32)

            val byteBuffer: ByteBuffer = ByteBuffer.allocateDirect(4 * IMG_SIZE * IMG_SIZE)
            byteBuffer.order(ByteOrder.nativeOrder())

            // Runs model inference and gets result.

            for (row in image) {
                for (pixel in row) {

                    byteBuffer.putFloat(pixel)
                }
            }

            inputFeature0.loadBuffer(byteBuffer)

            val outputs = model.process(inputFeature0)

            val outputFeature0 = outputs.outputFeature0AsTensorBuffer
            val outputFeature1 = outputs.outputFeature1AsTensorBuffer

            val confidences = outputFeature0.floatArray
            val confidences2 = outputFeature1.floatArray

            println("confidences: $confidences")
            println("confidences2: $confidences2")

            // Releases model resources if no longer used.
            model.close()
        } catch (e: Exception) {
            println(e.message)
        }
    }
}