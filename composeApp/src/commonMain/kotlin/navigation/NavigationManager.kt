package navigation

import androidx.navigation.NavHostController

object NavigationManager {
    lateinit var navController: NavHostController

    fun init(navController: NavHostController) {
        NavigationManager.navController = navController
    }

    fun navigate(route: String) {
        navController.navigate(route)
    }

    fun navigateUp() {
        navController.navigateUp()
    }

    fun navigateToSetDetail(setId: String) {
        navController.navigate("setDetail/$setId")
    }
}
