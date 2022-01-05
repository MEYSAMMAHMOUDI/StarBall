package com.example.starball.di

import com.example.starball.data.RemoteDataSource
import com.example.starball.ui.table.data.source.TableDataSource
import com.example.starball.ui.table.data.source.remote.TableRemoteDataSource
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

/**
 * Created on : 1/4/2022
 * Author     : Hamed Ghaderian
 */
@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {
    @Provides
    @Singleton
    @RemoteDataSource
    fun provideTableDefaultRepository(): TableDataSource {
        return TableRemoteDataSource()
    }
}