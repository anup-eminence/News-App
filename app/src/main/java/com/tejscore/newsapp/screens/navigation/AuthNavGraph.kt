package com.tejscore.newsapp.screens.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.tejscore.newsapp.screens.SplashScreen


fun NavGraphBuilder.authNavGraph(navHostController: NavHostController){
  navigation(
      route = Graph.AUTHENTICATION,
      startDestination = AuthScreen.Splash.route
  ) {
     composable(AuthScreen.Splash.route){
        SplashScreen(navigate = {
            navHostController.popBackStack()
            navHostController.navigate(Graph.HOME)
        })
     }
  }
}

sealed class AuthScreen(val route: String) {
    data object Splash : AuthScreen(route = "splash")
    data object SignUp : AuthScreen(route = "SIGN_UP")
    data object Forgot : AuthScreen(route = "FORGOT")
}