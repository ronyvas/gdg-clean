package com.rvasquez.weatherapp

import android.app.Application
import com.rvasquez.data.di.databaseModule
import com.rvasquez.data.di.networkingModule
import com.rvasquez.data.di.repositoryModule
import com.rvasquez.domain.di.interactionModule
import com.rvasquez.weatherapp.di.appModule
import com.rvasquez.weatherapp.di.presentationModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

/**
 * Created by rvasquez on 2019-11-22.
 */
class WeatherApp : Application() {

    override fun onCreate() {
        super.onCreate()
        instance = this

        startKoin {
            androidContext(this@WeatherApp)
            modules(appModules + domainModules + dataModules)
        }
    }

    companion object {
        lateinit var instance: Application
            private set
    }
}

val appModules = listOf(presentationModule, appModule)
val domainModules = listOf(interactionModule)
val dataModules = listOf(networkingModule, repositoryModule, databaseModule)
