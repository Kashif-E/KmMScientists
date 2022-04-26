package com.kashif.kmmscientists.data.local.entities

import com.kashif.kmmscientists.domain.domain_model.ScientistDomainModel
import io.realm.RealmObject

data class ScientistEntity(

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

) : RealmObject

fun ScientistEntity.asDomainModel() = ScientistDomainModel(
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

fun List<ScientistEntity>.asDomainModel() = map { it.asDomainModel() }