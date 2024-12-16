package com.example.storeappprojectkotlincompose.Database

import android.content.Context
import androidx.compose.runtime.mutableStateListOf

object ItemDataHolder {
    lateinit var itemList: ItemList

    fun initialize(context: Context) {
        // would get data from repository (firebase, S3, Etc..) around here instead of hardcoding it withing the app.
        val sampleStoreItems = listOf(
            StoreItem(
                45.99,
                "Product Ele-1",
                23,
                1,
                "image_url_Ele_1",
                "Electronics",
                "Description for Ele-1"
            ),
            StoreItem(
                78.50,
                "Product Ele-2",
                12,
                2,
                "image_url_Ele_2",
                "Electronics",
                "Description for Ele-2"
            ),
            StoreItem(
                29.95,
                "Product Ele-3",
                35,
                3,
                "image_url_Ele_3",
                "Electronics",
                "Description for Ele-3"
            ),
            StoreItem(
                92.25,
                "Product Ele-4",
                8,
                4,
                "image_url_Ele_4",
                "Electronics",
                "Description for Ele-4"
            ),
            StoreItem(
                54.75,
                "Product Ele-5",
                42,
                5,
                "image_url_Ele_5",
                "Electronics",
                "Description for Ele-5"
            ),
            StoreItem(
                15.99,
                "Product Ele-6",
                18,
                6,
                "image_url_Ele_6",
                "Electronics",
                "Description for Ele-6"
            ),
            StoreItem(
                63.99,
                "Product Ele-7",
                29,
                7,
                "image_url_Ele_7",
                "Electronics",
                "Description for Ele-7"
            ),
            StoreItem(
                32.50,
                "Product Clo-1",
                15,
                1,
                "image_url_Clo_1",
                "Clothing",
                "Description for Clo-1"
            ),
            StoreItem(
                59.99,
                "Product Clo-2",
                7,
                2,
                "image_url_Clo_2",
                "Clothing",
                "Description for Clo-2"
            ),
            StoreItem(
                18.95,
                "Product Clo-3",
                28,
                3,
                "image_url_Clo_3",
                "Clothing",
                "Description for Clo-3"
            ),
            StoreItem(
                85.75,
                "Product Clo-4",
                4,
                4,
                "image_url_Clo_4",
                "Clothing",
                "Description for Clo-4"
            ),
            StoreItem(
                42.25,
                "Product Clo-5",
                32,
                5,
                "image_url_Clo_5",
                "Clothing",
                "Description for Clo-5"
            ),
            StoreItem(
                24.99,
                "Product Clo-6",
                21,
                6,
                "image_url_Clo_6",
                "Clothing",
                "Description for Clo-6"
            ),
            StoreItem(
                71.50,
                "Product Clo-7",
                11,
                7,
                "image_url_Clo_7",
                "Clothing",
                "Description for Clo-7"
            ),
            StoreItem(
                14.99,
                "Product Boo-1",
                38,
                1,
                "image_url_Boo_1",
                "Books",
                "Description for Boo-1"
            ),
            StoreItem(
                28.50,
                "Product Boo-2",
                25,
                2,
                "image_url_Boo_2",
                "Books",
                "Description for Boo-2"
            ),
            StoreItem(
                8.95,
                "Product Boo-3",
                45,
                3,
                "image_url_Boo_3",
                "Books",
                "Description for Boo-3"
            ),
            StoreItem(
                42.25,
                "Product Boo-4",
                14,
                4,
                "image_url_Boo_4",
                "Books",
                "Description for Boo-4"
            ),
            StoreItem(
                21.75,
                "Product Boo-5",
                31,
                5,
                "image_url_Boo_5",
                "Books",
                "Description for Boo-5"
            ),
            StoreItem(
                9.99,
                "Product Boo-6",
                24,
                6,
                "image_url_Boo_6",
                "Books",
                "Description for Boo-6"
            ),
            StoreItem(
                35.50,
                "Product Boo-7",
                19,
                7,
                "image_url_Boo_7",
                "Books",
                "Description for Boo-7"
            ),
            StoreItem(
                55.99,
                "Product Hom-1",
                17,
                1,
                "image_url_Hom_1",
                "Home & Kitchen",
                "Description for Hom-1"
            ),
            StoreItem(
                88.50,
                "Product Hom-2",
                9,
                2,
                "image_url_Hom_2",
                "Home & Kitchen",
                "Description for Hom-2"
            ),
            StoreItem(
                39.95,
                "Product Hom-3",
                30,
                3,
                "image_url_Hom_3",
                "Home & Kitchen",
                "Description for Hom-3"
            ),
            StoreItem(
                102.25,
                "Product Hom-4",
                6,
                4,
                "image_url_Hom_4",
                "Home & Kitchen",
                "Description for Hom-4"
            ),
            StoreItem(
                64.75,
                "Product Hom-5",
                37,
                5,
                "image_url_Hom_5",
                "Home & Kitchen",
                "Description for Hom-5"
            ),
            StoreItem(
                25.99,
                "Product Hom-6",
                20,
                6,
                "image_url_Hom_6",
                "Home & Kitchen",
                "Description for Hom-6"
            ),
            StoreItem(
                73.99,
                "Product Hom-7",
                26,
                7,
                "image_url_Hom_7",
                "Home & Kitchen",
                "Description for Hom-7"
            ),
            StoreItem(
                22.50,
                "Product Bea-1",
                22,
                1,
                "image_url_Bea_1",
                "Beauty",
                "Description for Bea-1"
            ),
            StoreItem(
                49.99,
                "Product Bea-2",
                13,
                2,
                "image_url_Bea_2",
                "Beauty",
                "Description for Bea-2"
            ),
            StoreItem(
                10.95,
                "Product Bea-3",
                34,
                3,
                "image_url_Bea_3",
                "Beauty",
                "Description for Bea-3"
            ),
            StoreItem(
                75.75,
                "Product Bea-4",
                10,
                4,
                "image_url_Bea_4",
                "Beauty",
                "Description for Bea-4"
            ),
            StoreItem(
                32.25,
                "Product Bea-5",
                39,
                5,
                "image_url_Bea_5",
                "Beauty",
                "Description for Bea-5"
            ),
            StoreItem(
                14.99,
                "Product Bea-6",
                27,
                6,
                "image_url_Bea_6",
                "Beauty",
                "Description for Bea-6"
            ),
            StoreItem(
                61.50,
                "Product Bea-7",
                16,
                7,
                "image_url_Bea_7",
                "Beauty",
                "Description for Bea-7"
            ),
            StoreItem(
                65.99,
                "Product Spo-1",
                33,
                1,
                "image_url_Spo_1",
                "Sports & Outdoors",
                "Description for Spo-1"
            ),
            StoreItem(
                98.50,
                "Product Spo-2",
                5,
                2,
                "image_url_Spo_2",
                "Sports & Outdoors",
                "Description for Spo-2"
            ),
            StoreItem(
                49.95,
                "Product Spo-3",
                41,
                3,
                "image_url_Spo_3",
                "Sports & Outdoors",
                "Description for Spo-3"
            ),
            StoreItem(
                112.25,
                "Product Spo-4",
                2,
                4,
                "image_url_Spo_4",
                "Sports & Outdoors",
                "Description for Spo-4"
            ),
            StoreItem(
                74.75,
                "Product Spo-5",
                44,
                5,
                "image_url_Spo_5",
                "Sports & Outdoors",
                "Description for Spo-5"
            ),
            StoreItem(
                35.99,
                "Product Spo-6",
                23,
                6,
                "image_url_Spo_6",
                "Sports & Outdoors",
                "Description for Spo-6"
            ),
            StoreItem(
                83.99,
                "Product Spo-7",
                18,
                7,
                "image_url_Spo_7",
                "Sports & Outdoors",
                "Description for Spo-7"
            )
        )

        val (purchasedItems, cartItems) = SharedPreferencesManager.loadItems(context)

        // add the itemType if it doesn't exist already to a list
        val tempTypeLists = sampleStoreItems.map { it.itemType }.distinct()

        // initialize
        itemList = ItemList(
            items = sampleStoreItems,
            itemTypes = tempTypeLists,
            shoppingCart = mutableStateListOf(*cartItems.toTypedArray()),
            purchasedItems = mutableStateListOf(*purchasedItems.toTypedArray())
        )
    }

    // save to local storage
    fun saveItems(context: Context) {
        SharedPreferencesManager.saveItems(
            context,
            itemList.purchasedItems,
            itemList.shoppingCart
        )
    }

}