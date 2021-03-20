package com.example.core.interactors

import com.example.core.data.WeatherRepository
import com.example.core.domain.WeatherModel

interface GetWeatherDataUseCase {
    interface Callback {
        fun onDataLoaded(weather: WeatherModel?)
    }
    fun execute(weatherRepository: WeatherRepository, callBack: Callback)
}