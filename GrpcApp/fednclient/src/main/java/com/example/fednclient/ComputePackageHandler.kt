package com.example.fednclient

import android.app.DownloadManager
import android.content.Context
import android.net.Uri
import android.os.Environment
import androidx.core.content.getSystemService
import androidx.core.net.toUri

interface IComputePackageHandler {

    suspend fun download(url: String, port: Int, token: String)
}

class ComputePackageHandler(private val context: Context) : IComputePackageHandler {

    private val manager: DownloadManager? = context.getSystemService()

    override suspend fun download(url: String, port: Int, token: String) {

        if (manager != null) {

            println("Manager is not null")

            val request: DownloadManager.Request = DownloadManager.Request(url.toUri())
            request.addRequestHeader("Authorization", "Token $token")

            request.setDestinationInExternalFilesDir(
                context, Environment.DIRECTORY_DOCUMENTS, "package.tgz"
            );

            manager.enqueue(request)
        }

    }


}