package com.rvasquez.domain.di


import com.rvasquez.domain.interaction.weather.GetWeatherUseCase
import com.rvasquez.domain.interaction.weather.GetWeatherUseCaseImpl
import org.koin.dsl.module

val interactionModule = module {
    factory<GetWeatherUseCase> { GetWeatherUseCaseImpl(get()) }
}
