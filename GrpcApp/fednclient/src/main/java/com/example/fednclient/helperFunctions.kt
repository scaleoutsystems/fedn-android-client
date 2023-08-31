package com.example.fednclient

import com.google.protobuf.ByteString
import java.text.SimpleDateFormat
import java.util.Date

fun splitByteStringIntoChunks(
    byteString: ByteString,
    chunkSize: Int
): List<ByteString> {
    val chunks = mutableListOf<ByteString>()
    var currentIndex = 0

    while (currentIndex < byteString.size()) {
        val endIndex = (currentIndex + chunkSize).coerceAtMost(byteString.size())
        val chunk = byteString.substring(currentIndex, endIndex)
        chunks.add(chunk)
        currentIndex = endIndex
    }

    return chunks
}

fun getCurrentTimestamp(): String {
    val dateFormat = SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
    val currentDate = Date()
    return dateFormat.format(currentDate)
}