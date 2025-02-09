package ui.components


import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.navigation.compose.currentBackStackEntryAsState
import navigation.NavigationManager
import androidx.compose.material3.TopAppBar
import navigation.Screen


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppBar() {
    val navBackStackEntry = NavigationManager.navController.currentBackStackEntryAsState().value
    val canNavigateUp = navBackStackEntry?.destination?.route != Screen.Home.route

    TopAppBar(
        title = { Text("Pokémon TCG Tracker") },
        navigationIcon = {
            if (canNavigateUp) {
                IconButton(onClick = { NavigationManager.navigateUp() }) {
                    Icon(
                        imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                        contentDescription = "Back"
                    )
                }
            }
        }
    )
}
