package com.example.desktop

import common.Common
import org.junit.Test
import org.junit.Assert.assertEquals

class DesktopTest {

    @Test
    fun multiplatform() {
        assertEquals("common", Common().common())
    }
}