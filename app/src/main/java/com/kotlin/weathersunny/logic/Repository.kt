package com.kotlin.weathersunny.logic

import androidx.lifecycle.liveData
import com.kotlin.weathersunny.logic.model.Place
import com.kotlin.weathersunny.logic.network.SunnyWeatherNetWork
import kotlinx.coroutines.Dispatchers


object Repository {
    fun searchPlaces(query:String)= liveData(Dispatchers.IO){
        val result = try {
            val placeResponse =SunnyWeatherNetWork.searchPlaces(query)
            if (placeResponse.status=="ok") {
                val places =placeResponse.places
                Result.success(places)
            }else{
                Result.failure(RuntimeException("response status is ${placeResponse.status}"))
            }
        }catch (e:Exception){
            Result.failure<List<Place>>(e)
        }
        emit(result)
    }
}