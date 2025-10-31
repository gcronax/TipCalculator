package com.example.tipcalculator

import org.junit.Test

import org.junit.Assert.*
import java.text.NumberFormat

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {
    @Test
    fun obtainDouble_isCorrect() {
        val expectedTip =50.0
        val actualTip = obtainDouble(estadoTextField1 = "100", estadoTextField2 = "50")
        assertEquals(expectedTip, actualTip)
    }
}