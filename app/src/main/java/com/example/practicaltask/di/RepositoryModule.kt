package com.example.practicaltask.di

import com.example.practicaltask.repo.PostRepository
import com.example.practicaltask.repo.PostRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped

@Module
@InstallIn(ViewModelComponent::class)
abstract class RepositoryModule {

    @Binds
    @ViewModelScoped
    abstract fun providePostRepository(postRepositoryImpl: PostRepositoryImpl): PostRepository
}