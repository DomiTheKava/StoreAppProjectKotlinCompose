package com.example.storeappprojectkotlincompose.Database

data class StoreItem (
    val priceval : Double,
    val itemName: String,
    val stock: Int,
    val itemId: Int,
    val itemImg: String,
    val itemType: String, // ItemType
    val descriptionval : String
)
