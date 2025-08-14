package com.example.fedndemo

import android.app.ActivityManager
import android.content.Context
import android.os.Process
import android.os.SystemClock
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow


/**
 * Periodically samples your app's CPU% and memory.
 * Works on Android Automotive (AAOS) and standard Android.
 */
class PerfMonitor(
    private val context: Context,
    private val periodMs: Long = 1_000L
) {
    data class Sample(
        val cpuPercent: Double,     // 0..100 across all cores
        val pssKb: Int,             // total PSS of process
        val privateDirtyKb: Int,    // private dirty memory
        val heapUsedBytes: Long,    // Java/Kotlin heap used
        val heapMaxBytes: Long      // Java/Kotlin heap max
    )

    /** Emits a Sample every [periodMs]. Collect on a background dispatcher. */
    fun samples(): Flow<Sample> = flow {
        val am = context.getSystemService(Context.ACTIVITY_SERVICE) as ActivityManager
        val pid = Process.myPid()
        val cores = Runtime.getRuntime().availableProcessors().coerceAtLeast(1)

        var lastCpuMs = Process.getElapsedCpuTime()
        var lastWallMs = SystemClock.elapsedRealtime()

        while (true) {
            delay(periodMs)

            val nowCpuMs = Process.getElapsedCpuTime()
            val nowWallMs = SystemClock.elapsedRealtime()

            val cpuDeltaMs = (nowCpuMs - lastCpuMs).coerceAtLeast(0L)
            val wallDeltaMs = (nowWallMs - lastWallMs).coerceAtLeast(1L) // avoid div0

            lastCpuMs = nowCpuMs
            lastWallMs = nowWallMs

            val rawPercent = (cpuDeltaMs.toDouble() / (wallDeltaMs.toDouble() * cores)) * 100.0
            val cpuPercent = rawPercent.coerceIn(0.0, 100.0)

            val mem = am.getProcessMemoryInfo(intArrayOf(pid))[0]
            val rt = Runtime.getRuntime()
            val heapUsed = rt.totalMemory() - rt.freeMemory()
            val heapMax = rt.maxMemory()

            emit(
                Sample(
                    cpuPercent = cpuPercent,
                    pssKb = mem.totalPss,
                    privateDirtyKb = mem.totalPrivateDirty,
                    heapUsedBytes = heapUsed,
                    heapMaxBytes = heapMax
                )
            )
        }
    }
}

fun PerfMonitor.Sample.toMap(): Map<String, Float> {
    return mapOf(
        "cpu_usage" to cpuPercent.toFloat(),
        "memory_usage" to (pssKb / 1024f),
        "private_dirty_mb" to (privateDirtyKb / 1024f),
        "heap_used_mb" to (heapUsedBytes / (1024f * 1024f)),
        "heap_max_mb" to (heapMaxBytes / (1024f * 1024f))
    )
}