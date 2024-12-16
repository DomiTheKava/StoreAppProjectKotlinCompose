package com.example.storeappprojectkotlincompose.navigation

import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavType
import androidx.navigation.navArgument
import com.example.storeappprojectkotlincompose.Database.ItemDataHolder
import com.example.storeappprojectkotlincompose.screens.Home.DetailedView
import com.example.storeappprojectkotlincompose.screens.Home.MainShoppingScreen
import com.example.storeappprojectkotlincompose.screens.Settings.OrderHistoryScreen
import com.example.storeappprojectkotlincompose.screens.Settings.SettingsScreen
import com.example.storeappprojectkotlincompose.screens.ShoppingCart.ShoppingCartScreen


// TODO: Learn how this works more
sealed class Screen(val route: String, val title: String, val icon: ImageVector) {
    object MainScreen : Screen("mainScreen", "Home", Icons.Filled.Home)
    object ShoppingCart : Screen("shoppingCart", "Cart", Icons.Filled.ShoppingCart)
    object Settings : Screen("settings", "Settings", Icons.Filled.Settings)
}

@Composable
fun NavBar(navController: NavHostController = rememberNavController()) {

    val context = LocalContext.current

    ItemDataHolder.initialize(
        context = context
    )

    val items = listOf(
        Screen.MainScreen,
        Screen.ShoppingCart,
        Screen.Settings
    )
    Scaffold(
        bottomBar = {
            NavigationBar {
                val navBackStackEntry by navController.currentBackStackEntryAsState()
                val currentDestination = navBackStackEntry?.destination
                items.forEach { screen ->
                    NavigationBarItem(
                        icon = { Icon(screen.icon, contentDescription = null) },
                        label = { Text(screen.title) },
                        selected = currentDestination?.hierarchy?.any { it.route == screen.route } == true,
                        onClick = {
                            navController.navigate(screen.route) {
                                popUpTo(navController.graph.findStartDestination().id) {
                                    saveState = true
                                }
                                launchSingleTop = true
                                restoreState = true
                            }
                        }
                    )
                }
            }
        }
    ) { innerPadding ->
        NavHost(navController = navController, startDestination = "mainScreen", modifier = Modifier.padding(innerPadding)) {
            composable("mainScreen") { MainShoppingScreen(navController) }
            composable("shoppingCart") { ShoppingCartScreen(navController) }
            composable("settings") { SettingsScreen(navController) }
            composable("orderHistory") { OrderHistoryScreen() }
            composable(
                "detailedView/{itemId}",
                arguments = listOf(navArgument("itemId") { type = NavType.IntType })
            ) { backStackEntry ->
                val itemId = backStackEntry.arguments?.getInt("itemId")
                if (itemId != null) {
                    val item = ItemDataHolder.itemList.items.find { it.itemId == itemId }
                    if (item != null) {
                        DetailedView(item = item)
                    }
                }
            }
        }
    }
}