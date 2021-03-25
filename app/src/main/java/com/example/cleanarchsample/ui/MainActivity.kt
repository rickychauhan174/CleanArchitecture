package com.example.cleanarchsample.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.cleanarchsample.databinding.ActivityMainBinding
import com.example.cleanarchsample.viewmodel.WeatherViewModel
import org.koin.android.ext.android.inject

class MainActivity : AppCompatActivity() {
    private val weatherViewModel: WeatherViewModel by inject()
    private lateinit var mBinding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = ActivityMainBinding.inflate(layoutInflater)
        observeWeatherData()
        setContentView(mBinding.root)
    }

    /**
     *  Update weather data on text view as it gets.
     */
    private fun observeWeatherData(){
        weatherViewModel.weatherLiveData.observe(this, {
            mBinding.txtTemp.text = it.main.temp.toString()
        })
        weatherViewModel.getWeatherData()
    }
}