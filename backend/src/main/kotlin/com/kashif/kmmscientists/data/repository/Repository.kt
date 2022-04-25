package com.kashif.kmmscientists.data.repository

import com.kashif.kmmscientists.data.local.entities.ScientistEntity
import org.litote.kmongo.coroutine.CoroutineDatabase
import org.litote.kmongo.eq

class Repository(private val database: CoroutineDatabase) {


    private val scientistCollection = database.getCollection<ScientistEntity>()

    suspend fun getScientistByOrigin(origin: String) =
        scientistCollection.find(ScientistEntity::origin eq origin).toList()

    suspend fun addScientist(scientist: ScientistEntity) {


        scientistCollection.insertOne(scientist)
    }

    suspend fun getAllScientists() = scientistCollection.find().toList()

    suspend fun getScientistById(id: Int) = scientistCollection.find(ScientistEntity::id eq id).toList()

}