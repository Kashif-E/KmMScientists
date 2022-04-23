package com.kashif.kmmscientists.di

import com.kashif.kmmscientists.data.repository.MongoRepository
import com.kashif.kmmscientists.domain.Constants.DATABASE
import com.mongodb.MongoClientSettings
import com.mongodb.client.MongoClients
import org.bson.codecs.configuration.CodecRegistries.fromProviders
import org.bson.codecs.configuration.CodecRegistries.fromRegistries
import org.bson.codecs.configuration.CodecRegistry
import org.bson.codecs.pojo.PojoCodecProvider
import org.koin.dsl.module

val AppModules = module {

    single {
        MongoRepository(get())
    }


    single {
        MongoClients.create(
            MongoClientSettings.builder()
                .codecRegistry(
                    fromRegistries(
                        MongoClientSettings.getDefaultCodecRegistry(),
                        fromProviders(PojoCodecProvider.builder().automatic(true).build())
                    )
                )
                .build()
        ).getDatabase(DATABASE)

    }

}
