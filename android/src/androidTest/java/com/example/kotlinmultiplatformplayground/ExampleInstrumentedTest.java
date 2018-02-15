package com.example.kotlinmultiplatformplayground;

import android.support.test.runner.AndroidJUnit4;
import common.Common;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertEquals;

@RunWith(AndroidJUnit4.class)
public class ExampleInstrumentedTest {

    @Test
    public void multiplatform() throws Exception {
        assertEquals("platform-jvm", new Common().platform());
    }
}
