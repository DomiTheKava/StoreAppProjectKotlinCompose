package com.example.storeappprojectkotlincompose.screens.Home

import android.content.Context
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.storeappprojectkotlincompose.Database.ItemDataHolder
import com.example.storeappprojectkotlincompose.Database.ItemDataHolder.itemList
import com.example.storeappprojectkotlincompose.Database.StoreItem
import com.example.storeappprojectkotlincompose.R


@Composable
fun DetailedView(item: StoreItem) {

    val context = LocalContext.current

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Image(
            painter = painterResource(R.drawable.ic_launcher_background),
            contentDescription = null,
            modifier = Modifier
                .fillMaxWidth()
                .aspectRatio(1f),
            contentScale = ContentScale.Crop
        )

        Spacer(modifier = Modifier.height(16.dp))

        Text(
            text = item.itemName,
            style = TextStyle(fontSize = 20.sp, fontWeight = FontWeight.Bold)
        )

        Spacer(modifier = Modifier.height(8.dp))

        Text(text = "Price: $${item.priceval}")

        Spacer(modifier = Modifier.height(8.dp))

        Text(text = "Description: ${item.descriptionval}")

        Spacer(modifier = Modifier.height(8.dp))

        Text(text = "Stock: ${item.stock}")

        Spacer(modifier = Modifier.height(16.dp))

        Button(onClick = {
            itemList.shoppingCart.add(item)
            Toast.makeText(context, "Item added to cart", Toast.LENGTH_SHORT).show()
            ItemDataHolder.saveItems(context)
        }) {
            Text(text = "Add to Cart")
        }
    }
}@Composable
fun DetailedItemView(modifier: Modifier = Modifier) {
    Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
        Text(text = "Detailed View", Modifier.padding(innerPadding))
    }
}