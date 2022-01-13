package com.example.starball

import android.app.Application
import dagger.hilt.android.HiltAndroidApp
/**
 * Created on : 1/5/2022
 * Author     : Meysam Mahmoudi
 */
@HiltAndroidApp
class StarBallApp :Application()
{
    override fun onCreate() {
        super.onCreate()
    }
}