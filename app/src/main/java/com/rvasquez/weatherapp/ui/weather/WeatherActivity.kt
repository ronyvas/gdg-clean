package com.rvasquez.weatherapp.ui.weather

import android.os.Bundle
import com.rvasquez.domain.model.WeatherInfo
import com.rvasquez.weatherapp.R
import com.rvasquez.weatherapp.common.convertKelvinToCelsius
import com.rvasquez.weatherapp.common.extensions.hideKeyboard
import com.rvasquez.weatherapp.common.extensions.onClick
import com.rvasquez.weatherapp.common.extensions.snackbar
import com.rvasquez.weatherapp.common.extensions.subscribe
import com.rvasquez.weatherapp.ui.base.*
import kotlinx.android.synthetic.main.activity_weather.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class WeatherActivity : BaseActivity() {

    private val viewModel: WeatherViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_weather)

        subscribeToData()

        getWeatherButton.onClick {
            getWeatherButton.hideKeyboard()
            viewModel.getWeatherForLocation(cityInput.text.toString())
        }
    }

    private fun subscribeToData() {
        viewModel.viewState.subscribe(this, ::handleViewState)
    }

    private fun handleViewState(viewState: ViewState<WeatherInfo>) {
        when (viewState) {
            is Loading -> showLoading(weatherLoadingProgress)
            is Success -> showWeatherData(viewState.data)
            is Error -> handleError(viewState.error.localizedMessage)
            is NoInternetState -> showNoInternetError()
        }
    }

    private fun handleError(error: String) {
        hideLoading(weatherLoadingProgress)
        showError(error, weatherFragmentContainer)
    }

    private fun showNoInternetError() {
        hideLoading(weatherLoadingProgress)
        snackbar(getString(R.string.no_internet_error_message), weatherFragmentContainer)
    }

    private fun showWeatherData(weatherInfo: WeatherInfo) {
        hideLoading(weatherLoadingProgress)
        temperature.text = getString(R.string.celcius_format, convertKelvinToCelsius(weatherInfo.temperature))
        pressure.text = getString(R.string.pressure_format, weatherInfo.pressure)
        humidity.text = getString(R.string.humidity_format, weatherInfo.humidity)
    }
}
