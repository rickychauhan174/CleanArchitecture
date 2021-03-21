package com.example.core.interactors

import com.example.core.data.repository.WeatherRepository
import com.example.core.domain.WeatherModel

class GetWeatherDataUseCaseImpl : GetWeatherDataUseCase {
    override fun execute(callBack: GetWeatherDataUseCase.UseCaseCallback) {
        //TODO: remove hard coded city name
        WeatherRepository.getWeatherData("Bangalore", object : WeatherRepository.WeatherCallback {
            override fun onWeatherLoaded(weather: WeatherModel?) {
                callBack.onDataLoaded(weather)
            }
        })
    }
}