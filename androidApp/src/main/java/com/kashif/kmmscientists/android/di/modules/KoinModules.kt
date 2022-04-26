package com.kashif.kmmscientists.android.di.modules

import com.kashif.kmmscientists.android.presentation.home.HomeViewModel
import org.koin.androidx.compose.get
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module


val viewModelsModule = module {
    viewModel { HomeViewModel(get()) }
}