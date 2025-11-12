package tech.kaustubhdeshpande.qotesmad.view.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.Share
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import tech.kaustubhdeshpande.qotesmad.ui.theme.Bold16
import tech.kaustubhdeshpande.qotesmad.ui.theme.Normal14

@Composable
fun QuotesCard(
    modifier: Modifier = Modifier,
    cardColor: Color,
    quote: String,
    quoteAuthor: String
) {
    Card(
        modifier = Modifier
            .height(240.dp)
            .width(200.dp)
            .clip(shape = RoundedCornerShape(16.dp))
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(
                    brush = Brush.linearGradient(
                        colors = listOf(
                            cardColor,
                            cardColor.copy(0.8f),
                            cardColor.copy(0.6f)
                        )
                    )
                )
                .padding(16.dp)
        ) {
            Row {
                Surface(
                    modifier = Modifier
                        .size(32.dp)
                        .clip(CircleShape),
                    color = Color.White.copy(0.2f)
                ) {}

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.End
                ) {
                    Icon(
                        imageVector = Icons.Filled.Share,
                        contentDescription = null,
                        tint = Color.White
                    )
                    Spacer(modifier = Modifier.padding(horizontal = 8.dp))
                    Icon(
                        imageVector = Icons.Filled.FavoriteBorder,
                        contentDescription = null,
                        tint = Color.White
                    )
                }
            }
            Spacer(modifier = Modifier.weight(1f))
            Text(
                text = quote,
                style = MaterialTheme.typography.Bold16.copy(
                    lineHeight = 16.sp,
                    color = Color.White
                ),
                textAlign = TextAlign.Left
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = "-  $quoteAuthor",
                style = MaterialTheme.typography.Normal14.copy(
                    fontStyle = FontStyle.Italic,
                    lineHeight = 16.sp,
                    color = Color.White
                )
            )
        }
    }
}