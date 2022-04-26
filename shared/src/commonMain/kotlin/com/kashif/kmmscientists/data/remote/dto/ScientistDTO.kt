package com.kashif.kmmscientists.data.remote.dto

import com.kashif.kmmscientists.domain.domain_model.ScientistDomainModel
import kotlinx.serialization.Serializable


@Serializable
data class ScientistDTO(

    val id: Int?,
    val name: String?,
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