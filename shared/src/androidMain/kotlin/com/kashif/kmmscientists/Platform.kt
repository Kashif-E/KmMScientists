package com.kashif.kmmscientists

import android.os.Parcelable
import android.util.Log
import io.ktor.client.*
import io.ktor.client.engine.android.*
import io.ktor.client.features.*
import io.ktor.client.features.json.*
import io.ktor.client.features.json.serializer.*
import io.ktor.client.features.logging.*
import io.ktor.client.features.observer.*
import kotlinx.parcelize.Parcelize
import org.koin.dsl.module


actual typealias CommonParcelize = Parcelize

actual typealias CommonParcelable = Parcelable
actual fun platformModule() = module {


    single {
        HttpClient(Android) {

            install(JsonFeature) {
                serializer = KotlinxSerializer(
                    kotlinx.serialization.json.Json {

                        ignoreUnknownKeys = true
                        prettyPrint = true

                    })
            }

            install(Logging) {
                logger = object : Logger {
                    override fun log(message: String) {
                        Log.e("Logger Ktor =>", message)
                    }

                }
                level = LogLevel.ALL
            }

            install(ResponseObserver) {
                onResponse { response ->
                    Log.e("Ktor =>", response.toString())
                    Log.e("HTTP status:", "${response.status.value}")
                }
            }


            install(HttpTimeout) {
                requestTimeoutMillis = 15000L
                connectTimeoutMillis = 15000L
                socketTimeoutMillis = 15000L
            }


        }
    }
}





