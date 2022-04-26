package com.kashif.kmmscientists.domain.usecase

import com.kashif.kmmscientists.data.repository.RepositoryImpl
import com.kashif.kmmscientists.domain.util.asCommonFlow

class GetScientistsByOriginUseCase (private val repositoryImpl: RepositoryImpl) {

    operator fun invoke(origin: String) = repositoryImpl.getScientistBasedOnOrigin(origin)
}