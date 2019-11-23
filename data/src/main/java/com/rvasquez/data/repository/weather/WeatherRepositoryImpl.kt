package com.rvasquez.data.repository.weather

import com.rvasquez.data.database.dao.WeatherDao
import com.rvasquez.data.database.model.WeatherEntity
import com.rvasquez.data.networking.WeatherApi
import com.rvasquez.data.networking.base.getData
import com.rvasquez.domain.model.Result
import com.rvasquez.domain.model.WeatherInfo
import com.rvasquez.domain.repository.WeatherRepository

class WeatherRepositoryImpl(
    private val weatherApi: WeatherApi,
    private val weatherDao: WeatherDao
) : BaseRepository<WeatherInfo, WeatherEntity>(), WeatherRepository {
    override suspend fun getWeatherForLocation(location: String): Result<WeatherInfo> {
        return fetchData(
            apiDataProvider = {
                weatherApi.getWeatherForLocation(location).getData(
                    fetchFromCacheAction = { weatherDao.getWeatherInfoForCity(location) },
                    cacheAction = { weatherDao.saveWeatherInfo(it) })
            },
            dbDataProvider = { weatherDao.getWeatherInfoForCity(location) }
        )
    }
}