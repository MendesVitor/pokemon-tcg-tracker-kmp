package presentation.ui.components

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppBar(onHomeClick: () -> Unit) {
    TopAppBar(
        title = { Text("Pokémon TCG Tracker") },
        navigationIcon = {
            IconButton(onClick = { onHomeClick() }) {
                Icon(
                    imageVector = Icons.Filled.Home,
                    contentDescription = "Navegar para Home"
                )
            }
        }
    )
}
