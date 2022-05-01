package com.kashif.kmmscientists.domain.usecase

import com.kashif.kmmscientists.data.repository.AbstractRepository
import com.kashif.kmmscientists.data.repository.RepositoryImpl
import com.kashif.kmmscientists.domain.util.asCommonFlow

class GetScientistsByOriginUseCase(private val repositoryImpl: AbstractRepository) {

    operator fun invoke(origin: String) =
        repositoryImpl.getScientistBasedOnOrigin(origin).asCommonFlow()
}