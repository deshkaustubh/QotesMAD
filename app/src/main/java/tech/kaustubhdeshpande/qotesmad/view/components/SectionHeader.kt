package tech.kaustubhdeshpande.qotesmad.view.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import tech.kaustubhdeshpande.qotesmad.ui.theme.Bold16
import tech.kaustubhdeshpande.qotesmad.ui.theme.Medium16
import tech.kaustubhdeshpande.qotesmad.ui.theme.Normal12

@Composable
fun SectionHeader(modifier: Modifier = Modifier, startText: String, endText: String) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(
            text = startText,
            color = Color.Black,
            fontWeight = FontWeight.SemiBold,
            style = MaterialTheme.typography.Medium16
        )
        Text(
            text = endText,
            color = Color.Blue,
            fontWeight = FontWeight.Bold,
            style = MaterialTheme.typography.Normal12
        )
    }
}