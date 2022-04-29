package com.kashif.kmmscientists.data.local.realm_service

import com.kashif.kmmscientists.data.local.entities.ScientistDatabaseModel
import io.realm.Realm
import io.realm.RealmConfiguration
import io.realm.query
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async

class RealmServiceImpl(private val realm: Realm) : AbstractRealmService {


  override  fun insertScientistsToRealm(scientists: List<ScientistDatabaseModel>) {

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

   override fun getScientistByOrigin(origin: String) =
        realm.query<ScientistDatabaseModel>("origin == $origin").find().asFlow()

   override fun getAllScientists() = realm.query<ScientistDatabaseModel>().find().asFlow()
}