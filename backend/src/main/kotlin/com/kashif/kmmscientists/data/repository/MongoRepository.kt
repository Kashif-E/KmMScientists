package com.kashif.kmmscientists.data.repository

import com.kashif.kmmscientists.data.entities.ScientistEntity
import com.mongodb.client.MongoCollection
import com.mongodb.client.MongoDatabase


class MongoRepository(private val database: MongoDatabase) {


    private val scientistCollection: MongoCollection<ScientistEntity>


    init {

        scientistCollection =  database.getCollection(ScientistEntity::class.java.name, ScientistEntity::class.java)

    }

    suspend fun addScientist(scientist: ScientistEntity) {


        println(scientist)
        scientistCollection.insertOne(scientist)
    }

     fun getAllScientists(): List<ScientistEntity> {
        val list =  scientistCollection.find().toList()

         return list
    }

}