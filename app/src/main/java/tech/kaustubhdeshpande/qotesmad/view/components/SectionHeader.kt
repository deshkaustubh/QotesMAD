package tech.kaustubhdeshpande.qotesmad.view.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import tech.kaustubhdeshpande.qotesmad.ui.theme.Medium16
import tech.kaustubhdeshpande.qotesmad.ui.theme.Normal12

@Composable
fun SectionHeader(
    modifier: Modifier = Modifier,
    startText: String,
    endText: String,
    onNavigate: () -> Unit = {}
) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(
            text = startText,
            color = MaterialTheme.colorScheme.primary,
            fontWeight = FontWeight.SemiBold,
            style = MaterialTheme.typography.Medium16
        )
        Text(
            text = endText,
            color = MaterialTheme.colorScheme.onBackground,
            fontWeight = FontWeight.Bold,
            style = MaterialTheme.typography.Normal12,
            modifier = modifier.clickable(onClick = onNavigate)
        )
    }
}