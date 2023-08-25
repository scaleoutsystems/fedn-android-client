package com.example.fednclient

interface IClientHelper{
    fun getUrl(connectionString: String, name: String, preferredCombiner: String?): String?
    fun getVerifiedToken(token: String): String
}
class ClientHelper: IClientHelper {
    override fun getUrl(
        connectionString: String,
        name: String,
        preferredCombiner: String?
    ): String? {

        val valid = connectionString.isNotEmpty() && name.isNotEmpty()

        val preferredCombinerStr: String =
            if (!preferredCombiner.isNullOrEmpty()) "&combiner=$preferredCombiner" else ""

        val connectionStringStr =
            if (connectionString.contains("http")) connectionString else "http://$connectionString"

        return if (valid) "$connectionStringStr/assign?name=$name$preferredCombinerStr" else null
    }

    override fun getVerifiedToken(token: String): String {

        var result = ""

        if (token.isNotEmpty()) {
            result = if (token.startsWith("Token ")) token else "Token $token"
        }

        return result
    }
}