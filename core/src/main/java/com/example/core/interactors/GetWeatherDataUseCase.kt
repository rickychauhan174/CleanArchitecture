package com.example.core.interactors

import com.example.core.domain.WeatherModel

interface GetWeatherDataUseCase {
    interface WeatherDataUseCaseCallback {
        fun onDataLoaded(weather: WeatherModel?)
    }

    fun execute(callBack: WeatherDataUseCaseCallback)
}