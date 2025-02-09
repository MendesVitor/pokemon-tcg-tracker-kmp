package navigation

import androidx.compose.animation.AnimatedContentTransitionScope
import androidx.compose.animation.core.tween
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import org.example.poketcg.presentation.ui.screens.HomeScreen
import org.example.poketcg.presentation.ui.screens.SetDetailScreen


@Composable
fun NavGraph() {
    NavHost(
        navController = NavigationManager.navController,
        startDestination = Screen.Home.route,
        enterTransition = {
            slideIntoContainer(
                AnimatedContentTransitionScope.SlideDirection.Left,
                animationSpec = tween(200)
            )
        },
        exitTransition = {
            slideOutOfContainer(
                AnimatedContentTransitionScope.SlideDirection.Left,
                animationSpec = tween(200)
            )
        },
        popEnterTransition = {
            slideIntoContainer(
                AnimatedContentTransitionScope.SlideDirection.Right,
                animationSpec = tween(200)
            )
        },
        popExitTransition = {
            slideOutOfContainer(
                AnimatedContentTransitionScope.SlideDirection.Right,
                animationSpec = tween(200)
            )
        },
    ) {
        composable(
            route = Screen.Home.route,
        ) {
            HomeScreen()
        }
        composable(
            route = Screen.SetDetail.route
        ) { backStackEntry ->
            SetDetailScreen(setId = backStackEntry.arguments?.getString("setId") ?: "")
        }
    }
}