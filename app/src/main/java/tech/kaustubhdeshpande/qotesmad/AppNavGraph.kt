package tech.kaustubhdeshpande.qotesmad

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import tech.kaustubhdeshpande.qotesmad.view.screens.ExploreScreen
import tech.kaustubhdeshpande.qotesmad.view.screens.HomeScreen
import tech.kaustubhdeshpande.qotesmad.view.screens.SavedScreen

@Composable
fun AppNavGraph(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = QuotesScreenRoutes.Home.route
    ) {
        composable(QuotesScreenRoutes.Home.route) {
            HomeScreen()
        }
        composable(QuotesScreenRoutes.Explore.route) {
            ExploreScreen()
        }
        composable(QuotesScreenRoutes.Saved.route) {
            SavedScreen()
        }
    }
}