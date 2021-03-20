package com.example.cleanarchsample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.example.cleanarchsample.viewmodel.WeatherViewModel

class MainActivity : AppCompatActivity() {
    private lateinit var viewModel: WeatherViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        viewModel = ViewModelProvider(this).get(WeatherViewModel::class.java)
        viewModel.getWeatherData()
    }
}