package com.rvasquez.domain.interaction.weather

import com.rvasquez.domain.base.BaseUseCase
import com.rvasquez.domain.model.Result
import com.rvasquez.domain.model.WeatherInfo

interface GetWeatherUseCase : BaseUseCase<String, WeatherInfo> {

    override suspend operator fun invoke(location: String): Result<WeatherInfo>

}