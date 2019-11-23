package com.rvasquez.weatherapp.di

import com.rvasquez.data.common.coroutine.CoroutineContextProvider
import org.koin.dsl.module

val appModule = module {
    single { CoroutineContextProvider() }
}