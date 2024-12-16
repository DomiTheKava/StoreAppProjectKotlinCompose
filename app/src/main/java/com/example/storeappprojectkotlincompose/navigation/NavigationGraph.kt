package com.example.storeappprojectkotlincompose.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.storeappprojectkotlincompose.Database.ItemDataHolder
import com.example.storeappprojectkotlincompose.screens.Home.DetailedView
import com.example.storeappprojectkotlincompose.screens.Home.MainShoppingScreen
import com.example.storeappprojectkotlincompose.screens.Settings.SettingsScreen
import com.example.storeappprojectkotlincompose.screens.ShoppingCart.ShoppingCartScreen

@Composable
fun NavigationGraph() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "mainScreen") {
        composable("mainScreen") { MainShoppingScreen(navController) }
        composable("shoppingCart") { ShoppingCartScreen(navController) }
        composable("settings") { SettingsScreen(navController) }
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