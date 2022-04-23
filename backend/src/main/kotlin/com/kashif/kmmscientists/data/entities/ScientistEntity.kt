package com.kashif.kmmscientists.data.entities


import kotlinx.serialization.Contextual
import org.bson.codecs.pojo.annotations.BsonId


@kotlinx.serialization.Serializable
 class ScientistEntity(

    val _id: Int,
    val name: String,
    val fullName: String,
    val latinizedName: String,
    val description: String,
    val origin: String,
    val image: String,
    val birthPlace: String,
    val dob: String,
    val dod: String,
    var books: List<String>,
    var titles: String = "",
    var achievements: List<String>,

    ) {


    constructor() : this(
        0,
        "",
        "",
        "",
        "",
        "",
        "",
        "",
        "",
        "",
        emptyList<String>(),
        "",
        emptyList<String>()

    )
}
