package com.example.fedn_client

import com.google.protobuf.ByteString
import java.text.SimpleDateFormat
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


fun getUrl(
    connectionString: String,
): String? {

    val valid = connectionString.isNotEmpty()

    if(!valid){

        return null
    }
    val url =
        if (connectionString.contains("http")) connectionString else "http://$connectionString"

    return "$url/api/v1/clients/add"
}

fun getVerifiedToken(token: String): String? {

    var result: String? = null

    if (token.isNotEmpty()) {
        result = if (token.startsWith("Bearer ")) token else "Bearer $token"
    }

    return result
}