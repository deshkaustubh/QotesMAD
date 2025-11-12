package tech.kaustubhdeshpande.qotesmad

sealed class QuotesScreenRoutes(val route: String) {
    data object Home : QuotesScreenRoutes(route = "home")
    data object Explore: QuotesScreenRoutes(route = "explore")
    data object Saved: QuotesScreenRoutes(route = "saved")
}