package com.example.cleanarchsample.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.core.domain.WeatherModel
import com.example.core.interactors.GetWeatherDataUseCase
import com.example.core.interactors.GetWeatherDataUseCaseImpl

/**
 * Weather View Model
 * @param weatherDataUseCaseImpl : di for GetWeatherDataUseCaseImpl
 */
class WeatherViewModel(private val weatherDataUseCaseImpl: GetWeatherDataUseCaseImpl): ViewModel() {

    val weatherLiveData = MutableLiveData<WeatherModel>()

    fun getWeatherData(){
        weatherDataUseCaseImpl.execute(object : GetWeatherDataUseCase.WeatherDataUseCaseCallback{
            override fun onDataLoaded(weather: WeatherModel?) {
                weatherLiveData.value = weather
            }
        })
    }
}