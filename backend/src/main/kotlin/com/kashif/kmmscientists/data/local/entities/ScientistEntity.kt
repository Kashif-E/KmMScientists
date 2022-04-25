package com.kashif.kmmscientists.data.local.entities

import kotlinx.serialization.Contextual
import org.bson.codecs.pojo.annotations.BsonId
import org.bson.types.ObjectId


@kotlinx.serialization.Serializable
data class ScientistEntity(


    var id: Int? = 0,
    val name: String? = "",
    val fullName: String? = "",
    val latinizedName: String? = "",
    val description: String? = "",
    val origin: String? = "",
    val image: String? = "",
    val birthPlace: String? = "",
    val dob: String? = "",
    val dod: String? = "",
    var books: List<String>? = emptyList(),
    var titles: String? = "",
    var achievements: List<String>? = emptyList(),

    )