package com.kashif.kmmscientists.data.repository

import com.kashif.kmmscientists.data.DataState
import com.kashif.kmmscientists.domain.domain_model.ScientistDomainModel
import com.kashif.kmmscientists.domain.util.CommonFlow
import kotlinx.coroutines.flow.Flow

abstract class AbstractRepository {
    abstract fun getAllScientists(): Flow<DataState<List<ScientistDomainModel>>>
    abstract fun getScientistBasedOnOrigin(origin: String): Flow<DataState<out Any>>
}