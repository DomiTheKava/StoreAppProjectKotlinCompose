package com.example.storeappprojectkotlincompose.Database


data class OrderItem( // this will be used when item is purchased/checked out
    val price: Double,
    val paymentMethod: String,
    val itemName: String,
    val quantity: Int,
    val shippingToAddress: String?,
    val purchaseDate: String,
    val itemId: Int,
    val itemImageUrl: String,
    val itemType: String, // ItemType
    val description: String
)