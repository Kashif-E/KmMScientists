package com.kashif.kmmscientists.data.local.realm_service

import com.kashif.kmmscientists.data.local.entities.ScientistDatabaseModel
import io.realm.notifications.ResultsChange
import kotlinx.coroutines.flow.Flow

interface AbstractRealmService {
    fun getAllScientists(): Flow<ResultsChange<ScientistDatabaseModel>>
    fun getScientistByOrigin(origin: String): Flow<ResultsChange<ScientistDatabaseModel>>
    fun insertScientistsToRealm(scientists: List<ScientistDatabaseModel>)
}