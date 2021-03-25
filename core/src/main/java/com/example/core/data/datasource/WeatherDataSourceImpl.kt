package com.example.core.data.datasource

import com.example.core.data.network.NetworkServiceBuilder
import com.example.core.domain.WeatherModel
import retrofit2.Call
import retrofit2.Response

/**
 *  Implementation of WeatherDataSource
 *  @param networkServiceBuilder : di for NetworkServiceBuilder
 */
class WeatherDataSourceImpl(private val networkServiceBuilder: NetworkServiceBuilder) :
    WeatherDataSource {
    override fun weatherRemoteData(
        city: String,
        dataSourceCallBack: WeatherDataSource.WeatherDataSourceCallback
    ) {
        networkServiceBuilder.createWeatherApiService().getWeather(city)
            .enqueue(object : retrofit2.Callback<WeatherModel> {
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