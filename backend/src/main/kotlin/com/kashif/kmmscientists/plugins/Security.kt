package com.kashif.kmmscientists.plugins

import io.ktor.auth.*
import io.ktor.util.*
import io.ktor.sessions.*
import io.ktor.application.*
import io.ktor.response.*
import io.ktor.request.*
import io.ktor.routing.*

fun Application.configureSecurity() {

    install(Authentication) {

        basic(name = "api-key") {
            realm = "Ktor Server"
            validate { credentials ->
                if (credentials.name == "Kashif" && credentials.password == "6c0ab0a2-0a7d-4983-88c2-477b89177db1") {
                    UserIdPrincipal(credentials.name)
                } else {
                    null
                }
            }
        }


    }


}
