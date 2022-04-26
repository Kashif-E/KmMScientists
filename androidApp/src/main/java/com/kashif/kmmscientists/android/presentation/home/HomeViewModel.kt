package com.kashif.kmmscientists.android.presentation.home

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.kashif.kmmscientists.data.DataState
import com.kashif.kmmscientists.domain.usecase.GetAllScientistUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class HomeViewModel(
    private val getAllScientistUseCase: GetAllScientistUseCase
) : ViewModel() {

    init {
        getAllScientists()
    }

    private fun getAllScientists() {
        viewModelScope.launch(Dispatchers.IO) {

            getAllScientistUseCase.invoke().collectCommon { dataState ->

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

            }

        }
    }
}