package com.example.storeappprojectkotlincompose.screens.Settings

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController

@Composable
private fun ListItem(title: String, onClick: () -> Unit = {}) {
    Spacer(modifier = Modifier.height(16.dp))
    Text(
        text = title,
        fontSize = 24.sp,
        fontWeight = FontWeight.Bold,
        modifier = Modifier.clickable { onClick() }
    )
    Spacer(modifier = Modifier.height(16.dp))
}

@Composable
fun SettingsScreen(navController: NavHostController) {

    Spacer(modifier = Modifier.height(32.dp))
    LazyColumn(
        Modifier.width(1000.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {

        item {
            Text("Settings", modifier = Modifier.padding(32.dp), fontSize = 32.sp, fontWeight = FontWeight.Bold)
        }

        item {
            ListItem(title = "Account")
        }
        item {
            ListItem(title = "Settings")
        }
        item {
            ListItem(title = "Order History", onClick = {
                navController.navigate("orderHistory")
            })
        }
    }
}