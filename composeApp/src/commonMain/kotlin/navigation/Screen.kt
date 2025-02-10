package navigation

sealed class Screen(val route: String) {
    object Home : Screen("home")
    object SetDetail : Screen("setDetail/{setId}")
    object Sets : Screen("sets")
    object Search : Screen("search")
    object Collection : Screen("collection")
}