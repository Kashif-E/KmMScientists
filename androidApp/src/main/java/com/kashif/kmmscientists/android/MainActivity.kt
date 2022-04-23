package com.kashif.kmmscientists.android

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.kashif.kmmscientists.android.presentation.home.NavGraphs

import com.kashif.kmmscientists.android.presentation.theme.KmMScientistTheme
import com.ramcosta.composedestinations.DestinationsNavHost

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            KmMScientistTheme {
                DestinationsNavHost(navGraph = NavGraphs.root)
            }
        }
    }
}
