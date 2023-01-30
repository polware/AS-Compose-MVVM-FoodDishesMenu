package com.polware.fooddishesmenu.data.models

import com.google.gson.annotations.SerializedName

data class TheMealDBResponse(
    @SerializedName("categories")
    val mealsCategory: List<MealCategoryData>
)