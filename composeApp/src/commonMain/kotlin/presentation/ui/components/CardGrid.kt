package presentation.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import domain.model.Card
import io.kamel.image.KamelImage
import io.kamel.image.asyncPainterResource

@Composable
fun CardGrid(cards: List<Card>) {
    LazyVerticalGrid(
        columns = GridCells.Fixed(3),
        contentPadding = PaddingValues(8.dp),
        verticalArrangement = Arrangement.spacedBy(5.dp),
        horizontalArrangement = Arrangement.spacedBy(5.dp)
    ) {
        items(cards) { card ->

            Column() {
                KamelImage(
                    { asyncPainterResource(data = card.imageUrl) },
                    contentDescription = "TCG Card",
                    modifier = Modifier.fillMaxSize()
                )
                Text(text = "#${card.number} ${card.name}")
            }
        }
    }
}
