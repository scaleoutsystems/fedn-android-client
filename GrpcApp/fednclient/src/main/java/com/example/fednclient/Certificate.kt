package com.example.fednclient

import java.net.URL
import java.security.cert.X509Certificate
import javax.net.ssl.HttpsURLConnection
import javax.net.ssl.SSLContext
import javax.net.ssl.X509TrustManager

class AllCertificatesTrustManager : X509TrustManager {
    override fun checkClientTrusted(chain: Array<out X509Certificate>?, authType: String?) {
        // Do nothing, accept any client certificate
    }

    override fun checkServerTrusted(chain: Array<out X509Certificate>?, authType: String?) {
        // Do nothing, accept any server certificate
    }

    override fun getAcceptedIssuers(): Array<X509Certificate> {
        return emptyArray()
    }
}

class Certificate {

    suspend fun fetchServerCertificate(urlString: String): X509Certificate? {
        val url = URL(urlString)

        val trustManager = arrayOf(AllCertificatesTrustManager())

        val sslContext = SSLContext.getInstance("TLS")
        sslContext.init(null, trustManager, null)

        (url.openConnection() as? HttpsURLConnection)?.apply {
            sslSocketFactory = sslContext.socketFactory
            connect()

            val serverCertificates = serverCertificates

            disconnect()

            return if (serverCertificates.isNotEmpty()) {
                serverCertificates[0] as? X509Certificate
            } else {
                null
            }
        }

        return null
    }

}
