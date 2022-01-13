package com.example.starball.data.remote

import com.example.starball.data.models.news.Article
import com.example.starball.data.models.news.News
import com.example.starball.ui.news.view.Resource
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query
import javax.inject.Singleton

/**
 * Created on : 1/4/2022
 * Author     : Hamed Ghaderian
 */
@Singleton
interface RemoteApi {
    @GET("v2/top-headlines?country=gb&category=sports&apiKey=c06101d021a64f8a806c900ed3c05aa0")
    suspend fun getListNews():News

}