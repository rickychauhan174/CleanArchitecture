package com.example.cleanarchsample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.example.cleanarchsample.databinding.ActivityMainBinding
import com.example.cleanarchsample.viewmodel.WeatherViewModel

class MainActivity : AppCompatActivity() {
    private lateinit var weatherViewModel: WeatherViewModel
    private lateinit var mBinding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = ActivityMainBinding.inflate(layoutInflater)
        weatherViewModel = ViewModelProvider(this).get(WeatherViewModel::class.java)
        weatherViewModel.weatherLiveData.observe(this, androidx.lifecycle.Observer{
            mBinding.txtTemp.text = it.main.temp.toString()
        })
        weatherViewModel.getWeatherData()
        setContentView(mBinding.root)
    }
}