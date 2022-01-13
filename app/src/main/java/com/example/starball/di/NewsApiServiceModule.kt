package com.example.starball.di

import com.example.starball.data.remote.RemoteApi
import com.example.starball.ui.news.NewsRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

/**
 * Created on : 1/5/2022
 * Author     : Meysam Mahmoudi
 */

@InstallIn(SingletonComponent::class)
@Module
object NewsApiServiceModule {
    @Singleton
    @Provides
    fun provideNewsRepository(
        api: RemoteApi
    ) = NewsRepository(api)

    @Singleton
    @Provides
    fun providesNewsApi(): RemoteApi {
        var okHttpClient: OkHttpClient? = null
        val httpLoggingInterceptor = HttpLoggingInterceptor()
        httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY)

        okHttpClient = OkHttpClient.Builder()
            .addInterceptor(httpLoggingInterceptor)
            .readTimeout(60, TimeUnit.SECONDS)
            .connectTimeout(60, TimeUnit.SECONDS)
            .build()

        return Retrofit.Builder()
            .baseUrl("https://newsapi.org/")
            .addConverterFactory(GsonConverterFactory.create())
            .client(okHttpClient)
            .build()
            .create(RemoteApi::class.java)
    }
}
