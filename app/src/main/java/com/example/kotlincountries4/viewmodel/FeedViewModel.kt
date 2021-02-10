package com.example.kotlincountries4.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.kotlincountries4.model.Country

class FeedViewModel : ViewModel() {
    val countries = MutableLiveData<List<Country>>()
    val countryError = MutableLiveData<Boolean>()
    val countryLoading = MutableLiveData<Boolean>()

    fun refreshData() {
        val country = Country("Turkey", "Ankara", "Asia", "TRY", "", "Turkish")
        val country2 = Country("Norway", "Oslo", "Europe", "NOK", "", "Norwegian")
        val country3 = Country("Germany", "Berlin", "Europe", "EUR", "", "German")

        val countryList = arrayListOf<Country>(country, country2, country3)

        countries.value = countryList
        countryError.value = false
        countryLoading.value = false
    }
}