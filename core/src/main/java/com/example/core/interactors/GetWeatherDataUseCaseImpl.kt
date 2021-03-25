package com.example.core.interactors

import com.example.core.data.repository.WeatherRepository
import com.example.core.domain.WeatherModel

/**
 * Implementation of GetWeatherDataUseCase
 * @param weatherRepository : di for WeatherRepository
 */
class GetWeatherDataUseCaseImpl(private val weatherRepository: WeatherRepository) : GetWeatherDataUseCase {
    override fun execute(callBack: GetWeatherDataUseCase.WeatherDataUseCaseCallback) {
        //TODO: remove hard coded city name
        weatherRepository.getWeatherData("Bangalore", object : WeatherRepository.WeatherRepositoryCallback {
            override fun onWeatherLoaded(weather: WeatherModel?) {
                callBack.onDataLoaded(weather)
            }
        })
    }
}