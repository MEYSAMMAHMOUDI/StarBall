package com.example.starball.ui.news

import com.example.starball.data.models.news.Article
import com.example.starball.data.models.news.News
import com.example.starball.data.remote.RemoteApi
import com.example.starball.ui.news.view.Resource
import dagger.hilt.android.scopes.ActivityScoped
import javax.inject.Inject
@ActivityScoped
class NewsRepository
@Inject constructor(private val apiService: RemoteApi){

    suspend fun getNewsData(): Resource<News> {
        val response = try {
            apiService.getListNews()
        } catch (e: Exception) {
            return Resource.Error("An unknown error occured: ${e.localizedMessage}")
        }

        return Resource.Success(response)
    }

}