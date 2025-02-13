import kotlin.system.measureTimeMillis
import kotlinx.coroutines.*

class PerformanceMonitor {
    suspend fun measurePerformance(block: suspend () -> Unit): Long {
        val executionDuration = measureTimeMillis {
            withContext(Dispatchers.Default) { block() }
        }

        return executionDuration
    }
}
