package com.yangamodels

import io.ktor.server.engine.*
import io.ktor.server.tomcat.*
import com.yangamodels.plugins.*

fun main() {
    embeddedServer(Tomcat, port = 8080, host = "0.0.0.0") {
        configureRouting()
        configureMonitoring()
        configureTemplating()
        configureSerialization()
    }.start(wait = true)
}
