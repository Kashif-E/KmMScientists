package com.kashif.kmmscientists.data.remote.scientists_service

import com.kashif.kmmscientists.data.remote.dto.ScientistDTO
import com.kashif.kmmscientists.data.DataState
import kotlinx.coroutines.flow.Flow

interface AbstractScientistService {

    fun getAllScientists() : Flow<DataState<List<ScientistDTO>>>

    suspend fun getScientistsByOrigin(origin: String): Flow<DataState<List<ScientistDTO>>>
}