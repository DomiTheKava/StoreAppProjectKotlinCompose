package com.example.storeappprojectkotlincompose.screens.Home

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.storeappprojectkotlincompose.Database.StoreItem

@Composable
fun ShoppingRow(modifier: Modifier = Modifier,
                title: String = "No Title" ,
                data: List<StoreItem>,
                selectedItem: StoreItem? = null,
                onItemClick: (StoreItem) -> Unit) {

    Column(modifier = modifier) {
        
        Text(text = title, modifier = Modifier.padding(10.dp), fontSize = 30.sp)
        HorizontalDivider(thickness = 2.dp)

        LazyRow(Modifier.padding(10.dp)) {
            item {

                for (item in data) {
                    ShoppingRowItem(
                        item = item,
                        modifier = Modifier.padding(10.dp),
                        onItemClick = { onItemClick(item) }
                    )
                }

            }

        }

    }

}