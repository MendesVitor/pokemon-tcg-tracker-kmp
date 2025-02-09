import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import navigation.NavGraph
import navigation.NavigationManager
import org.jetbrains.compose.ui.tooling.preview.Preview
import ui.components.AppBar
import ui.theme.AppTheme

@Composable
@Preview
fun App(navController: NavHostController = rememberNavController()) {
    NavigationManager.init(navController)

    MaterialTheme {
        Scaffold(
            topBar = {
                AppBar()
            },
            content = { innerPadding ->
                Box(Modifier.padding(innerPadding)){
                    NavGraph()
                }
            }
        )
    }
}
