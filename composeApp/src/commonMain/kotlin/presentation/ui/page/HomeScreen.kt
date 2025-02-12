package presentation.ui.page

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.unit.dp
import domain.model.Set
import navigation.NavigationManager
import org.koin.compose.viewmodel.koinViewModel
import org.koin.core.annotation.KoinExperimentalAPI
import presentation.viewModel.SetsViewModel


@OptIn(KoinExperimentalAPI::class)
@Composable
fun HomeScreen() {
    val viewModel = koinViewModel<SetsViewModel>()
    val sets by viewModel.sets.collectAsState()

    val groupedSets = sets.groupBy { it.category }

    Column(modifier = Modifier) {
        Text("Coleções")

        if (sets.isEmpty()) {
            CircularProgressIndicator()
        }

        groupedSets.forEach { (category, setsInCategory) ->
            CategorySection(
                categoryName = category, sets = setsInCategory
            )
            HorizontalDivider(thickness = 1.dp, color = Color.Black)
        }
    }
}

@Composable
fun CategorySection(categoryName: String, sets: List<Set>) {
    var expanded by remember { mutableStateOf(false) }

    Card(
        shape = RectangleShape,
        elevation = CardDefaults.cardElevation(0.dp)
    ) {
        Column {
            Row(modifier = Modifier.fillMaxWidth()) {
                Text(
                    text = categoryName,
                    modifier = Modifier.weight(1f)
                        .align(Alignment.CenterVertically)
                        .padding(horizontal = 8.dp),
                    )
                IconButton(onClick = { expanded = !expanded }) {
                    Icon(
                        imageVector = if (expanded) Icons.Filled.KeyboardArrowUp else Icons.Filled.KeyboardArrowDown,
                        contentDescription = "Expandir/Colapsar"
                    )
                }
            }

            if (expanded) {

                LazyVerticalGrid(
                    columns = GridCells.Fixed(3),
                    contentPadding = PaddingValues(8.dp),
                    verticalArrangement = Arrangement.spacedBy(8.dp),
                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    items(sets.sortedByDescending { it.releaseDate }) { set ->
                        Button(
                            onClick = {
                                NavigationManager.navigateToSetDetail(set.id.toString())
                            }, modifier = Modifier.fillMaxWidth()
                        ) {
                            Text(set.name)
                        }

                    }
                }
            }
        }
    }
}
