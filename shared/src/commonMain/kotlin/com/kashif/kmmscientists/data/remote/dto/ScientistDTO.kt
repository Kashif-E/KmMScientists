package com.kashif.kmmscientists.data.remote.dto

import com.kashif.kmmscientists.data.local.entities.ScientistDatabaseModel
import com.kashif.kmmscientists.domain.domain_model.ScientistDomainModel
import kotlinx.serialization.Serializable


@Serializable
data class ScientistDTO(

    var id: Int?,
    var name: String?,
    val fullName: String?,
    val latinizedName: String?,
    val description: String?,
    val origin: String?,
    val image: String?,
    val birthPlace: String?,
    val dob: String?,
    val dod: String?,
    val books: List<String>?,
    val titles: String?,
    val achievements: List<String>?

)

fun ScientistDTO.asDomainModel() = ScientistDomainModel(
    id,
    name,
    fullName,
    latinizedName,
    description,
    origin,
    image,
    birthPlace,
    dob,
    dod,
    books,
    titles,
    achievements
)

fun List<ScientistDTO>.asDomainModel() = map { it.asDomainModel() }
fun List<ScientistDTO>.asEntity() = map { it.asEntity() }

fun ScientistDTO.asEntity(): ScientistDatabaseModel {
    return ScientistDatabaseModel().also {
        it.id = this.id!!
        it.name = this.name!!
        it.fullName = this.fullName!!
        it.latinizedName = this.latinizedName!!
        it.description = this.description!!
        it.origin = this.origin!!
        it.image = this.image!!
        it.birthPlace = this.birthPlace!!
        it.dob = this.dob!!
        it.dod = this.dod!!
        it.books = this.books.toString()
        it.titles = this.titles!!
        it.achievements = this.achievements.toString()
    }
}


