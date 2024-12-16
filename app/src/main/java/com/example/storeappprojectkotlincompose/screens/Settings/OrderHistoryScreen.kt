package com.example.storeappprojectkotlincompose.screens.Settings

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.storeappprojectkotlincompose.Database.ItemDataHolder
import com.example.storeappprojectkotlincompose.Database.ItemDataHolder.itemList
import com.example.storeappprojectkotlincompose.Database.OrderItem

@Composable
fun OrderHistoryScreen() {
    Scaffold { padding ->
        LazyColumn(
            modifier = Modifier
                .padding(padding)
                .padding(16.dp)
        ) {
            items(ItemDataHolder.itemList.purchasedItems) { order ->
                OrderItemView(order)
            }
        }
    }
}

@Composable
fun OrderItemView(order: OrderItem) {
    Column(modifier = Modifier.padding(16.dp)) {
        Text(text = "Item Name: ${order.itemName}", fontWeight = FontWeight.Bold)
        Text(text = "Price: ${order.price}",)
        Text(text = "Quantity: ${order.quantity}")
        Text(text = "Description: ${order.description}")
        Spacer(modifier = Modifier.height(8.dp))
        Divider()
    }
}
