package com.kashif.kmmscientists

import com.kashif.kmmscientists.plugins.*
import io.ktor.server.engine.*
import io.ktor.server.netty.*

fun main() {
    embeddedServer(Netty, port = 8080, host = "0.0.0.0") {
        configureSecurity()
        configureMonitoring()
        configureTemplating()
        configureSerialization()
        configureLocations()
        configureRouting()
        configureKoin()



    }.start(wait = true)
}
