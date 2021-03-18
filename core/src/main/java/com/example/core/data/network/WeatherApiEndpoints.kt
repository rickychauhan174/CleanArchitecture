package com.example.core.data.network

import com.example.core.domain.WeatherModel
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherApiEndpoints {
    @GET("weather")
    fun getWeather(@Query("q") city: String,
                   @Query("appid") apiKey: String = "6857b790e79c2cc892a6d00bb304e688"): Call<WeatherModel>
}