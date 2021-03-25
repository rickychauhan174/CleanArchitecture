package com.example.cleanarchsample.di

import com.example.cleanarchsample.viewmodel.WeatherViewModel
import com.example.core.interactors.GetWeatherDataUseCaseImpl
import org.koin.android.viewmodel.ext.koin.viewModel
import org.koin.dsl.module.module

val weatherViewModelModule = module {
    viewModel {
        WeatherViewModel(get())
    }
}