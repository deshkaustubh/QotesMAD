// kotlin
package tech.kaustubhdeshpande.qotesmad.view.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.Share
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import tech.kaustubhdeshpande.qotesmad.FavouriteViewModel
import tech.kaustubhdeshpande.qotesmad.data.Quote
import tech.kaustubhdeshpande.qotesmad.ui.theme.Medium14
import tech.kaustubhdeshpande.qotesmad.ui.theme.Medium16
import tech.kaustubhdeshpande.qotesmad.ui.theme.Normal12

@Composable
fun ExploreQuotesCard(
    modifier: Modifier = Modifier,
    cardColor: Color,
    quote: Quote,
    quoteAuthor: String,
    category: String,
    favViewModel: FavouriteViewModel
) {
    val isFavorite: Boolean = favViewModel.favorites.any { it.id == quote.id }

    Card(
        modifier = modifier
            .wrapContentHeight()
            .fillMaxWidth()
            .border(1.dp, color = cardColor.copy(0.2f), shape = RoundedCornerShape(16.dp))
            .clip(shape = RoundedCornerShape(16.dp)),
        elevation = CardDefaults.cardElevation(0.dp)
    ) {
        Column(
            modifier = Modifier
                .background(color = MaterialTheme.colorScheme.surface)
                .padding(16.dp)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Row(
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Surface(
                        modifier = Modifier
                            .size(40.dp)
                            .clip(CircleShape),
                        color = cardColor.copy(0.1f)
                    ) {
                        Icon(
                            imageVector = Icons.Outlined.Person,
                            contentDescription = null,
                            tint = cardColor,
                            modifier = Modifier.padding(6.dp)
                        )
                    }

                    Spacer(modifier = Modifier.width(8.dp))

                    Column {
                        Text(
                            text = quoteAuthor,
                            style = MaterialTheme.typography.Medium14.copy(lineHeight = 16.sp)
                        )
                        Text(
                            text = "@ $category",
                            style = MaterialTheme.typography.Normal12.copy(
                                lineHeight = 16.sp,
                                color = Color.Gray
                            )
                        )
                    }
                }

                Row(verticalAlignment = Alignment.CenterVertically) {
                    Icon(
                        imageVector = Icons.Filled.Share,
                        contentDescription = null,
                        modifier = Modifier.size(16.dp)
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                    IconButton(
                        onClick = {
                            if (isFavorite) {
                                favViewModel.removeFavorite(quote)
                            } else {
                                favViewModel.addFavorite(quote)
                            }
                        }
                    ) {
                        Icon(
                            imageVector = if (isFavorite) Icons.Filled.Favorite else Icons.Filled.FavoriteBorder,
                            contentDescription = if (isFavorite) "Unfavorite" else "Favorite",
                            tint = if (isFavorite) Color.Red else MaterialTheme.colorScheme.onSurface,
                            modifier = Modifier.size(16.dp)
                        )
                    }
                }
            }
            Spacer(modifier = Modifier.height(16.dp))
            Text(
                text = quote.text,
                style = MaterialTheme.typography.Medium16.copy(lineHeight = 24.sp),
                textAlign = TextAlign.Left
            )
        }
    }
}
