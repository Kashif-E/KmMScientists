package com.kashif.kmmscientists.data.local.realm_service

import com.kashif.kmmscientists.data.local.entities.ScientistEntity
import io.realm.Realm
import io.realm.notifications.ResultsChange
import io.realm.query
import io.realm.query.find
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.flow.Flow

class RealmServiceImpl(private val realm: Realm) : AbstractRealmService {

    val realmFlow = realm.asFlow()

    fun insertScientistsToRealm(scientists: List<ScientistEntity>) {

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
        realm.query<ScientistEntity>("origin == $origin").find().asFlow()

    fun getAllScientists()= realm.query<ScientistEntity>().find().asFlow()
}