package com.example.cleanarchsample.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.example.cleanarchsample.databinding.ActivityMainBinding
import com.example.cleanarchsample.viewmodel.WeatherViewModel
import org.koin.android.ext.android.get
import org.koin.android.ext.android.inject
import org.koin.android.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {
    private val weatherViewModel: WeatherViewModel by inject()
    private lateinit var mBinding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = ActivityMainBinding.inflate(layoutInflater)
        observeWeatherData()
        setContentView(mBinding.root)
    }

    private fun observeWeatherData(){
        weatherViewModel.weatherLiveData.observe(this, androidx.lifecycle.Observer{
            mBinding.txtTemp.text = it.main.temp.toString()
        })
        weatherViewModel.getWeatherData()
    }
}