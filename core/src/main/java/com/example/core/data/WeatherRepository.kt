package com.example.core.data

import com.example.core.data.network.NetworkServiceBuilder
import com.example.core.data.network.WeatherApiEndpoints
import com.example.core.domain.WeatherModel
import kotlinx.coroutines.awaitAll
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class WeatherRepository(private val weatherDataSource: WeatherDataSource) {
    fun getWeatherData(city: String) {
        val weatherRequest = NetworkServiceBuilder.buildService(WeatherApiEndpoints::class.java)
        val weatherCall = weatherRequest.getWeather(city)
        weatherCall.enqueue(object : Callback<WeatherModel> {
            override fun onResponse(
                call: Call<WeatherModel>,
                response: Response<WeatherModel>
            ) {
                if (response.isSuccessful) {

                }
            }

            override fun onFailure(call: Call<WeatherModel>, t: Throwable) {
            }
        })
    }
}