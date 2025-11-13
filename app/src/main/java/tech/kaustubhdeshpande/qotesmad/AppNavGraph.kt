package tech.kaustubhdeshpande.qotesmad

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import tech.kaustubhdeshpande.qotesmad.view.screens.HomeScreen

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
            HomeScreen()
        }
        composable(QuotesScreenRoutes.Saved.route) {
            HomeScreen()
        }
    }
}