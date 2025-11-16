package tech.kaustubhdeshpande.qotesmad

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import tech.kaustubhdeshpande.qotesmad.view.screens.ExploreScreen
import tech.kaustubhdeshpande.qotesmad.view.screens.HomeScreen
import tech.kaustubhdeshpande.qotesmad.view.screens.SavedScreen
import java.net.URLEncoder
import java.nio.charset.StandardCharsets

@Composable
fun AppNavGraph(navController: NavHostController, modifier: Modifier = Modifier) {
    val viewModel: FavouriteViewModel = viewModel()
    NavHost(
        navController = navController,
        startDestination = QuotesScreenRoutes.Home.route,
        modifier = modifier
    ) {
        composable(QuotesScreenRoutes.Home.route) {
            HomeScreen(
                onNavigateToExplore = { category ->
                    if (category.isNullOrBlank()) {
                        navController.navigate(QuotesScreenRoutes.Explore.route)
                    } else {
                        val encoded = URLEncoder.encode(category, StandardCharsets.UTF_8.toString())
                        navController.navigate(QuotesScreenRoutes.Explore.route + "?category=$encoded")
                    }
                }
            )
        }

        composable(
            route = "${QuotesScreenRoutes.Explore.route}?category={category}",
            arguments = listOf(
                navArgument("category") {
                    type = NavType.StringType
                    nullable = true
                    defaultValue = null
                }
            )
        ) { backStackEntry ->
            val categoryName = backStackEntry.arguments?.getString("category")
            ExploreScreen(
                initialCategoryName = categoryName,
                favViewModel = viewModel
            )
        }

        composable(QuotesScreenRoutes.Saved.route) {
            SavedScreen(
                favViewModel = viewModel
            )
        }
    }
}