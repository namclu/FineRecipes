package com.namlu.finerecipes.requests

import com.namlu.finerecipes.util.Constants
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ServiceGenerator {

    companion object {
        private val retrofitBuilder = Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())

        private val retrofit = retrofitBuilder.build()

        private val recipeApi = retrofit.create(RecipeApi::class.java)

        fun getRecipeApi(): RecipeApi {
            return recipeApi
        }
    }
}