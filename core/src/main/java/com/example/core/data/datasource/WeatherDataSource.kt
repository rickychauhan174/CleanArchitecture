package com.example.core.data.datasource

import com.example.core.domain.WeatherModel

interface WeatherDataSource {
    fun weatherRemoteData(
        city: String,
        dataSourceCallBack: WeatherDataSourceCallback
    )

    interface WeatherDataSourceCallback {
        fun onWeatherDataLoadRemote(weather: WeatherModel?)
    }
}