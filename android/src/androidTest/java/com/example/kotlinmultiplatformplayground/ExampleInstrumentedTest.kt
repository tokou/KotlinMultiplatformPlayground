package com.example.kotlinmultiplatformplayground

import android.support.test.runner.AndroidJUnit4
import common.Common
import org.junit.Test
import org.junit.runner.RunWith

import org.junit.Assert.assertEquals

@RunWith(AndroidJUnit4::class)
class ExampleInstrumentedTest {

    @Test
    @Throws(Exception::class)
    fun multiplatform() {
        assertEquals("platform-jvm", Common().platform())
    }
}
