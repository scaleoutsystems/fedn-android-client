package com.example.grpcapp

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
import com.example.fednclient.FednClient
import com.example.grpcapp.ui.theme.GrpcAppTheme
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        val fednClient: FednClient = FednClient(
            "https://r80ea7a19.studio.scaleoutsystems.com:443",
            "niklastestclient2",
            "393fc4d2973c52b785870276e2a701a71bcc29c5",
        )

        runBlocking {
            launch {

                fednClient.doWork(onAssignStateChanged = { state ->

                    println("onAssignStateChanged: $state")

                }, onUpdateModelStateChanged = { state ->

                    println("onUpdateModelStateChanged $state")

                })
            }
        }

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