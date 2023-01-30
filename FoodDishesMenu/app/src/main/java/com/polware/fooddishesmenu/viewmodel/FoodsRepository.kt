package com.polware.fooddishesmenu.viewmodel

import com.polware.fooddishesmenu.data.api.RetrofitClient
import com.polware.fooddishesmenu.data.models.MealCategoryData
import com.polware.fooddishesmenu.data.models.TheMealDBResponse

class FoodsRepository {
    private var cachedMeals = listOf<MealCategoryData>()

    companion object {
        @Volatile
        private var instance: FoodsRepository? = null

        fun getInstance() = instance?: synchronized(this) {
            instance ?: FoodsRepository().also { instance = it }
        }
    }

    suspend fun getMealsCategory(): TheMealDBResponse {
        val responseApi = RetrofitClient.apiService.getMealsCategory()
        cachedMeals = responseApi.mealsCategory
        return responseApi
    }

    fun getMealInfo(id: String): MealCategoryData? {
        return cachedMeals.firstOrNull {
            it.id == id
        }
    }

}