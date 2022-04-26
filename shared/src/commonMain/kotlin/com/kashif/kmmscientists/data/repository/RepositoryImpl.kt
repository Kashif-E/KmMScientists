package com.kashif.kmmscientists.data.repository

import com.kashif.kmmscientists.data.remote.scientists_service.ScientistServiceImpl
import com.kashif.kmmscientists.domain.domain_model.ScientistDomainModel
import com.kashif.kmmscientists.data.DataState
import com.kashif.kmmscientists.data.ResponseHandler
import com.kashif.kmmscientists.data.local.entities.asDomainModel
import com.kashif.kmmscientists.data.local.realm_service.RealmServiceImpl
import com.kashif.kmmscientists.data.remote.dto.asDomainModel
import com.kashif.kmmscientists.data.remote.dto.asEntity
import com.kashif.kmmscientists.domain.util.CommonFlow
import com.kashif.kmmscientists.domain.util.asCommonFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.onCompletion

class RepositoryImpl(
    private val serviceImpl: ScientistServiceImpl,
    private val responseHandler: ResponseHandler,
    private val realmServiceImpl: RealmServiceImpl
) : AbstractRepository() {


    fun getAllScientists(): CommonFlow<DataState<List<ScientistDomainModel>>> =
        flow<DataState<List<ScientistDomainModel>>> {

            realmServiceImpl.getAllScientists().collectLatest { resultsChange ->
                if (resultsChange.list.isEmpty()) {
                    serviceImpl.getAllScientists().collect { dataState ->

                        when (dataState) {
                            is DataState.Success -> {
                                realmServiceImpl.insertScientistsToRealm(
                                    dataState.data?.asEntity() ?: emptyList()
                                )
                            }
                            is DataState.Error -> {
                                emit(
                                    responseHandler.handleException(
                                        dataState.error
                                    )
                                )
                            }
                            else -> {
                                emit(
                                    responseHandler.handleException(
                                        dataState.error
                                    )
                                )
                            }
                        }

                    }
                } else {
                    emit(
                        responseHandler.handleSuccess(
                            resultsChange.list.asDomainModel()
                        )
                    )
                }
            }


        }.asCommonFlow()

}