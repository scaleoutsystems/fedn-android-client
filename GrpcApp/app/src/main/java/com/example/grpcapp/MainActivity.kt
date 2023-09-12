package com.example.grpcapp

import android.content.Context
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.work.OneTimeWorkRequestBuilder
import androidx.work.WorkManager
import androidx.work.WorkRequest
import com.example.fednclient.FednClient
import com.example.grpcapp.ui.theme.GrpcAppTheme
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val fednWorkRequest: WorkRequest =
            OneTimeWorkRequestBuilder<FednWorker>()
                .build()

        WorkManager
            .getInstance(applicationContext)
            .enqueue(fednWorkRequest)

        setContent {
            GrpcAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background
                ) {
                    Greeting("Fedn")
                }
            }
        }
    }
}

fun initWorkerManager(context: Context) {
    val fednWorkRequest: WorkRequest =
        OneTimeWorkRequestBuilder<FednWorker>()
            .build()

    WorkManager
        .getInstance(context)
        .enqueue(fednWorkRequest)
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {

    Text(
        text = "Hello $name!", modifier = modifier,
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    GrpcAppTheme {
        Greeting("Android")
    }
}