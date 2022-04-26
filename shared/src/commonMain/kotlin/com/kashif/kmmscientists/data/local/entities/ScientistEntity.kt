package com.kashif.kmmscientists.data.local.entities

import com.kashif.kmmscientists.domain.domain_model.ScientistDomainModel
import io.realm.RealmObject

class ScientistDatabaseModel() : RealmObject {
    var id: Int = 0
    var name: String = ""
    var fullName: String = ""
    var latinizedName: String = ""
    var description: String = ""
    var origin: String = ""
    var image: String = ""
    var birthPlace: String = ""
    var dob: String = ""
    var dod: String = ""
    var books: String = ""
    var titles: String = ""
    var achievements: String = ""


}

fun ScientistDatabaseModel.asDomainModel() = ScientistDomainModel(
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
    books.split(','),
    titles,
    achievements.split(',')
)

fun List<ScientistDatabaseModel>.asDomainModel(): List<ScientistDomainModel>? {
    return map {
        it.asDomainModel()
    }
}