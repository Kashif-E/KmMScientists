package com.kashif.kmmscientists.android

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.kashif.kmmscientists.android.presentation.home.NavGraphs

import com.kashif.kmmscientists.android.presentation.theme.KmMScientistTheme
import com.kashif.kmmscientists.data.remote.scientists_service.ScientistServiceImpl
import com.ramcosta.composedestinations.DestinationsNavHost
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import org.koin.android.ext.android.inject

class MainActivity : ComponentActivity() {
    val service: ScientistServiceImpl by inject()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            KmMScientistTheme {
                DestinationsNavHost(navGraph = NavGraphs.root)
            }
        }

        CoroutineScope(Dispatchers.IO).launch {
            val x = service.getAllScientists()

            Log.e("sci", x.toString())
        }
    }
}
