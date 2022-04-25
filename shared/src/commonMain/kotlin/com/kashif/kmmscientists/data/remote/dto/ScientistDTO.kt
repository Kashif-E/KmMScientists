package com.kashif.kmmscientists.data.remote.dto


@kotlinx.serialization.Serializable
data class ScientistDTO(

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