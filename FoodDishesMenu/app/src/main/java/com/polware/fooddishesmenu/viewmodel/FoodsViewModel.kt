package com.polware.fooddishesmenu.viewmodel

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.polware.fooddishesmenu.data.models.MealCategoryData
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class FoodsViewModel(private val repository: FoodsRepository = FoodsRepository.getInstance()):
    ViewModel() {
    val mealsState: MutableState<List<MealCategoryData>> = mutableStateOf(emptyList())

    init {
        viewModelScope.launch(Dispatchers.IO) {
            mealsState.value = getMealsCategory()
        }
    }

    private suspend fun getMealsCategory(): List<MealCategoryData> {
        return repository.getMealsCategory().mealsCategory
    }

}