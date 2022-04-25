package com.kashif.kmmscientists.data.repository

import com.kashif.kmmscientists.data.entities.ScientistEntity
import com.kashif.kmmscientists.domain.Constants
import io.netty.util.Constant
import org.litote.kmongo.coroutine.CoroutineDatabase
import org.litote.kmongo.coroutine.coroutine
import org.litote.kmongo.reactivestreams.KMongo

class MongoRepository(private val database: CoroutineDatabase) {



    val  scientistCollection = database.getCollection<ScientistEntity>()

    suspend fun addScientist(scientist: ScientistEntity) {


        println(scientist)
        scientistCollection.insertOne(scientist)
    }

     suspend fun getAllScientists(): List<ScientistEntity> {
        val list =  scientistCollection.find().toList()

         return list
    }

}