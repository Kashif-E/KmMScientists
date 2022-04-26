package com.kashif.kmmscientists.android.presentation.home

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.kashif.kmmscientists.data.DataState
import com.kashif.kmmscientists.data.remote.dto.ScientistDTO
import com.kashif.kmmscientists.domain.domain_model.ScientistDomainModel
import com.kashif.kmmscientists.domain.usecase.GetAllScientistUseCase
import com.kashif.kmmscientists.domain.usecase.GetScientistsByOriginUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch

class HomeViewModel(
    private val getAllScientistUseCase: GetAllScientistUseCase,
    private val getScientistsByOriginUseCase: GetScientistsByOriginUseCase
) : ViewModel() {

    val list = MutableStateFlow<List<ScientistDomainModel>>(emptyList())
    init {
        getAllScientists()
    }

    private fun getScientistsByOrigin() {
        viewModelScope.launch(Dispatchers.IO) {

            getScientistsByOriginUseCase.invoke("Arab").collectCommon(this, { dataState ->

                when (dataState) {
                    is DataState.Success -> {

                        Log.e("===>", dataState.data.toString())

                    }
                    is DataState.Error -> {

                        Log.e("==>", dataState.error.toString())
                    }
                    else -> {

                    }
                }


            }, { error ->

                print(error.toString())

            })

        }
    }

    private fun emitList(data: List<ScientistDomainModel>) {

        viewModelScope.launch {
            list.emit(data)
        }

    }

    private fun getAllScientists() {
        viewModelScope.launch(Dispatchers.IO) {

            getAllScientistUseCase.invoke().collectCommon(this, { dataState ->

                when (dataState) {
                    is DataState.Success -> {

                        Log.e("===>", dataState.data.toString())
                        emitList(dataState.data!!)
                    }
                    is DataState.Error -> {

                        Log.e("==>", dataState.error.toString())
                    }
                    else -> {

                    }
                }


            }, { error ->

                print(error.toString())

            })

        }
    }
}