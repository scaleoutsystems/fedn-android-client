package com.example.grpcapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
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
import androidx.compose.ui.text.Placeholder
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.work.OneTimeWorkRequestBuilder
import androidx.work.WorkManager
import androidx.work.WorkRequest
import androidx.work.workDataOf
import com.example.grpcapp.ui.theme.GrpcAppTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            GrpcAppTheme {
                // A surface container using the 'background' color from the theme
                App()
            }
        }
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


//    discover_host: r80ea7a19.studio.scaleoutsystems.com
//    name: niklastestclient2
//    network_id: fedn_test_network
//    token: 393fc4d2973c52b785870276e2a701a71b6e2a7cc29c5


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

            Row {
                TextField(
                    value = connectionString, onValueChange = {
                        connectionString = it
                    }
                )
            }
            Spacer(modifier = Modifier.height(16.dp))
            Row {
                TextField(
                    value = token, onValueChange = {
                        token = it
                    }
                )
            }
            Spacer(modifier = Modifier.height(16.dp))
            Row {
                TextField(
                    value = name, onValueChange = {
                        name = it
                    }, placeholder = {
                        "Name (optional)"
                    }
                )
            }
            Spacer(modifier = Modifier.height(16.dp))
            Row {
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
