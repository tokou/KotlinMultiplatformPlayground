package com.example.kotlinmultiplatformplayground;

import common.Platform;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ExampleUnitTest {

    @Test
    public void multipatform() {
        assertEquals("platform-jvm", new Platform().platform());
    }
}