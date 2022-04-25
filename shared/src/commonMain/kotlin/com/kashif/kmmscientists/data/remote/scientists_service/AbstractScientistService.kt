package com.kashif.kmmscientists.data.remote.scientists_service

import com.kashif.kmmscientists.data.remote.dto.ScientistDTO

interface AbstractScientistService {

    suspend fun getAllScientists() : List<ScientistDTO>

    suspend fun getScientistsByOrigin() : List<ScientistDTO>
}