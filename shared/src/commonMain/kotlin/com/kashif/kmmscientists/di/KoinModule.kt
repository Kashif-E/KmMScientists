package com.kashif.kmmscientists.di

import com.kashif.kmmscientists.data.ResponseHandler
import com.kashif.kmmscientists.data.local.realm_service.RealmServiceImpl
import com.kashif.kmmscientists.data.remote.scientists_service.ScientistServiceImpl
import com.kashif.kmmscientists.data.repository.RepositoryImpl
import com.kashif.kmmscientists.domain.usecase.GetAllScientistUseCase
import com.kashif.kmmscientists.domain.usecase.GetScientistsByOriginUseCase
import com.kashif.kmmscientists.platformModule
import kotlinx.serialization.json.Json
import org.koin.core.Koin
import org.koin.core.context.startKoin
import org.koin.core.parameter.parametersOf
import org.koin.dsl.KoinAppDeclaration
import org.koin.dsl.module
import kotlin.reflect.KClass


fun initKoin(appDeclaration: KoinAppDeclaration = {}) =
    startKoin {

        appDeclaration()
        modules(commonModule(), platformModule())
    }


fun initKoin() = initKoin {}

fun commonModule() = module {

    single {
        RealmServiceImpl()
    }
    single {
        ScientistServiceImpl(get(), get())
    }
    single {
        ResponseHandler()
    }
    single {
        RepositoryImpl(get(), get(), get())
    }

    single {
        GetScientistsByOriginUseCase(get())
    }

    //usecase
    single {
        GetAllScientistUseCase(get())
    }
}

fun createJson() = Json { isLenient = true; ignoreUnknownKeys = true }

@Suppress("UNCHECKED_CAST")
fun <T> Koin.getDependency(clazz: KClass<*>): T {
    return get(clazz, null) { parametersOf(clazz.simpleName) } as T
}

