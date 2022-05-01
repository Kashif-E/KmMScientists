package com.kashif.kmmscientists.domain.domain_model

import com.kashif.kmmscientists.CommonParcelable
import com.kashif.kmmscientists.CommonParcelize


@CommonParcelize
data class ScientistDomainModel(

    val id: Int? = 0,
    val name: String? = "",
    val fullName: String? = "",
    val latinizedName: String? = "",
    val description: String? = "",
    val origin: String? = "",
    val image: String? = "",
    val birthPlace: String? = "",
    val dob: String? = "",
    val dod: String? = "",
    val books: List<String>? = emptyList(),
    val titles: String? = "",
    val achievements: List<String>? = emptyList()

) : CommonParcelable {
    constructor() : this(
        id = 0,
        name = "",
        fullName = "",
        latinizedName ="",
        description ="",
        origin ="",
        image="",
        birthPlace ="",
        dob ="",
        dod="",
        books = emptyList(),
        titles="",
        achievements = emptyList()
    )
}