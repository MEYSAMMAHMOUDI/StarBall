package com.example.starball.ui.news.view
/**
 * Created on : 1/15/2022
 * Author     : Meysam Mahmoudi
 */
sealed class Resource<T>(val data: T? = null, val message: String? = null) {
    class Success<T>(data: T): Resource<T>(data)
    class Error<T>(message: String, data: T? = null): Resource<T>(data, message)
    class Loading<T>(data: T? = null): Resource<T>(data)
}
