package com.example.core.interactors

import com.example.core.data.WeatherRepository
import com.example.core.domain.WeatherModel

class GetWeatherDataUseCaseImpl: GetWeatherDataUseCase {
    override fun execute(weatherRepository: WeatherRepository, callBack: GetWeatherDataUseCase.Callback) {
        //TODO: remove hard coded city name
        weatherRepository.getWeatherData("Bangalore", object : WeatherRepository.WeatherCallback {
            override fun onWeatherLoaded(weather: WeatherModel?) {
                callBack.onDataLoaded(weather)
            }
        })
    }
}