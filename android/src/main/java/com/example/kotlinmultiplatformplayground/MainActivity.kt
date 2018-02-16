package com.example.kotlinmultiplatformplayground

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import common.Common
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val common = Common()
        text.text = "${common.platform()} ${common.common()}"
    }
}
