package navigation

import androidx.navigation.NavHostController

object NavigationManager {
    lateinit var navController: NavHostController

    fun init(navController: NavHostController) {
        NavigationManager.navController = navController
    }

    fun navigate(route: String) {
        val startDestination = navController.graph.startDestinationRoute ?: return

        navController.navigate(route) {
            popUpTo(startDestination) { inclusive = true }
            launchSingleTop = true
            restoreState = false
        }
    }

    fun navigateUp() {
        navController.navigateUp()
    }

    fun navigateToSetDetail(setId: String) {
        navController.navigate("setDetail/$setId")
    }

    fun navigateToHome() {
        navController.navigate("home")
    }
}
