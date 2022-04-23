package com.kashif.kmmscientists.data.repository

import com.kashif.kmmscientists.data.entities.ScientistEntity
import com.mongodb.client.MongoCollection
import com.mongodb.client.MongoDatabase


class MongoRepository(private val database: MongoDatabase) {


    private val scientistCollection: MongoCollection<ScientistEntity> =
        database.getCollection(ScientistEntity::class.java.name, ScientistEntity::class.java)


    init {
//        runBlocking {
//            scientistCollection.deleteMany(Document())
//        }


    }

    suspend fun addScientist(scientist: ScientistEntity) {


        println(scientist)
        scientistCollection.insertOne(scientist)
    }

    suspend fun getAllScientists() = scientistCollection.find().toList()

}