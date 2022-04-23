package com.kashif.kmmscientists.routes

import com.kashif.kmmscientists.data.entities.Status
import com.kashif.kmmscientists.data.entities.ScientistEntity
import com.kashif.kmmscientists.data.repository.MongoRepository

import com.kashif.kmmscientists.domain.locations.AllScientist
import com.kashif.kmmscientists.domain.locations.ScientistById
import com.kashif.kmmscientists.domain.locations.ScientistOrigin
import com.kashif.kmmscientists.plugins.DataIntegrityException
import io.ktor.application.*
import io.ktor.locations.*
import io.ktor.request.*
import io.ktor.response.*
import io.ktor.routing.*
import org.koin.ktor.ext.inject

/**
 * unable to use koin because of name clashing of get function of koin with get route thus using inject()
 *
 * issue reported here
 *
 * https://github.com/ktorio/ktor/issues/368
 */


fun Route.scientists() {

    val repository: MongoRepository by inject()




    post("/newScientist") {
        try {


            val scientist = call.receive(ScientistEntity::class)
            repository.addScientist(
                scientist
            )
            call.respond(
                Status(
                    message = "Scientist added successfully",
                    code = 200
                )
            )
        } catch (e: Exception) {

            throw DataIntegrityException()
        }

    }


    get<AllScientist> {

        call.respond(
            repository.getAllScientists()
        )
    }

    get<ScientistOrigin> {

        call.respond(
//            localRepository.getScientistsByOrigin(
//                it.origin
//            )
            repository.getAllScientists()
        )
    }
    get<ScientistById> {
        repository.getAllScientists()
//        localRepository.getScientistById(
//            it.id
//        )?.let { scientist ->
//            call.respond(
//                listOf(scientist)
//            )
//        } ?: run {
//            call.respond(
//                emptyList<Scientist>()
//            )
//        }

    }


}