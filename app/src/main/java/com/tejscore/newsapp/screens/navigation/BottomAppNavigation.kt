package com.tejscore.newsapp.screens.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.tejscore.newsapp.screens.BookMarkedScreen
import com.tejscore.newsapp.screens.HomeContent
import com.tejscore.newsapp.screens.HomeScreen
import com.tejscore.newsapp.screens.SearchScreen
import com.tejscore.newsapp.screens.SettingScreen
import com.tejscore.newsapp.screens.SplashScreen

@Composable
fun BottomAppNavigation(
    modifier: Modifier = Modifier,
    navController: NavHostController,
    startDestini: String = NavigationItem.Home.rout
) {

    NavHost(
        navController = navController,
        modifier = modifier,
        route = Graph.HOME,
        startDestination = startDestini
    ) {

        composable(NavigationItem.Home.rout){
            HomeContent()
        }

        composable(NavigationItem.SEARCH.rout){
            SearchScreen()
        }

        composable(NavigationItem.SETTINGS.rout){
            SettingScreen()
        }

        composable(NavigationItem.BOOKMARKED.rout){
            BookMarkedScreen()
        }
    }

}