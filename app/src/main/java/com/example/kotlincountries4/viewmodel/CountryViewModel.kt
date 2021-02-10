package com.example.kotlincountries4.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.kotlincountries4.model.Country

class CountryViewModel : ViewModel() {
    val countryLiveData = MutableLiveData<Country>()

    fun getDataFromRoom() {
        val country = Country("Turkey", "Ankara", "Asia", "TRY", "", "Turkish")

        countryLiveData.value = country
    }
}