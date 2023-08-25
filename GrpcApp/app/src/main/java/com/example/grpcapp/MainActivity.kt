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
import com.example.fednclient.Client
import com.example.fednclient.IClient
import com.example.grpcapp.ui.theme.GrpcAppTheme
import kotlinx.coroutines.runBlocking

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            GrpcAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Greeting("Android")
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {

    val token = "393fc4d2973c52b785870276e2a701a71bcc29c5"

    val client: IClient = Client()

    runBlocking {

        val clientConfig = client.assign(
            "https://r80ea7a19.studio.scaleoutsystems.com:443",
            "niklastestclient2",
            null,
            token
        )

        if (clientConfig?.fqdn != null && clientConfig.host != null) {

            println(clientConfig)
        }
    }



    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    GrpcAppTheme {
        Greeting("Android")
    }
}