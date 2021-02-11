package com.example.kotlincountries4.viewmodel

import android.app.Application
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.kotlincountries4.model.Country
import com.example.kotlincountries4.services.CountryDatabase
import kotlinx.coroutines.launch

class CountryViewModel(application: Application) : BaseViewModel(application) {
    val countryLiveData = MutableLiveData<Country>()

    fun getDataFromRoom(uuid: Int) {

        launch {
            val dao = CountryDatabase(getApplication()).countryDAO()
            val country = dao.getCountry(uuid)
            countryLiveData.value = country
        }
    }
}