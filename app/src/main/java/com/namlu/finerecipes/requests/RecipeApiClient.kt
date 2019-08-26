package com.namlu.finerecipes.requests

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import com.namlu.finerecipes.models.Recipe


/*
* Client is responsible for retrieving data from the REST API
* */
class RecipeApiClient private constructor() {

    private val recipes: MutableLiveData<List<Recipe>>

    init {
        recipes = MutableLiveData()
    }

    companion object {
        private var instance: RecipeApiClient? = null

        fun getInstance(): RecipeApiClient {
            if (instance == null) {
                instance = RecipeApiClient()
            }
            return instance as RecipeApiClient
        }
    }

    fun getRecipes(): LiveData<List<Recipe>> {
        return recipes
    }
}
