package com.polware.fooddishesmenu.data.api

import com.polware.fooddishesmenu.data.models.TheMealDBResponse
import retrofit2.http.GET

interface MealDBApiService {

    @GET("categories.php")
    suspend fun getMealsCategory(): TheMealDBResponse

}