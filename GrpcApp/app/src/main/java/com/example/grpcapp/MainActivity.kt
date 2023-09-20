package com.example.grpcapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.work.OneTimeWorkRequestBuilder
import androidx.work.WorkManager
import androidx.work.WorkRequest
import androidx.work.workDataOf
import com.example.fednclient.InterpreterWrapper
import com.example.grpcapp.ui.theme.GrpcAppTheme
import java.io.BufferedReader
import java.io.FileInputStream
import java.io.InputStreamReader

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val interpreterWrapper = InterpreterWrapper(this)
        val images: List<List<Float>> = readCsvFile()

        interpreterWrapper.runInference(images)

        setContent {
            GrpcAppTheme {
                // A surface container using the 'background' color from the theme
                App()
            }
        }
    }

    private fun readCsvFile(): List<List<Float>> {

        var fileInputStream: FileInputStream? = openFileInput("fashionmnist.csv")
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

    @Preview
    @Composable
    fun App() {
        AppContent(
            modifier = Modifier
                .fillMaxSize()
                .wrapContentSize(Alignment.Center)
        )
    }

    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    fun AppContent(modifier: Modifier = Modifier) {

        var connectionString by remember { mutableStateOf("") }
        var token by remember { mutableStateOf("") }
        var name by remember { mutableStateOf("") }

        val padding = 16.dp

        Column(
            Modifier.padding(padding),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Row(Modifier.padding(vertical = 8.dp)) {
                Column {
                    Text(text = "Connection string", Modifier.padding(bottom = 8.dp))
                    TextField(
                        value = connectionString, onValueChange = {
                            connectionString = it
                        }
                    )
                }
            }
            Row(Modifier.padding(vertical = 8.dp)) {
                Column {
                    Text(text = "Token", Modifier.padding(bottom = 8.dp))
                    TextField(
                        value = token, onValueChange = {
                            token = it
                        }
                    )
                }
            }
            Row(Modifier.padding(vertical = 8.dp)) {
                Column {
                    Text(text = "Name (optional)", Modifier.padding(bottom = 8.dp))
                    TextField(
                        value = name, onValueChange = {
                            name = it
                        }
                    )
                }
            }
            Row(Modifier.padding(vertical = 8.dp)) {
                Button(onClick = {

                    val fednWorkRequest: WorkRequest =
                        OneTimeWorkRequestBuilder<FednWorker>()
                            .setInputData(
                                workDataOf(
                                    "CONNECTION_STRING" to connectionString,
                                    "TOKEN" to token,
                                    "NAME" to if (name.isNullOrBlank()) null else name
                                )
                            )
                            .build()
                    WorkManager
                        .getInstance(applicationContext)
                        .enqueue(fednWorkRequest)

                }) {
                    Text(stringResource(R.string.startProcess))
                }
            }
        }
    }
}
