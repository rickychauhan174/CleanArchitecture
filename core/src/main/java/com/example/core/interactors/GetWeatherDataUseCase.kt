package com.example.core.interactors

import com.example.core.domain.WeatherModel

interface GetWeatherDataUseCase {
    interface UseCaseCallback {
        fun onDataLoaded(weather: WeatherModel?)
    }

    fun execute(callBack: UseCaseCallback)
}