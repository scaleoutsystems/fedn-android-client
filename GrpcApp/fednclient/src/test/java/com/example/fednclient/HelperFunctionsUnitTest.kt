package com.example.fednclient

import org.junit.Assert
import org.junit.Test

class HelperFunctionsUnitTest {

    @Test
    fun splitByteStringIntoChunksTest() {

        val byteString = generateRandomByteString(1024)
        splitByteStringIntoChunks(byteString, 1024 * 1024)
    }

    @Test
    fun getCurrentTimestampTest(){

        var result = getCurrentTimestamp()
        Assert.assertEquals(result.length, 19)

        result = getCurrentTimestamp("yyyy")
        Assert.assertEquals(result.length, 4)
    }

    @Test
    fun generateRandomStringTest(){

        var result = generateRandomString()
        Assert.assertNotNull(result)

        println(result)
    }
}