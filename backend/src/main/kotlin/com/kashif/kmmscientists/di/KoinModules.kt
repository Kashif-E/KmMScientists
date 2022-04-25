package com.kashif.kmmscientists.di

import com.kashif.kmmscientists.data.repository.MongoRepository
import com.kashif.kmmscientists.domain.Constants
import org.koin.dsl.module
import org.litote.kmongo.coroutine.coroutine
import org.litote.kmongo.reactivestreams.KMongo


val AppModules = module {

    single {
        MongoRepository(get())
    }


    single {
        KMongo.createClient().coroutine.getDatabase(Constants.DATABASE)

    }

}
