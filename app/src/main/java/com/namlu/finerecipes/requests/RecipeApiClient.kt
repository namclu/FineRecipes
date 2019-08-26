package com.namlu.finerecipes.requests

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import com.namlu.finerecipes.AppExecutors
import com.namlu.finerecipes.models.Recipe
import com.namlu.finerecipes.util.Constants
import java.util.concurrent.TimeUnit


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

    fun searchRecipesAPI() {
        val handler = AppExecutors.getInstance().networkIO().submit(object: Runnable {
            override fun run() {
                // Get data from REST API
                // recipes.postValue()
            }

        })

        AppExecutors.getInstance().networkIO().schedule(object: Runnable {
            override fun run() {
                // Let user know network has timed out
                handler.cancel(true)
            }
        }, Constants.NETWORK_TIMEOUT, TimeUnit.MILLISECONDS)
    }
}
