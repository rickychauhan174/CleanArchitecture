package com.example.cleanarchsample.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import com.example.core.data.WeatherRepository
import com.example.core.domain.WeatherModel
import com.example.core.interactors.GetWeatherDataUseCase
import com.example.core.interactors.GetWeatherDataUseCaseImpl

class WeatherViewModel: ViewModel() {

    fun getWeatherData(){
        GetWeatherDataUseCaseImpl().execute(WeatherRepository, object : GetWeatherDataUseCase.Callback{
            override fun onDataLoaded(weather: WeatherModel?) {
                Log.e("WEATHER DATA", weather!!.main.toString())
            }
        })
    }
}