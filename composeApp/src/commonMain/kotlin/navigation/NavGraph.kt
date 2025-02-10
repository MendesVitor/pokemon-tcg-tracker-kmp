package navigation

import androidx.compose.animation.AnimatedContentTransitionScope
import androidx.compose.animation.core.tween
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import org.example.poketcg.presentation.ui.screens.SetDetailScreen
import presentation.ui.page.CollectionScreen
import presentation.ui.page.HomeScreen
import presentation.ui.page.SearchScreen
import presentation.ui.page.SetScreen


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
        composable(
            route = Screen.Sets.route,
        ) {
            SetScreen()
        }
        composable(
            route = Screen.Search.route,
        ) {
            SearchScreen()
        }
        composable(
            route = Screen.Collection.route,
        ) {
            CollectionScreen()
        }
    }
}