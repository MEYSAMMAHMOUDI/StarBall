package com.example.starball.ui.news

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.starball.data.models.news.News
import com.example.starball.ui.news.repository.NewsRepository
import com.example.starball.ui.news.view.Result
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class NewsViewModel@Inject constructor(
    private val newsRepository: NewsRepository
): ViewModel() {

    var isLoading = mutableStateOf(false)
    private var _getUserData: MutableLiveData<News> = MutableLiveData<News>()
    var getNewsData: LiveData<News> = _getUserData

    suspend fun getNewsData(): Result<News> {
        val result = newsRepository.getNewsData()
        if (result is Result.Success) {
            isLoading.value = true
            _getUserData.value = result.data!!
        }

        return result
    }
}