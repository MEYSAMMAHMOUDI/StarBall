package com.example.starball.view.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.starball.R
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}