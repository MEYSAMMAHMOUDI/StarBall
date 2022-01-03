package com.example.starball.ui.main

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import com.example.starball.base.BaseActivity
import com.example.starball.ui.main.ui.BottomNavHost
import com.example.starball.ui.main.ui.BottomNavigationScreen
import com.example.starball.ui.main.ui.Screens
import com.example.starball.ui.main.ui.theme.BottomNavigationTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val listItems = listOf(
                Screens.News,
                Screens.Match,
                Screens.Table
            )
            val navController = rememberNavController()
            BottomNavigationTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background

                ) {
                    Scaffold(bottomBar = {
                        BottomNavigationScreen(navController = navController, items = listItems)
                    }) {
                        BottomNavHost(navHostController = navController)
                    }

                }
            }
        }
    }
}