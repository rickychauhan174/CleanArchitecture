package com.example.core.interactors

import com.example.core.data.WeatherRepository

class GetWeatherDataUseCase(private val weatherRepository: WeatherRepository) {
    suspend operator fun invoke() = weatherRepository.getWeatherData()
}