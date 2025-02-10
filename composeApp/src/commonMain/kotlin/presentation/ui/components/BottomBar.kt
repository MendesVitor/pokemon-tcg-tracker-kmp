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
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import navigation.NavigationManager
import navigation.Screen


data class NavItem(
    val icon: ImageVector,
    val label: String,
    val onClick: () -> Unit
)

@Composable
fun BottomBar() {
    val items = remember {
        listOf(
            NavItem(
                icon = Icons.AutoMirrored.Filled.List,
                label = "Coleções",
                onClick = {NavigationManager.navigate(Screen.Sets.route)}
            ),
            NavItem(
                icon = Icons.Default.Search,
                label = "Buscar",
                onClick = {NavigationManager.navigate(Screen.Search.route)}
            ),
            NavItem(
                icon = Icons.Default.LocationOn,
                label = "Álbuns",
                onClick = {NavigationManager.navigate(Screen.Collection.route)}
            ),
        )
    }

    var selectedItem by remember {
        mutableStateOf(items.first())
    }

    BottomAppBar(
        modifier = Modifier
    ) {
        items.forEach { navItem ->
            NavigationBarItem(
                selected = navItem == selectedItem,
                label = { Text(navItem.label) },
                icon = {
                    Icon(navItem.icon, contentDescription = null)
                },
                onClick = {
                    selectedItem = navItem
                    navItem.onClick()
                },
            )
        }
    }
}