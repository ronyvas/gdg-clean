package com.rvasquez.domain.repository

import com.rvasquez.domain.model.WeatherInfo
import com.rvasquez.domain.model.Result

interface WeatherRepository {
    suspend fun getWeatherForLocation(location: String): Result<WeatherInfo>
}