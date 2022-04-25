package com.kashif.kmmscientists.di

import com.kashif.kmmscientists.data.remote.scientists_service.AbstractScientistService
import com.kashif.kmmscientists.data.remote.scientists_service.ScientistServiceImpl
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


fun initKoin() = initKoin() {}

fun commonModule() = module {

    single {
        ScientistServiceImpl(get())
    }
}

fun createJson() = Json { isLenient = true; ignoreUnknownKeys = true }

@Suppress("UNCHECKED_CAST")
fun <T> Koin.getDependency(clazz: KClass<*>): T {
    return get(clazz, null) { parametersOf(clazz.simpleName) } as T
}

