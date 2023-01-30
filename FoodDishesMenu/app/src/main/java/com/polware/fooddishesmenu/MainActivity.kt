package com.polware.fooddishesmenu

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.ui.Modifier
import com.polware.fooddishesmenu.ui.components.FoodDishesApp
import com.polware.fooddishesmenu.ui.theme.FoodDishesMenuTheme

/**
 * TheMealDB
 * All meal categories: www.themealdb.com/api/json/v1/1/categories.php
 */

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            FoodDishesMenuTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    FoodDishesApp()
                }
            }
        }
    }
}