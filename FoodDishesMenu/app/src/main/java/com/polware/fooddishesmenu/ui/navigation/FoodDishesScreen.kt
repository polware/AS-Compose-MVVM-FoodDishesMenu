package com.polware.fooddishesmenu.ui.navigation

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Restaurant
import androidx.compose.runtime.*
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.polware.fooddishesmenu.ui.components.FoodItem
import com.polware.fooddishesmenu.ui.theme.FoodDishesMenuTheme
import com.polware.fooddishesmenu.viewmodel.FoodsViewModel

@Composable
fun FoodDishesScreen(navigationCallback: (String) -> Unit) {
    val viewModel: FoodsViewModel = viewModel()
    val foodsList = viewModel.mealsState.value

    Scaffold(topBar = {
        TopAppBar(
            title = { Text(text = "Food Dishes") },
            navigationIcon = {
                IconButton(onClick = {}) {
                    Icon(Icons.Filled.Restaurant, "Restaurant")
                }
            }
        )
    }) {
        LazyColumn(contentPadding = PaddingValues(15.dp)) {
            items(foodsList) {
                    food ->
                FoodItem(food, navigationCallback)
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    FoodDishesMenuTheme {
        FoodDishesScreen( {})
    }
}