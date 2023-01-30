package com.polware.fooddishesmenu.viewmodel

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.polware.fooddishesmenu.data.models.MealCategoryData

class FoodDetailsViewModel(private val savedStateHandle: SavedStateHandle): ViewModel() {
    private val repository = FoodsRepository.getInstance()

    var mealState = mutableStateOf<MealCategoryData?>(null)

    init {
        val mealId = savedStateHandle.get<String>("food_id")?: ""
        mealState.value = repository.getMealInfo(mealId)
    }

}