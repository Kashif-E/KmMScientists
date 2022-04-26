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
import kotlinx.coroutines.flow.*

class RepositoryImpl(
    private val serviceImpl: ScientistServiceImpl,
    private val responseHandler: ResponseHandler,
    private val realmServiceImpl: RealmServiceImpl
) : AbstractRepository() {


    override fun getAllScientists(): CommonFlow<DataState<List<ScientistDomainModel>>> =
        channelFlow<DataState<List<ScientistDomainModel>>> {

            realmServiceImpl.getAllScientists().collect { resultsChange ->
                if (resultsChange.list.isEmpty()) {
                    println("===> empty")
                    getDataFromRemoteService { message ->

                        send(
                            responseHandler.handleException(message)
                        )


                    }
                } else {
                    println("==> full")
                    send(
                        responseHandler.handleSuccess(
                            resultsChange.list.asDomainModel()
                        )
                    )
                }
            }


        }.asCommonFlow()

    private suspend fun getDataFromRemoteService(onError: suspend (message: DataState.Message) -> Unit) {
        serviceImpl.getAllScientists().collect { dataState ->

            when (dataState) {
                is DataState.Success -> {
                    realmServiceImpl.insertScientistsToRealm(
                        dataState.data?.asEntity() ?: emptyList()
                    )
                }
                is DataState.Error -> {

                    onError(
                        dataState.error
                    )
                }
                else -> {
                    onError(
                        dataState.error
                    )
                }
            }

        }
    }

}


