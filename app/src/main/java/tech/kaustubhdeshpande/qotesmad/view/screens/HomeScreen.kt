package tech.kaustubhdeshpande.qotesmad.view.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import tech.kaustubhdeshpande.qotesmad.data.Quote
import tech.kaustubhdeshpande.qotesmad.data.QuoteCategory
import tech.kaustubhdeshpande.qotesmad.ui.theme.Bold20
import tech.kaustubhdeshpande.qotesmad.ui.theme.Normal12
import tech.kaustubhdeshpande.qotesmad.ui.theme.QotesMADTheme
import tech.kaustubhdeshpande.qotesmad.view.components.CategoryCard
import tech.kaustubhdeshpande.qotesmad.view.components.QuoteBanner
import tech.kaustubhdeshpande.qotesmad.view.components.QuotesCard
import tech.kaustubhdeshpande.qotesmad.view.components.SectionHeader

@Composable
fun HomeScreen(modifier: Modifier = Modifier) {
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        item {
            Text(
                text = "Explore",
                fontWeight = FontWeight.Bold,
                style = MaterialTheme.typography.Bold20.copy(fontSize = 48.sp)
            )
            Text(
                text = "Awesome quotes from our community",
                fontWeight = FontWeight.ExtraLight,
                style = MaterialTheme.typography.Normal12.copy(color = Color.Black.copy(alpha = 0.8f)),
                fontSize = 12.sp,
            )
        }
        item {
            QuoteBanner(modifier = modifier)
        }
        item {
            SectionHeader(
                modifier = modifier,
                startText = "Latest Quotes",
                endText = "View All"
            )
            Spacer(modifier = Modifier.height(16.dp))

            val quotes = Quote.getQuotes()
            LazyRow(modifier = modifier, horizontalArrangement = Arrangement.spacedBy(8.dp)) {

                items(quotes) { q ->
                    QuotesCard(
                        modifier = modifier,
                        cardColor = q.category.bgColor,
                        quote = q.text,
                        quoteAuthor = q.author
                    )
                }
            }
        }

        item {
            SectionHeader(
                modifier = modifier,
                startText = "Categories",
                endText = "View All"
            )
            Spacer(modifier = Modifier.height(16.dp))
            // we are using .draw behind to avoid nesting in this case -> chat Akshay N
            LazyRow(modifier = modifier, horizontalArrangement = Arrangement.spacedBy(8.dp)) {

                // getting the enum class
                val categories = QuoteCategory.values()

                items(categories.toList()) { category ->
                    CategoryCard(
                        modifier = modifier,
                        categoryColor = category.bgColor,
                        category = category.displayName,
                        categoryIcon = category.icon
                    )
                }
            }
        }

        item {
            SectionHeader(
                modifier = modifier,
                startText = "Trending Quotes",
                endText = "View All"
            )
            Spacer(modifier = modifier.height(16.dp))

            val quotes = Quote.getQuotes()

            LazyRow(modifier = modifier, horizontalArrangement = Arrangement.spacedBy(8.dp)) {

                items(quotes) { q ->
                    QuotesCard(
                        modifier = modifier,
                        cardColor = q.category.bgColor,
                        quote = q.text,
                        quoteAuthor = q.author
                    )
                }
            }
        }
    }
}

@Preview(showSystemUi = false, showBackground = true)
@Preview(showSystemUi = true, showBackground = true)
@Composable
fun QuotesScreenPreview() {
    QotesMADTheme {
        HomeScreen()
    }
}