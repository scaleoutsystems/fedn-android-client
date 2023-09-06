package com.example.fednclient

fun getUrl(
    connectionString: String,
    name: String,
): String? {

    val valid = connectionString.isNotEmpty() && name.isNotEmpty()

    val connectionStringStr =
        if (connectionString.contains("http")) connectionString else "http://$connectionString"

    return if (valid) "$connectionStringStr/assign?name=$name" else null
}

fun getVerifiedToken(token: String): String? {

    var result: String? = null

    if (token.isNotEmpty()) {
        result = if (token.startsWith("Token ")) token else "Token $token"
    }

    return result
}