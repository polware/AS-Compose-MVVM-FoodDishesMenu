package com.polware.fooddishesmenu.data.models

import com.google.gson.annotations.SerializedName

data class MealCategoryData(
    @SerializedName("idCategory")
    val id: String,
    @SerializedName("strCategory")
    val name: String,
    @SerializedName("strCategoryThumb")
    val imageUrl: String,
    @SerializedName("strCategoryDescription")
    val description: String
)