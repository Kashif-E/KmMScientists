package com.kashif.kmmscientists.data.repository

import com.kashif.kmmscientists.data.DataState
import com.kashif.kmmscientists.domain.domain_model.ScientistDomainModel
import com.kashif.kmmscientists.domain.util.CommonFlow

abstract class AbstractRepository {
    abstract fun getAllScientists(): CommonFlow<DataState<List<ScientistDomainModel>>>
    abstract fun getScientistBasedOnOrigin(origin: String): CommonFlow<DataState<out Any>>
}