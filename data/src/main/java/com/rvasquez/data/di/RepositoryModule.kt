package com.rvasquez.data.di

import com.rvasquez.data.repository.weather.WeatherRepositoryImpl
import com.rvasquez.data.common.utils.Connectivity
import com.rvasquez.data.common.utils.ConnectivityImpl
import com.rvasquez.domain.repository.WeatherRepository
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val repositoryModule = module {
    factory<WeatherRepository> { WeatherRepositoryImpl(get(), get()) }
    factory<Connectivity> { ConnectivityImpl(androidContext()) }
}