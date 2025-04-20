package presentation.ui.components

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.List
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.vector.ImageVector
import navigation.NavigationManager
import navigation.Screen


data class NavItem(
    val icon: ImageVector,
    val label: String,
    val onClick: () -> Unit
)

@Composable
fun BottomBar(
    selectedItem: NavItem?,
    onItemSelected: (NavItem) -> Unit
) {
    val items = listOf(
        NavItem(
            icon = Icons.AutoMirrored.Filled.List,
            label = "Coleções",
            onClick = { NavigationManager.navigate(Screen.Sets.route) }
        ),
        NavItem(
            icon = Icons.Default.Search,
            label = "Buscar",
            onClick = { NavigationManager.navigate(Screen.Search.route) }
        ),
        NavItem(
            icon = Icons.Default.LocationOn,
            label = "Álbuns",
            onClick = { NavigationManager.navigate(Screen.Collection.route) }
        ),
    )

    BottomAppBar {
        items.forEach { navItem ->
            NavigationBarItem(
                selected = navItem == selectedItem,
                label = { Text(navItem.label) },
                icon = { Icon(navItem.icon, contentDescription = null) },
                onClick = {
                    onItemSelected(navItem)
                    navItem.onClick()
                },
            )
        }
    }
}