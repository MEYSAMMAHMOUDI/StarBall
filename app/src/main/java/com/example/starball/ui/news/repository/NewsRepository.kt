package com.example.starball.ui.news.repository

import com.example.starball.data.models.news.News
import com.example.starball.data.remote.RemoteApi
import com.example.starball.ui.news.view.Result
import dagger.hilt.android.scopes.ActivityScoped
import javax.inject.Inject
/**
 * Created on : 1/15/2022
 * Author     : Meysam Mahmoudi
 */
@ActivityScoped
class NewsRepository
@Inject constructor(private val apiService: RemoteApi){

    suspend fun getNewsData(): Result<News> {
        val response = try {
            apiService.getListNews()
        } catch (e: Exception) {
            return Result.Error("An unknown error occured: ${e.localizedMessage}")
        }

        return Result.Success(response)
    }

}