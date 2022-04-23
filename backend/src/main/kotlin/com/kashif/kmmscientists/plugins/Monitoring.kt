package com.kashif.kmmscientists.plugins

import io.ktor.features.*
import org.slf4j.event.*
import io.ktor.request.*
import io.ktor.application.*

fun Application.configureMonitoring() {
    install(CallLogging) {
        level = Level.INFO
        filter { call -> call.request.path().startsWith("/") }
    }

}
