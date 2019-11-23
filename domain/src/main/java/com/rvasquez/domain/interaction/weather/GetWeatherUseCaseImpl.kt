package com.rvasquez.domain.interaction.weather

import com.rvasquez.domain.repository.WeatherRepository

class GetWeatherUseCaseImpl(private val weatherRepository: WeatherRepository) : GetWeatherUseCase {

    override suspend operator fun invoke(location: String) = weatherRepository.getWeatherForLocation(location)

}