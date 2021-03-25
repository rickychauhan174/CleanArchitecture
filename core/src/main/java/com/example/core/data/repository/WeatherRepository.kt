package com.example.core.data.repository

import com.example.core.data.datasource.WeatherDataSource
import com.example.core.data.datasource.WeatherDataSourceImpl
import com.example.core.domain.WeatherModel

/**
 * WeatherRepository
 * @param weatherDataSourceImpl : di for WeatherDataSourceImpl
 */
class WeatherRepository(private val weatherDataSourceImpl: WeatherDataSourceImpl) {
    fun getWeatherData(city: String, callBack: WeatherRepositoryCallback) {
        weatherDataSourceImpl.weatherRemoteData(
            city,
            object : WeatherDataSource.WeatherDataSourceCallback {
                override fun onWeatherDataLoadRemote(weather: WeatherModel?) {
                    callBack.onWeatherLoaded(weather)
                }
            })
    }

    interface WeatherRepositoryCallback {
        fun onWeatherLoaded(weather: WeatherModel?)
    }
}