package com.example.core.di

import com.example.core.data.datasource.WeatherDataSourceImpl
import com.example.core.data.network.NetworkServiceBuilder
import com.example.core.data.repository.WeatherRepository
import com.example.core.interactors.GetWeatherDataUseCaseImpl
import org.koin.dsl.module.module

/**
 *  Create module and make all required dependencies singleton(recommended).
 */
val networkModule = module {
    single { NetworkServiceBuilder() }
    single { WeatherDataSourceImpl(get()) }
    single { WeatherRepository(get()) }
    single { GetWeatherDataUseCaseImpl(get()) }
}