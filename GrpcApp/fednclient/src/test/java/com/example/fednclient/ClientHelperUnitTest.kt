package com.example.fednclient

import org.junit.Assert
import org.junit.Test

class ClientHelperUnitTest {

    private val clientHelper: IClientHelper = ClientHelper()

    @Test
    fun getUrl() {

        val connectionString: String = "http://connectionString"
        val name: String = "name"
        val preferredCombiner: String = "preferredCombiner"

        val expected = "$connectionString/assign?name=$name&combiner=$preferredCombiner"

        val actual = clientHelper.getUrl(connectionString, name, preferredCombiner)

        Assert.assertEquals(expected, actual)
    }

    @Test
    fun getUrlNoHttp() {

        val connectionString: String = "connectionString"
        val name: String = "name"
        val preferredCombiner: String = "preferredCombiner"

        val expected = "http://$connectionString/assign?name=$name&combiner=$preferredCombiner"

        val actual = clientHelper.getUrl(connectionString, name, preferredCombiner)

        Assert.assertEquals(expected, actual)
    }

    @Test
    fun getUrlNoPreferredCombiner() {

        val connectionString: String = "connectionString"
        val name: String = "name"

        val expected = "http://$connectionString/assign?name=$name"

        val actual = clientHelper.getUrl(connectionString, name, null)

        Assert.assertEquals(expected, actual)
    }
}