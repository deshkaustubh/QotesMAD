package tech.kaustubhdeshpande.qotesmad.view.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ScrollableTabRow
import androidx.compose.material3.Tab
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import tech.kaustubhdeshpande.qotesmad.data.Quote
import tech.kaustubhdeshpande.qotesmad.data.QuoteCategory
import tech.kaustubhdeshpande.qotesmad.ui.theme.QotesMADTheme
import tech.kaustubhdeshpande.qotesmad.view.components.ExploreQuotesCard

@Composable
fun ExploreScreen(modifier: Modifier = Modifier, initialCategoryName: String? = null) {
    // include a `null` entry as first tab to represent "All"
    val categories: List<QuoteCategory?> = listOf(null) + QuoteCategory.values().toList()

    val initialCategory = QuoteCategory.getCategory(initialCategoryName)
    val initialIndex = categories.indexOf(initialCategory).takeIf { it >= 0 } ?: 0

    // remember selected tab index (0 == All)
    var selectedIndex by rememberSaveable { mutableIntStateOf(initialIndex) }

    LazyColumn(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        item {
            Text(
                text = "Categories",
                fontWeight = FontWeight.Bold,
                style = MaterialTheme.typography.headlineLarge,
                fontSize = 32.sp
            )
        }

        item {
            ScrollableTabRow(
                selectedTabIndex = selectedIndex,
                edgePadding = 0.dp,
                indicator = {},
                divider = {},
                containerColor = MaterialTheme.colorScheme.surface
            ) {
                categories.forEachIndexed { index, cat ->
                    val isSelected = index == selectedIndex
                    val label = cat?.displayName ?: "All"
                    val bg = if (isSelected) cat?.bgColor ?: MaterialTheme.colorScheme.primary
                    else MaterialTheme.colorScheme.surfaceVariant

                    Tab(
                        selected = isSelected,
                        onClick = { selectedIndex = index },
                        modifier = Modifier
                            .padding(top = 8.dp, bottom = 16.dp, end = 8.dp)
                            .background(color = bg, shape = RoundedCornerShape(40)),
                        text = {
                            Text(
                                text = label,
                                color = if (isSelected) Color.White else Color.Black
                            )
                        }
                    )
                }
            }
        }

        // compute selected category using the same list (keeps indexes aligned)
        val selectedCategory: QuoteCategory? = categories.getOrNull(selectedIndex)
        val filteredQuotes =
            Quote.getQuotes().filter { selectedCategory == null || it.category == selectedCategory }

        items(filteredQuotes) { q ->
            ExploreQuotesCard(
                modifier = modifier.padding(vertical = 8.dp),
                cardColor = q.category.bgColor,
                quote = q.text,
                quoteAuthor = q.author,
                category = q.category.displayName,
            )
            Spacer(modifier = modifier.height(16.dp))
        }
    }
}

@Preview(showBackground = true)
@Preview(showSystemUi = true)
@Composable
private fun ExploreScreenPreview() {
    QotesMADTheme {
        ExploreScreen()
    }
}