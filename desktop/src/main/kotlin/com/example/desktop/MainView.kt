package com.example.desktop

import common.Common
import tornadofx.*

class MainView : View("Kotlin Multiplatform Playground") {
    override val root = borderpane {
        setPrefSize(400.0, 400.0)
        val common = Common()
        center = text("${common.common()} ${common.platform()}")
    }
}
