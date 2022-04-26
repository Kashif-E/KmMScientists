package com.kashif.kmmscientists.data.repository

import com.kashif.kmmscientists.data.remote.scientists_service.ScientistServiceImpl
import com.kashif.kmmscientists.domain.domain_model.ScientistDomainModel
import com.kashif.kmmscientists.data.DataState
import com.kashif.kmmscientists.data.ResponseHandler
import com.kashif.kmmscientists.data.remote.dto.asDomainModel
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.onCompletion

class RepositoryImpl(private val serviceImpl: ScientistServiceImpl,private val responseHandler: ResponseHandler) : AbstractRepository() {


    fun getAllScientists() =  serviceImpl.getAllScientists()
        //flow<DataState<List<ScientistDomainModel>>> {
//
//        serviceImpl.getAllScientists().collect { dataState ->
//
//            when (dataState) {
//                is DataState.Success -> {
//                    emit(
//                        dataState.data.asDomainModel()
//                    )
//                }
//                is DataState.Error -> {
//                    emit(
//                        dataState.error
//                    )
//                }
//                else -> {
//                    emit(
//
//                    )
//                }
//            }
//
//        }
//        // insert data to db here
//
//
//    }

}