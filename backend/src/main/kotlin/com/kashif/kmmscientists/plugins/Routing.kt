package com.kashif.kmmscientists.plugins

import com.kashif.kmmscientists.routes.scientists
import io.ktor.application.*
import io.ktor.auth.*
import io.ktor.features.*
import io.ktor.http.*
import io.ktor.http.content.*
import io.ktor.response.*
import io.ktor.routing.*

fun Application.configureRouting() {


    routing {
        trace { application.log.trace(it.buildText()) }


        authenticate("api-key") {
            scientists()
        }


        // Static plugin. Try to access `/static/index.html`
        static("/static") {
            resources("static")
        }
        install(StatusPages) {
            exception<Throwable> {
                call.respond(HttpStatusCode.InternalServerError, "Internal server error")
            }
            exception<AuthenticationException> { cause ->
                call.respond(HttpStatusCode.Unauthorized, "Unauthorized")
            }
            exception<AuthorizationException> { cause ->
                call.respond(HttpStatusCode.Forbidden, "Forbidden")
            }
            exception<DataIntegrityException> {
                call.respond(
                    HttpStatusCode.BadRequest, "Invalid Data"
                )
            }

        }
    }
}

class DataIntegrityException : RuntimeException()
class AuthenticationException : RuntimeException()
class AuthorizationException : RuntimeException()
