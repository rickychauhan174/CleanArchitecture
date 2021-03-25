package com.example.core.data.network

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class NetworkServiceBuilder {
    private fun basicOkHttpClient() = OkHttpClient.Builder().build()
    private fun baseUrl() = "http://api.openweathermap.org/data/2.5/"
    private fun provideRetrofit() = Retrofit.Builder()
        .baseUrl(baseUrl())
        .addConverterFactory(GsonConverterFactory.create())
        .client(basicOkHttpClient())
        .build()

    fun createWeatherApiService(): WeatherApiService {
        return provideRetrofit().create(WeatherApiService::class.java)
    }
}