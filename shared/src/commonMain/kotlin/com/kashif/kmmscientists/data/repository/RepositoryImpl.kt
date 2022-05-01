package com.kashif.kmmscientists.data.repository

import com.kashif.kmmscientists.data.remote.scientists_service.ScientistServiceImpl
import com.kashif.kmmscientists.domain.domain_model.ScientistDomainModel
import com.kashif.kmmscientists.data.DataState
import com.kashif.kmmscientists.data.ResponseHandler
import com.kashif.kmmscientists.data.local.entities.asDomainModel
import com.kashif.kmmscientists.data.local.realm_service.AbstractRealmService
import com.kashif.kmmscientists.data.local.realm_service.RealmServiceImpl
import com.kashif.kmmscientists.data.remote.dto.ScientistDTO
import com.kashif.kmmscientists.data.remote.dto.asDomainModel
import com.kashif.kmmscientists.data.remote.dto.asEntity
import com.kashif.kmmscientists.data.remote.scientists_service.AbstractScientistService
import com.kashif.kmmscientists.domain.util.CommonFlow
import com.kashif.kmmscientists.domain.util.asCommonFlow
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.flow.internal.ChannelFlow

class RepositoryImpl(
    private val serviceImpl: AbstractScientistService,
    private val responseHandler: ResponseHandler,
    private val realmServiceImpl: AbstractRealmService
) : AbstractRepository() {


   override fun getScientistBasedOnOrigin(origin: String) = channelFlow {

        realmServiceImpl.getScientistByOrigin(
            origin
        ).collect { result ->

            if (result.list.isNullOrEmpty()) {
                getScientistByOriginFromRemoteService(origin = origin, { message ->

                    send(
                        responseHandler.handleException<DataState<List<ScientistDTO>>>(message)
                    )

                }, { data ->

                    send(
                        responseHandler.handleSuccess(
                            data
                        )
                    )
                })

            } else {
                send(
                    responseHandler.handleSuccess(
                        result.list
                    )
                )
            }
        }

    }

    override fun getAllScientists() =
        channelFlow<DataState<List<ScientistDomainModel>>> {

            realmServiceImpl.getAllScientists().collect { resultsChange ->
                if (resultsChange.list.isEmpty()) {
                    println("===> empty")
                    getAllScientistsFromRemoteService ({ message ->

                        send(
                            responseHandler.handleException(message)
                        )


                    },{data ->
                        println(data.toString())
                        send(
                            responseHandler.handleSuccess(
                               data
                            )
                        )
                    })
                } else {
                    println("==> full")
                    send(
                        responseHandler.handleSuccess(
                            resultsChange.list.asDomainModel()
                        )
                    )
                }
            }


        }

    private suspend fun getScientistByOriginFromRemoteService(
        origin: String,
        onError: suspend (message: DataState.Message) -> Unit,
        data: suspend (list: List<ScientistDTO>) -> Unit
    ) {
        serviceImpl.getScientistsByOrigin(origin).collect { dataState ->

            when (dataState) {
                is DataState.Success -> {
                    data(
                        dataState.data ?: emptyList()
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


    private suspend fun getAllScientistsFromRemoteService(onError: suspend (message: DataState.Message) -> Unit, data : suspend (data: List<ScientistDomainModel>)-> Unit) {
        serviceImpl.getAllScientists().collect { dataState ->

            when (dataState) {
                is DataState.Success -> {
                    realmServiceImpl.insertScientistsToRealm(
                        dataState.data?.asEntity() ?: emptyList()
                    )
                    data(dataState.data?.asDomainModel() ?: emptyList())
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


