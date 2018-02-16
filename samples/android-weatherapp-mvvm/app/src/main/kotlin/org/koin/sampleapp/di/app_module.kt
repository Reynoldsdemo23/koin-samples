package org.koin.sampleapp.di

import org.koin.android.architecture.ext.viewModel
import org.koin.dsl.module.applicationContext
import org.koin.sampleapp.repository.WeatherRepository
import org.koin.sampleapp.repository.WeatherRepositoryImpl
import org.koin.sampleapp.util.rx.ApplicationSchedulerProvider
import org.koin.sampleapp.util.rx.SchedulerProvider
import org.koin.sampleapp.view.detail.DetailViewModel
import org.koin.sampleapp.view.result.WeatherResultViewModel
import org.koin.sampleapp.view.search.MainViewModel


val weatherModule = applicationContext {

    viewModel { MainViewModel(get(), get()) }

    viewModel { WeatherResultViewModel(get(), get()) }

    viewModel { DetailViewModel(get(), get()) }

    bean { WeatherRepositoryImpl(get()) as WeatherRepository }
}

val rxModule = applicationContext {
    // provided components
    bean { ApplicationSchedulerProvider() as SchedulerProvider }
}

// Gather all app modules
val weatherApp = listOf(weatherModule, rxModule)
