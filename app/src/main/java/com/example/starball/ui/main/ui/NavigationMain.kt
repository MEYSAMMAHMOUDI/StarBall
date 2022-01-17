package com.example.starball.ui.main.ui

import androidx.annotation.DrawableRes
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.navigation.NavController
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.starball.R
import com.example.starball.ui.news.view.NewsList

/**
 * Created on : 1/5/2022
 * Author     : Meysam Mahmoudi
 */
sealed class Screens(
    val route: String,
    @DrawableRes val icon: Int
) {
    object News : Screens(
        route = "News",
        icon = R.drawable.ic_news
    )

    object Match : Screens(
        route = "Match",
        icon = R.drawable.ic_match
    )

    object Table : Screens(
        route = "Table",
        icon = R.drawable.ic_table
    )


}


@Composable
fun BottomNavHost(navHostController: NavHostController) {


    NavHost(navController = navHostController, startDestination = "News")
    {
        composable("News") {
            NewsList()
        }
        composable(route = "Match") { Match() }
        composable(route = "Table") { Table() }
    }
}

@Composable
fun BottomNavigationScreen(navController: NavController, items: List<Screens>) {
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentDestination = navBackStackEntry?.destination

    BottomNavigation {
        items.forEach { screens ->
            BottomNavigationItem(
                selected = currentDestination?.route == screens.route,
                onClick = {
                    navController.navigate(screens.route)
                    {
                        launchSingleTop = true
                        popUpTo(navController.graph.findStartDestination().id)
                        {
                            saveState = true
                        }
                        restoreState = true
                    }
                },
                icon = {
                    Icon(
                        painter = painterResource(id = screens.icon),
                        contentDescription = null
                    )
                },
                label = { Text(text = screens.route) },
                alwaysShowLabel = false,
                selectedContentColor = colorResource(id = R.color.bottomNavigation)
            )

        }
    }
}



