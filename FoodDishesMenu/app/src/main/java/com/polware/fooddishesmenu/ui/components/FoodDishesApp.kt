package com.polware.fooddishesmenu.ui.components

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.polware.fooddishesmenu.ui.navigation.FoodDetailsScreen
import com.polware.fooddishesmenu.ui.navigation.FoodDishesScreen
import com.polware.fooddishesmenu.ui.navigation.PageRoutes
import com.polware.fooddishesmenu.viewmodel.FoodDetailsViewModel

@Composable
fun FoodDishesApp() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "HomeFoodDishes") {

        composable(PageRoutes.Home.route) {
            FoodDishesScreen {
                foodId ->
                navController.navigate(PageRoutes.FoodDetails.loadThisId(foodId))
            }
        }

        composable(
            route = PageRoutes.FoodDetails.route,
            arguments = listOf(navArgument("food_id") {
            type = NavType.StringType
        })
        ) {
            val viewModel: FoodDetailsViewModel = viewModel()
            FoodDetailsScreen(food = viewModel.mealState.value,
                navigateBack = { navController.popBackStack() })
        }
    }

}