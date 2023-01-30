package com.polware.fooddishesmenu.ui.navigation

sealed class PageRoutes(val route: String) {

    object Home: PageRoutes("HomeFoodDishes")
    object FoodDetails: PageRoutes("FoodDetails/{food_id}") {
        fun loadThisId(foodId: String) = "FoodDetails/$foodId"
    }

}