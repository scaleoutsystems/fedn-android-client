package com.example.fedndemo

import com.example.fedn_client.FednClient
import com.example.fedn_client.IFednClient
import java.util.concurrent.atomic.AtomicReference

data class FednParams(
    val connectionString: String,
    val token: String,
    val name: String?,
    val id: String?
)

object FednClientManager {
    private val ref = AtomicReference<IFednClient?>()

    fun getOrCreate(params: FednParams): IFednClient {
        ref.get()?.let { return it }
        synchronized(this) {
            ref.get()?.let { return it }
            val created = FednClient(params.connectionString, params.token, params.name, params.id)
            ref.set(created)
            return created
        }
    }

    fun shutdown() {
        synchronized(this) {
            ref.getAndSet(null)?.stopProcess()
        }
    }
}