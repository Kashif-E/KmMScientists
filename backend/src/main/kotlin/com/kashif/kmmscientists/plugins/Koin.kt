package com.kashif.kmmscientists.plugins

import com.kashif.kmmscientists.di.AppModules
import io.ktor.application.*
import org.koin.ktor.ext.Koin
import org.koin.logger.slf4jLogger


fun Application.configureKoin(){
    install(Koin) {
        slf4jLogger()
        modules(AppModules)
    }
}