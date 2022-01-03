package com.example.starball.ui.main.ui

import androidx.annotation.DrawableRes
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.Text
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
    NavHost(navController = navHostController, startDestination = Screens.News.route)
    {
        composable(route = Screens.News.route) { News() }

        composable(route = Screens.Match.route) { Match() }

        composable(route = Screens.Table.route) { Table() }


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
                    Icon(painter = painterResource(id = screens.icon), contentDescription = null)
                },
                label = { Text(text = screens.route) },
                alwaysShowLabel = false,
                selectedContentColor = colorResource(id = R.color.bottomNavigation)
            )

        }
    }
}


