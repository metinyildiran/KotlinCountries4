package com.example.kotlincountries4.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.kotlincountries4.R

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        title = "Kotlin Countries"
    }
}