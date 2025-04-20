import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import navigation.NavGraph
import navigation.NavigationManager
import org.jetbrains.compose.ui.tooling.preview.Preview
import presentation.ui.components.AppBar
import presentation.ui.components.BottomBar
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import presentation.ui.components.NavItem

@Composable
@Preview
fun App(navController: NavHostController = rememberNavController()) {
    NavigationManager.init(navController)

    var selectedItem by remember { mutableStateOf<NavItem?>(null) }

    MaterialTheme {
        Scaffold(
            topBar = {
                AppBar(onHomeClick = {
                    selectedItem = null
                    NavigationManager.navigateToHome()
                })
            },
            content = { innerPadding ->
                Box(Modifier.padding(innerPadding)) {
                    NavGraph()
                }
            },
            bottomBar = {
                BottomBar(
                    selectedItem = selectedItem,
                    onItemSelected = { selectedItem = it }
                )
            }
        )
    }
}
