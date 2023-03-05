package com.example.practicaltask.di

import android.content.Context
import com.example.practicaltask.utils.volley.VolleySingleton
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Provides
    @Singleton
    fun providesVolleySingleton(@ApplicationContext context: Context): VolleySingleton = VolleySingleton.getInstance(context)
}