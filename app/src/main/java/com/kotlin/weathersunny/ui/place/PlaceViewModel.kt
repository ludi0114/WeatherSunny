package com.kotlin.weathersunny.ui.place

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import com.kotlin.weathersunny.logic.Repository
import com.kotlin.weathersunny.logic.model.Place

class PlaceViewModel: ViewModel() {
    fun savePlace(place: Place) = Repository.savePlace(place)
    fun getSavePlace()=Repository.getSavePlace()
    fun isPlaceSaved() =Repository.isPlaceSaved()

    private val searchLiveData =MutableLiveData<String>()
    val placeList = ArrayList<Place>()
    val placeLiveData = Transformations.switchMap(searchLiveData){ query ->
        Repository.searchPlaces(query)
    }
    fun searchPlaces(query:String){
        searchLiveData.value=query
    }
}