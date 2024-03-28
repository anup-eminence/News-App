    package com.tejscore.newsapp.screens.navigation

    import androidx.compose.runtime.Composable
    import androidx.navigation.NavHostController
    import androidx.navigation.compose.NavHost
    import androidx.navigation.compose.composable
    import com.tejscore.newsapp.screens.HomeScreen


    @Composable
    fun RootNavGraph(navHostController: NavHostController) {

        NavHost(
            navController = navHostController,
            route = Graph.ROOT,
            startDestination = Graph.AUTHENTICATION
        ) {
            authNavGraph(navHostController = navHostController)
            composable(Graph.HOME){
                HomeScreen(appBarTitle = "News")
            }
        }

    }

    object Graph {
        const val ROOT = "root_graph"
        const val AUTHENTICATION = "auth_graph"
        const val HOME = "home_graph"
        const val DETAILS = "details_graph"
    }