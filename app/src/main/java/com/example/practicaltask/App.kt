package com.example.practicaltask

import android.app.Application
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class App: Application() {

    companion object {
        val gson: Gson by lazy { GsonBuilder().create() }
    }
}