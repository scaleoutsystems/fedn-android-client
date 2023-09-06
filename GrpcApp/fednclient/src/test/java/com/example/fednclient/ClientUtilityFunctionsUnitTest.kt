package com.example.fednclient

import org.junit.Assert
import org.junit.Test

class ClientUtilityFunctionsUnitTest {


    @Test
    fun getUrl() {

        val connectionString: String = "http://connectionString"
        val name: String = "name"
        val preferredCombiner: String = "preferredCombiner"

        val expected = "$connectionString/assign?name=$name"

        val actual = getUrl(connectionString, name)

        Assert.assertEquals(expected, actual)
    }

    @Test
    fun getUrlNoHttp() {

        val connectionString: String = "connectionString"
        val name: String = "name"
        val preferredCombiner: String = "preferredCombiner"

        val expected = "http://$connectionString/assign?name=$name"

        val actual = getUrl(connectionString, name)

        Assert.assertEquals(expected, actual)
    }
    @Test
    fun getVerifiedToken() {

        val token = "Token myToken"
        val expected = "Token myToken"

        val actual = getVerifiedToken(token)

        Assert.assertEquals(expected, actual)
    }

    @Test
    fun getVerifiedTokenPrefix() {

        val token = "myToken"
        val expected = "Token myToken"

        val actual = getVerifiedToken(token)

        Assert.assertEquals(expected, actual)
    }
    @Test
    fun getVerifiedTokenEmpty() {

        val token = ""

        val actual = getVerifiedToken(token)

        Assert.assertNull(actual)
    }
}