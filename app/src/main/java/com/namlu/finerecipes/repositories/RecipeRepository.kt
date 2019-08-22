package com.namlu.finerecipes.repositories

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import com.namlu.finerecipes.models.Recipe

/*
* The Repository mediates data between the ViewModel and data sources
* (e.g. network data or local SQLite database).
* It will be used by the ViewModel to get its data.
* */
class RecipeRepository private constructor() {
    private val recipes: MutableLiveData<List<Recipe>>

    init {
        recipes = MutableLiveData()
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
        return recipes
    }
}
