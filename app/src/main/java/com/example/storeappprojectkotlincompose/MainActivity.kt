package com.example.storeappprojectkotlincompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.example.storeappprojectkotlincompose.navigation.NavBar
import com.example.storeappprojectkotlincompose.ui.theme.StoreAppProjectKotlinComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            StoreAppProjectKotlinComposeTheme {
//                NavigationGraph()
                NavBar()
            }
        }
    }
}