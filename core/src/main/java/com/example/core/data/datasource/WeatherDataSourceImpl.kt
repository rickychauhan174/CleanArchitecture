package com.example.core.data.datasource

import com.example.core.data.network.NetworkServiceBuilder
import com.example.core.data.network.WeatherApiEndpoints
import com.example.core.domain.WeatherModel
import retrofit2.Call
import retrofit2.Response

object WeatherDataSourceImpl :
    WeatherDataSource {
    override fun weatherRemoteData(
        city: String,
        dataSourceCallBack: WeatherDataSource.WeatherDataSourceCallback
    ) {
        val weatherRequest = NetworkServiceBuilder.buildService(WeatherApiEndpoints::class.java)
        val weatherCall = weatherRequest.getWeather(city)
        weatherCall.enqueue(object : retrofit2.Callback<WeatherModel> {
            override fun onResponse(
                call: Call<WeatherModel>,
                response: Response<WeatherModel>
            ) {
                if (response.isSuccessful) {
                    dataSourceCallBack.onWeatherDataLoadRemote(response.body()!!)
                }
            }

            override fun onFailure(call: Call<WeatherModel>, t: Throwable) {
            }
        })
    }
}