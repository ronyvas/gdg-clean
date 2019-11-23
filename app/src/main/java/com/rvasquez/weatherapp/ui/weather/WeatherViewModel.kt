package com.rvasquez.weatherapp.ui.weather

import com.rvasquez.domain.interaction.weather.GetWeatherUseCase
import com.rvasquez.domain.model.WeatherInfo
import com.rvasquez.domain.model.onFailure
import com.rvasquez.domain.model.onSuccess
import com.rvasquez.weatherapp.ui.base.BaseViewModel
import com.rvasquez.weatherapp.ui.base.Error
import com.rvasquez.weatherapp.ui.base.Success

/**
 * Created by rvasquez on 2019-11-22.
 */
class WeatherViewModel(private val getWeather: GetWeatherUseCase) : BaseViewModel<WeatherInfo>() {

    fun getWeatherForLocation(location: String = DEFAULT_CITY_NAME) = executeUseCase {
        getWeather(location)
            .onSuccess { _viewState.value = Success(it) }
            .onFailure { _viewState.value = Error(it.throwable) }
    }

    companion object {
        private const val DEFAULT_CITY_NAME = "San Salvador"
    }
}
