package com.example.fedndemo

// Android
import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.content.pm.ServiceInfo
import android.os.Build

// WorkManager
import androidx.work.CoroutineWorker
import androidx.work.ForegroundInfo
import androidx.work.WorkerParameters

// Coroutines
import kotlinx.coroutines.CancellationException
import kotlinx.coroutines.awaitCancellation
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.Dispatchers

class TelemetryWorker(
    appContext: Context,
    params: WorkerParameters
) : CoroutineWorker(appContext, params) {

    override suspend fun doWork(): Result = coroutineScope {
        // Build your client from inputData
        val connectionString = inputData.getString("CONNECTION_STRING") ?: return@coroutineScope Result.failure()
        val token            = inputData.getString("TOKEN") ?: return@coroutineScope Result.failure()
        val name             = inputData.getString("NAME")
        val id               = inputData.getString("ID")

        val client = FednClientManager.getOrCreate(
            FednParams(connectionString = connectionString, token = token, name = name, id = id)
        )
        
        // Make this a foreground worker for reliability (long-running loop)
        setForeground(generateForegroundInfo())

        val monitor = PerfMonitor(applicationContext, periodMs = 1_000L)

        // Launch the stream in this worker's scope so cancellation stops it
        val streamingJob = launch(Dispatchers.Default) {
            monitor.samples().collect { sample ->
                val data = sample.toMap()
                // If sendTelemetry is suspend, this is fine; if blocking, wrap with withContext(Dispatchers.IO)
                try {
                    client.sendTelemetry(data)
                } catch (e: Throwable) {
                    // swallow or add retry/backoff/log as you prefer
                    println(e.message)
                }
            }
        }

        try {
            // Option A: run until WorkManager cancels this work
            awaitCancellation()
        } catch (_: CancellationException) {
            // Worker cancelled -> stop stream
            streamingJob.cancel()
            Result.success() // or Result.retry() if you want WM to reschedule
        }
    }

    // Foreground notification (required for long-running work)
    private fun generateForegroundInfo(): ForegroundInfo {
        val channelId = "telemetry"
        if (Build.VERSION.SDK_INT >= 26) {
            val nm = applicationContext.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
            nm.createNotificationChannel(
                NotificationChannel(
                    channelId,
                    "Telemetry",
                    NotificationManager.IMPORTANCE_LOW
                )
            )
        }
        val notification = if (Build.VERSION.SDK_INT >= 26) {
            Notification.Builder(applicationContext, channelId)
        } else {
            Notification.Builder(applicationContext)
        }
            .setContentTitle("Telemetry streaming")
            .setContentText("Sending performance metrics")
            .setSmallIcon(android.R.drawable.stat_notify_sync)
            .setOngoing(true)
            .build()

        return ForegroundInfo(42, notification, ServiceInfo.FOREGROUND_SERVICE_TYPE_DATA_SYNC)
    }
}
