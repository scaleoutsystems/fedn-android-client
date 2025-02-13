package com.example.fedndemo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import androidx.work.ExistingWorkPolicy
import androidx.work.OneTimeWorkRequest
import androidx.work.OneTimeWorkRequestBuilder
import androidx.work.WorkInfo
import androidx.work.WorkManager
import androidx.work.workDataOf
import com.example.fedndemo.FednWorker.Companion.Progress
import com.example.fedndemo.ui.theme.FednDemoTheme
import com.example.fedndemo.ui.theme.scaleoutBlack
import java.util.UUID

val manropeFamily = FontFamily(
    Font(R.font.manrope, FontWeight.Normal),
    Font(R.font.manrope_bold, FontWeight.Bold)
)


const val TRAINING_ROUND_PROCESS = "TRAINING_ROUND_PROCESS"
val REGEX_NUMBERS_ONLY = Regex("^\\d+\$")

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            FednDemoTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    App()
                }
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

    @Composable
    fun LoadingScreen(state: String) {

        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Row(
                modifier = Modifier.fillMaxWidth(),
                Arrangement.Center,
                Alignment.CenterVertically
            ) {

                Text(
                    text = state.ifEmpty { "Loading" },
                    style = androidx.compose.ui.text.TextStyle(
                        fontFamily = manropeFamily,
                        fontWeight = FontWeight.Bold,
                        fontSize = 20.sp
                    ),
                    modifier = Modifier.padding(vertical = 8.dp)
                )
                CircularProgressIndicator(
                    modifier = Modifier.padding(start = 8.dp),
                    color = scaleoutBlack,
                )
            }
        }
    }

    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    fun TextFieldRow(text: String, value: String, onValueChange: (String) -> Unit) {
        Row(Modifier.padding(vertical = 8.dp)) {
            Column {
                Text(
                    text = text,
                    style = androidx.compose.ui.text.TextStyle(
                        fontFamily = manropeFamily,
                        fontWeight = FontWeight.Normal,
                    ),
                    modifier = Modifier.padding(vertical = 8.dp)
                )
                TextField(
                    value = value,
                    textStyle = androidx.compose.ui.text.TextStyle(
                        fontFamily = manropeFamily,
                        fontWeight = FontWeight.Normal,
                    ),
                    colors = TextFieldDefaults.outlinedTextFieldColors(
                        unfocusedBorderColor = scaleoutBlack,
                        focusedBorderColor = scaleoutBlack
                    ),
                    modifier = Modifier.fillMaxWidth(), onValueChange = onValueChange
                )
            }
        }
    }

    @Composable
    fun ButtonRow(formValid: Boolean, onClick: () -> Unit) {
        Row(Modifier.padding(vertical = 8.dp)) {

            Button(
                modifier = Modifier.fillMaxWidth(),
                colors = ButtonDefaults.buttonColors(
                    containerColor = scaleoutBlack
                ),
                enabled = formValid,
                onClick = onClick
            ) {
                Text(
                    stringResource(R.string.startProcess),
                    style = androidx.compose.ui.text.TextStyle(
                        fontFamily = manropeFamily,
                        fontWeight = FontWeight.Normal,
                    ),
                    modifier = Modifier.padding(vertical = 8.dp)
                )
            }
        }
    }

    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    fun AppContent(modifier: Modifier = Modifier) {

        var connectionString by remember { mutableStateOf("https://api.studio.scaleoutplatform.com") }
        var token by remember { mutableStateOf("") }
        var name by remember { mutableStateOf("") }
        var timeoutSeconds by remember {
            mutableStateOf<Long>(60)
        }

        val observer: LifecycleOwner = this

        var clientState by remember {
            mutableStateOf("")
        }
        var clientActive by remember {
            mutableStateOf(false)
        }

        val formValid: Boolean =
            connectionString.isNotEmpty()
                    && token.isNotEmpty()


        Column(
            Modifier.padding(16.dp)
        ) {

            Row(
                Modifier.padding(vertical = 24.dp)
            ) {
                Image(
                    painterResource(R.drawable.scaleout_black),
                    contentDescription = null,
                )
            }

            if (clientActive) {

                LoadingScreen(state = clientState)
                return
            }

            TextFieldRow(text = "Url", value = connectionString, onValueChange = {
                connectionString = it
            })
            TextFieldRow(text = "Token", value = token, onValueChange = {
                token = it
            })
            TextFieldRow(
                text = "Timeout (seconds)",
                value = timeoutSeconds.toString(),
                onValueChange = {
                    timeoutSeconds = if (it.isNotEmpty() && it.matches(REGEX_NUMBERS_ONLY)) {
                        it.toLong()
                    } else {
                        30
                    }
                })
            TextFieldRow(text = "Name (optional)", value = name, onValueChange = {
                name = it
            })
            ButtonRow(formValid = formValid, onClick = {

                clientActive = true

                val fednWorkRequest: OneTimeWorkRequest =
                    OneTimeWorkRequestBuilder<FednWorker>().setInputData(
                        workDataOf(
                            "CONNECTION_STRING" to connectionString,
                            "TOKEN" to token,
                            "NAME" to if (name.isNullOrBlank()) null else name,
                            "TIMEOUT_AFTER_MILLIS" to timeoutSeconds * 1000,
                            "ID" to UUID.randomUUID().toString()
                        )
                    ).build()

                WorkManager.getInstance(applicationContext).enqueueUniqueWork(
                    TRAINING_ROUND_PROCESS,
                    ExistingWorkPolicy.KEEP,
                    fednWorkRequest
                )

                WorkManager.getInstance(applicationContext)
                    // requestId is the WorkRequest id
                    .getWorkInfoByIdLiveData(fednWorkRequest.id)
                    .observe(observer, Observer { workInfo: WorkInfo? ->
                        if (workInfo != null) {

                            if (listOf(WorkInfo.State.ENQUEUED, WorkInfo.State.RUNNING).contains(
                                    workInfo.state
                                )
                            ) {

                                val progress = workInfo.progress
                                // Do something with progress information
                                clientState = progress.getString(Progress) ?: ""

                            } else {
                                clientActive = false
                                clientState = ""
                            }
                        }
                    })
            })
        }
    }
}
