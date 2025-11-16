package tech.kaustubhdeshpande.qotesmad.view.components

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import tech.kaustubhdeshpande.qotesmad.QuotesScreenRoutes

@Composable
fun BottomNavigationBar(
    modifier: Modifier = Modifier,
    currentRoute: String?,
    onNavigate: (String) -> Unit
) {
    NavigationBar(modifier = modifier) {
        NavigationBarItem(
            selected = currentRoute == QuotesScreenRoutes.Home.route,
            onClick = { onNavigate(QuotesScreenRoutes.Home.route) },
            icon = { Icon(Icons.Filled.Home, contentDescription = "Home") },
            label = { Text("Home") }
        )

        NavigationBarItem(
            selected = currentRoute?.startsWith(QuotesScreenRoutes.Explore.route) == true,
            onClick = { onNavigate(QuotesScreenRoutes.Explore.route) },
            icon = { Icon(Icons.Filled.Search, contentDescription = "Explore") },
            label = { Text("Explore") }
        )

        NavigationBarItem(
            selected = currentRoute == QuotesScreenRoutes.Saved.route,
            onClick = { onNavigate(QuotesScreenRoutes.Saved.route) },
            icon = { Icon(Icons.Filled.Favorite, contentDescription = "Saved") },
            label = { Text("Saved") }
        )
    }
}
