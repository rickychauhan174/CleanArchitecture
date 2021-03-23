package com.example.core.interactors

import com.example.core.data.repository.WeatherRepository
import com.example.core.domain.WeatherModel

class GetWeatherDataUseCaseImpl(private val weatherRepository: WeatherRepository) : GetWeatherDataUseCase {
    override fun execute(callBack: GetWeatherDataUseCase.UseCaseCallback) {
        //TODO: remove hard coded city name
        weatherRepository.getWeatherData("Bangalore", object : WeatherRepository.WeatherCallback {
            override fun onWeatherLoaded(weather: WeatherModel?) {
                callBack.onDataLoaded(weather)
            }
        })
    }
}