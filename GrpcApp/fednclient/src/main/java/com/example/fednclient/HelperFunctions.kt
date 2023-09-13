package com.example.fednclient

import com.google.protobuf.ByteString
import java.text.SimpleDateFormat
import java.time.Instant
import java.time.format.DateTimeFormatter
import java.util.Date
import java.util.Random
import java.util.UUID

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

fun generateRandomByteString(length: Int): ByteString {
    val random = Random()
    val byteArray = ByteArray(length)
    random.nextBytes(byteArray)
    return ByteString.copyFrom(byteArray)
}

fun getCurrentTimestamp(pattern: String = "yyyy-MM-dd HH:mm:ss"): String {
    val dateFormat = SimpleDateFormat(pattern)
    val currentDate = Date()
    return dateFormat.format(currentDate)
}

fun generateRandomString(): String {
    // Generate a GUID
    val guid = UUID.randomUUID()

    val timestampString: String = getCurrentTimestamp("yyyyMMddHHmmss")
    // Combine the GUID and timestamp string
    return "$guid-$timestampString"
}
