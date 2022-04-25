package com.kashif.kmmscientists.domain.locations


import com.kashif.kmmscientists.data.local.entities.ScientistEntity
import io.ktor.locations.*


/**
 *
 * End points to get scientists
 * 'all' to get all the scientists
 * {origin} path to get scientists by their origin
 *
 */

@Location("/all")
class AllScientist

@Location("/all")
data class ScientistOrigin(val origin: String)

/**
 * End point to get scientist by {id}
 */
@Location("/scientistById")
data class ScientistById(val id: Int)


/**
 * End point to add new scientist
 */

@Location("/new")
data class NewScientist(val scientist: ScientistEntity)
