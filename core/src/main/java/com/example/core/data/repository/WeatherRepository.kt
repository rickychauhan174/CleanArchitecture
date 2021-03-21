package com.example.core.data.repository

import com.example.core.data.datasource.WeatherDataSource
import com.example.core.data.datasource.WeatherDataSourceImpl
import com.example.core.domain.WeatherModel

object WeatherRepository {
    fun getWeatherData(city: String, callBack: WeatherCallback) {
        WeatherDataSourceImpl.weatherRemoteData(
            city,
            object : WeatherDataSource.WeatherDataSourceCallback {
                override fun onWeatherDataLoadRemote(weather: WeatherModel?) {
                    callBack.onWeatherLoaded(weather)
                }
            })
    }

    interface WeatherCallback {
        fun onWeatherLoaded(weather: WeatherModel?)
    }
}