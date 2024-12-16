package com.example.storeappprojectkotlincompose.screens.ShoppingCart
import android.content.Context
import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.storeappprojectkotlincompose.Database.ItemDataHolder
import com.example.storeappprojectkotlincompose.Database.ItemDataHolder.itemList
import com.example.storeappprojectkotlincompose.Database.ItemList
import com.example.storeappprojectkotlincompose.Database.OrderItem
import com.example.storeappprojectkotlincompose.Database.StoreItem

@Composable
fun ShoppingCartScreen(
    navController: NavHostController,
    modifier: Modifier = Modifier
) {

    val context = LocalContext.current

    Scaffold { paddingValues ->
        Column(
            modifier = Modifier
                .padding(paddingValues)
                .fillMaxSize()
                .padding(16.dp)
        ) {
            LazyColumn(
                modifier = Modifier.weight(1f),
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                items(itemList.shoppingCart) { item -> // for each item in the shopping cart
                    ShoppingCartItem(itemName = item.itemName, price = item.priceval)
                }
            }

            CheckoutButton(context)
        }
    }
}

@Composable
fun ShoppingCartItem(itemName: String, price: Double) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .background(
                color = Color.LightGray,
                shape = RoundedCornerShape(8.dp) // Rounded corners for each item
            )
            .padding(16.dp) // Padding inside the box
    ) {
        Column {
            Text(
                text = itemName,
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Black
            )
            Spacer(modifier = Modifier.height(4.dp)) // Small space between text
            Text(
                text = "Price: $${String.format("%.2f", price)}",
                fontSize = 16.sp,
                color = Color.DarkGray
            )
        }
    }
}

@Composable
fun CheckoutButton(context: Context) {
    Button(
        onClick = {
            Toast.makeText(context, "Checkout Successful", Toast.LENGTH_SHORT).show()
            // TODO: Checkout logic and stuff (adding items to itemlist)

            for (item in itemList.shoppingCart.toList()) {

//                Log.e("SHOPPING CART", "cart: " + item.itemName + " : " + item)

                itemList.purchasedItems.add(
                    OrderItem(
                        price = item.priceval,
                        paymentMethod = "payment method here",
                        itemName = item.itemName,
                        quantity = 1,
                        shippingToAddress = "Address",
                        purchaseDate = "Today",
                        itemId = item.itemId,
                        itemImageUrl = item.itemImg,
                        itemType = item.itemType,
                        description = item.descriptionval
                    )
                )

                itemList.shoppingCart.remove(item)
                ItemDataHolder.saveItems(context)
            }

        },
        modifier = Modifier
            .fillMaxWidth() // Make the button span the width of the screen
            .padding(top = 16.dp), // Add spacing from the LazyColumn
        colors = ButtonDefaults.buttonColors(
            containerColor = Color.Blue,
            contentColor = Color.White
        )
    ) {
        Text(
            text = "Checkout",
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold
        )
    }
}
