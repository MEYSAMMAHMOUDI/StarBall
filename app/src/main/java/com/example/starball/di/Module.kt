package com.example.starball.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.Dispatchers
import javax.inject.Singleton

@Module
@InstallIn(
    SingletonComponent::class,
    RepositoryModule::class
)
object Module{

    @Singleton
    @Provides
    fun provideIoDispatcher() = Dispatchers.IO
}