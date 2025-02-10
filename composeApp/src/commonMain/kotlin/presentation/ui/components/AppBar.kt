package presentation.ui.components


import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.navigation.compose.currentBackStackEntryAsState
import navigation.NavigationManager
import navigation.Screen


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppBar() {
    val navBackStackEntry = NavigationManager.navController.currentBackStackEntryAsState().value
    val canNavigateUp = navBackStackEntry?.destination?.route != Screen.Home.route

    TopAppBar(
        title = { Text("Pokémon TCG Tracker") },
    )
}
