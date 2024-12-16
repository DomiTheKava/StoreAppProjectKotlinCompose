package com.example.storeappprojectkotlincompose.screens.Home

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.storeappprojectkotlincompose.Database.ItemDataHolder
import com.example.storeappprojectkotlincompose.Database.ItemDataHolder.itemList
import com.example.storeappprojectkotlincompose.Database.StoreItem

//@Preview(showBackground = true)
@Composable
fun MainShoppingScreen(
    navController: NavHostController,
    modifier: Modifier.Companion = Modifier) {

//    ItemDataHolder.initialize() // need to only do this once

    var selectedItem by remember { mutableStateOf<StoreItem?>(null) }

    Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->

        LazyColumn(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            item {

                Text(
                    text = "Store Name Here",
                    modifier = Modifier.padding(innerPadding)
                        .padding(top = 20.dp, bottom = 20.dp),
                    style = TextStyle(fontSize = 50.sp),
                    textAlign = TextAlign.Center
                )

                for (type in itemList.itemTypes) {
                    val itemsSorted = itemList.filterByType(type)

                    ShoppingRow(title = type,
                        data = itemsSorted,
                        onItemClick = { item ->
                            selectedItem = item
                            navController.navigate("detailedView/${item.itemId}") // open DetailedView
                        })
//
                }

            }

        }

    }

}

@Composable
fun showDetailedView(item: StoreItem) {
    DetailedView(item = item)
}


