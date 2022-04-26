package com.kashif.kmmscientists.android

import android.app.Application
import com.kashif.kmmscientists.android.di.modules.viewModelsModule
import com.kashif.kmmscientists.di.initKoin
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.logger.Level

class KmMScientistApp : Application() {

    override fun onCreate() {
        super.onCreate()

        initKoin {
            androidContext(this@KmMScientistApp)
            androidLogger(if (BuildConfig.DEBUG) Level.ERROR else Level.INFO)
            modules(viewModelsModule)

        }
    }
}