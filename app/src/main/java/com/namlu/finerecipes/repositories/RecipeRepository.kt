package com.namlu.finerecipes.repositories

import android.arch.lifecycle.LiveData
import com.namlu.finerecipes.models.Recipe
import com.namlu.finerecipes.requests.RecipeApiClient

/*
* The Repository mediates data between the ViewModel and data sources
* (e.g. network data or local SQLite database).
* It will be used by the ViewModel to get its data.
* */
class RecipeRepository private constructor() {
    private val recipeApiClient: RecipeApiClient

    init {
        recipeApiClient = RecipeApiClient.getInstance()
    }

    companion object {
        private var instance: RecipeRepository? = null

        fun getInstance(): RecipeRepository {
            if (instance == null) {
                instance = RecipeRepository()
            }
            return instance as RecipeRepository
        }
    }

    fun getRecipes(): LiveData<List<Recipe>> {
        return recipeApiClient.getRecipes()
    }
}
