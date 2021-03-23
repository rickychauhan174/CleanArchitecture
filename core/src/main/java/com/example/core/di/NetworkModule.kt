package com.example.core.di

import com.example.core.data.datasource.WeatherDataSourceImpl
import com.example.core.data.network.NetworkServiceBuilder
import com.example.core.data.repository.WeatherRepository
import org.koin.dsl.module.module

val networkModule = module {
    single { NetworkServiceBuilder() }
    single { WeatherDataSourceImpl(get()) }
    single { WeatherRepository(get()) }
}