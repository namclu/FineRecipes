package com.namlu.finerecipes.requests

import retrofit2.http.GET
import retrofit2.http.Query
import com.namlu.finerecipes.requests.responses.RecipeResponse
import com.namlu.finerecipes.requests.responses.RecipeSearchResponse
import retrofit2.Call


interface RecipeApi {

    // Search for recipes
    // Sample search URL:
    // https://www.food2fork.com/api/search?key=YOUR_API_KEY&q=chicken%20breast&page=2
    @GET("api/search")
    fun searchRecipe(
        @Query("key") key: String,
        @Query("q") query: String,
        @Query("page") page: String
    ): Call<RecipeSearchResponse>

    // Get a specific recipe
    // Sample recipe URL:
    // https://www.food2fork.com/api/get?key=YOUR_API_KEY&rId=35382
    @GET("api/get")
    fun getRecipe(
        @Query("key") key: String,
        @Query("rId") recipe_id: String
    ): Call<RecipeResponse>

}