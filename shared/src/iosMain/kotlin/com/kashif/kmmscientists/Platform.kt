package com.kashif.kmmscientists

import com.kashif.kmmscientists.di.getDependency
import io.ktor.client.*
import io.ktor.client.engine.ios.*
import io.ktor.client.features.json.*
import io.ktor.client.features.json.serializer.*
import io.ktor.client.features.logging.*
import io.ktor.client.features.observer.*
import kotlinx.cinterop.ObjCClass
import kotlinx.cinterop.getOriginalKotlinClass
import kotlinx.serialization.json.Json
import org.koin.core.Koin
import org.koin.dsl.module
import platform.Foundation.NSUserDefaults
import platform.UIKit.UIDevice
import kotlin.native.concurrent.ensureNeverFrozen



actual fun platformModule() = module {

    ensureNeverFrozen()



    single {
        HttpClient(Ios) {
            install(JsonFeature) {
                serializer = KotlinxSerializer(
                    kotlinx.serialization.json.Json {
                        coerceInputValues = true
                        ignoreUnknownKeys = true
                        prettyPrint = true

                    })
                install(ResponseObserver) {
                    onResponse { response ->
                        println("Ktor =>$response")
                        print("HTTP status:" + "${response.status.value}")
                    }
                }

                install(Logging) {
                    logger = object : Logger {
                        override fun log(message: String) {
                            println("Logger Ktor => $message")
                        }

                    }
                    level = LogLevel.ALL
                }
            }
        }
    }
}


fun <T> Koin.getDependency(objCClass: ObjCClass): T? = getOriginalKotlinClass(objCClass)?.let {
    getDependency(it)
}

actual interface CommonParcelable