package com.example.starball.data.models.news

import android.os.Parcelable
import kotlinx.parcelize.Parcelize
/**
 * Created on : 1/5/2022
 * Author     : Meysam Mahmoudi
 */

@Parcelize
data class Article(
    val title: String?,
    val description: String?,
    val urlToImage: String?,
    val content: String?,
    val url: String?
) : Parcelable