package com.example.kotlincountries4.services

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.kotlincountries4.model.Country

@Dao
interface CountryDAO {

    //DAO -> Data Access Object

    //suspend -> coroutines içinde çalışır, durdurulup devam ettirilebilir
    //vararg -> multiple country objects
    // List<Long> -> primary keys döndürecek

    @Insert
    suspend fun insertAll(vararg countries: Country): List<Long>

    @Query("SELECT * FROM country")
    suspend fun getAllCountries(): List<Country>

    @Query("SELECT * FROM country WHERE uuid = :countryId")
    suspend fun getCountry(countryId: Int): Country

    @Query("DELETE FROM country")
    suspend fun deleteAllCountries()

}