package com.example.storeappprojectkotlincompose.Database

import android.content.Context
import android.content.SharedPreferences
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

object SharedPreferencesManager {
    private const val PREFS_NAME = "store_prefs"
    private const val KEY_PURCHASED_ITEMS = "purchased_items"
    private const val KEY_CART_ITEMS = "cart_items"

    // grab the file location to access and get data
    private fun getPreferences(context: Context): SharedPreferences {
        return context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)
    }

    // save with Gson (Json)
    fun saveItems(context: Context, purchasedItems: List<OrderItem>, cartItems: List<StoreItem>) {
        val editor = getPreferences(context).edit()

        val gson = Gson()
        val purchasedJson = gson.toJson(purchasedItems)
        val cartJson = gson.toJson(cartItems)

        editor.putString(KEY_PURCHASED_ITEMS, purchasedJson)
        editor.putString(KEY_CART_ITEMS, cartJson)
        editor.apply()
    }

    // load from local data
    fun loadItems(context: Context): Pair<List<OrderItem>, List<StoreItem>> {
        val sharedPreferences = getPreferences(context)

        val gson = Gson()
        val purchasedJson = sharedPreferences.getString(KEY_PURCHASED_ITEMS, "[]")
        val cartJson = sharedPreferences.getString(KEY_CART_ITEMS, "[]")

        // convert the json strings back to lists
        val purchasedType = object : TypeToken<List<OrderItem>>() {}.type
        val cartType = object : TypeToken<List<StoreItem>>() {}.type

        val purchasedItems = gson.fromJson<List<OrderItem>>(purchasedJson, purchasedType)
        val cartItems = gson.fromJson<List<StoreItem>>(cartJson, cartType)

        return Pair(purchasedItems, cartItems)
    }
}
