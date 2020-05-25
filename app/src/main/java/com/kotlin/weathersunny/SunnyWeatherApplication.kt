package com.kotlin.weathersunny

import android.annotation.SuppressLint
import android.app.Application
import android.content.Context

class SunnyWeatherApplication : Application() {
    companion object{
        @SuppressLint("StaticFieldLeak")
        lateinit var context: Context
        const val TOKEN = "mOffkg8XJZEEutJQ"//彩云token
    }
    override fun onCreate() {
        super.onCreate()
        context=applicationContext
    }
}