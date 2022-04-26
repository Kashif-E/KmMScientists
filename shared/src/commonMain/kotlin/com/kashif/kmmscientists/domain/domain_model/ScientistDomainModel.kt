package com.kashif.kmmscientists.domain.domain_model

data class ScientistDomainModel(

    val id: Int? ,
    val name: String? ,
    val fullName: String? ,
    val latinizedName: String? ,
    val description: String? ,
    val origin: String? ,
    val image: String? ,
    val birthPlace: String? ,
    val dob: String?,
    val dod: String? ,
    val books: List<String>? ,
    val titles: String?,
    val achievements: List<String>?

)