package com.example.cleanarchsample

import android.app.Application
import com.example.cleanarchsample.di.viewModelModule
import com.example.core.di.networkModule
import org.koin.android.ext.android.startKoin

class WeatherApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin(this, listOf(networkModule, viewModelModule))
    }
}