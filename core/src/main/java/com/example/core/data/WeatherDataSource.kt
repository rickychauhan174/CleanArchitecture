package com.example.core.data

import com.example.core.domain.WeatherModel

interface WeatherDataSource {
    suspend fun weatherData(): WeatherModel
}