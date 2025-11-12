package tech.kaustubhdeshpande.qotesmad.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import tech.kaustubhdeshpande.qotesmad.ui.theme.Bold16
import tech.kaustubhdeshpande.qotesmad.ui.theme.Bold20
import tech.kaustubhdeshpande.qotesmad.ui.theme.Medium14
import tech.kaustubhdeshpande.qotesmad.ui.theme.Medium16
import tech.kaustubhdeshpande.qotesmad.ui.theme.Normal12
import tech.kaustubhdeshpande.qotesmad.ui.theme.Normal14
import tech.kaustubhdeshpande.qotesmad.ui.theme.QotesMADTheme
import tech.kaustubhdeshpande.qotesmad.view.components.SectionHeader

@Composable
fun QuotesScreen(modifier: Modifier = Modifier) {
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
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(164.dp)
                    .background(color = Color.LightGray, shape = RoundedCornerShape(8.dp)),
                contentAlignment = Alignment.Center
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 16.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        modifier = Modifier
                            .wrapContentHeight(),
                        text = "BELIEVE IN",
                        textAlign = TextAlign.Center,
                        softWrap = true,
                        style = MaterialTheme.typography.Normal12.copy(fontSize = 36.sp),
                        letterSpacing = 4.sp
                    )
                    Text(
                        modifier = Modifier
                            .wrapContentHeight(),
                        text = "YOURSELF",
                        textAlign = TextAlign.Center,
                        softWrap = true,
                        style = MaterialTheme.typography.Normal12.copy(fontSize = 36.sp),
                        letterSpacing = 4.sp
                    )
                }
            }
        }
        item {
            SectionHeader(
                modifier = modifier,
                startText = "Latest Quotes",
                endText = "View All"
            )
            Spacer(modifier = Modifier.height(16.dp))
            LazyRow {
                item {
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
                                            Color.Magenta,
                                            Color.Magenta.copy(0.8f),
                                            Color.Magenta.copy(0.6f)
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
                                text = "With great powers come great responsibilities",
                                style = MaterialTheme.typography.Bold16.copy(
                                    lineHeight = 16.sp,
                                    color = Color.White
                                ),
                                textAlign = TextAlign.Left
                            )
                            Spacer(modifier = Modifier.height(8.dp))
                            Text(
                                text = "-  "+"Uncle Ben",
                                style = MaterialTheme.typography.Normal14.copy(
                                    fontStyle = FontStyle.Italic,
                                    lineHeight = 16.sp,
                                    color = Color.White
                                )
                            )
                        }
                    }
                }
            }
        }
    }
}

@Preview(showSystemUi = false, showBackground = true)
@Preview(showSystemUi = true, showBackground = true)
@Composable
private fun QuotesScreenPreview() {
    QotesMADTheme {
        QuotesScreen()
    }
}