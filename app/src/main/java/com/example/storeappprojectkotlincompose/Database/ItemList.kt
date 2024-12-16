package com.example.storeappprojectkotlincompose.Database

class ItemList(
    val items: List<StoreItem>,
    val itemTypes: List<String>,
    var shoppingCart: MutableList<StoreItem>,
    var purchasedItems: MutableList<OrderItem>
) {

    // filter by item type
    fun filterByType(type: String): List<StoreItem> {
        return items.filter { item -> item.itemType == type }
    }

}


