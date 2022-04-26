package com.kashif.kmmscientists.data.local.realm_service

import com.kashif.kmmscientists.data.local.entities.ScientistDatabaseModel
import io.realm.Realm
import io.realm.RealmConfiguration
import io.realm.query
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async

class RealmServiceImpl() : AbstractRealmService {

    val config = RealmConfiguration.Builder(schema = setOf(ScientistDatabaseModel::class))
        .build()
    val realm: Realm = Realm.open(config)

    fun insertScientistsToRealm(scientists: List<ScientistDatabaseModel>) {

        CoroutineScope(Dispatchers.Default).async {
            scientists.forEach { scientist ->
                realm.write {
                    copyToRealm(
                        scientist
                    )
                }
            }

        }

    }

    fun getScientistByOrigin(origin: String) =
        realm.query<ScientistDatabaseModel>("origin == $origin").find().asFlow()

    fun getAllScientists() = realm.query<ScientistDatabaseModel>().find().asFlow()
}