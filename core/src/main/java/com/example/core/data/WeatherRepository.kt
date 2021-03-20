package com.example.core.data

import com.example.core.data.network.NetworkServiceBuilder
import com.example.core.data.network.WeatherApiEndpoints
import com.example.core.domain.WeatherModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


object WeatherRepository {
    fun getWeatherData(city: String, callBack: WeatherCallback) {
        val weatherRequest = NetworkServiceBuilder.buildService(WeatherApiEndpoints::class.java)
        val weatherCall = weatherRequest.getWeather(city)
        weatherCall.enqueue(object : Callback<WeatherModel> {
            override fun onResponse(
                call: Call<WeatherModel>,
                response: Response<WeatherModel>
            ) {
                if (response.isSuccessful) {
                    callBack.onWeatherLoaded(response.body()!!)
                }
            }

            override fun onFailure(call: Call<WeatherModel>, t: Throwable) {
            }
        })
    }

    interface WeatherCallback {
        fun onWeatherLoaded(weather: WeatherModel?)
    }
}