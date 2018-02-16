package com.example.kotlinmultiplatformplayground

import common.Platform
import org.junit.Assert.assertEquals
import org.junit.Test

class ExampleUnitTest {

    @Test
    fun multipatform() {
        assertEquals("platform-jvm", Platform().platform())
    }
}
