package com.namlu.finerecipes

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProvider
import android.arch.lifecycle.ViewModelProviders
import android.os.Build
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import com.namlu.finerecipes.models.Recipe
import com.namlu.finerecipes.requests.ServiceGenerator
import com.namlu.finerecipes.requests.responses.RecipeResponse
import com.namlu.finerecipes.requests.responses.RecipeSearchResponse
import com.namlu.finerecipes.viewmodels.RecipeListViewModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.io.IOException

class RecipeListActivity : BaseActivity() {

    private lateinit var recipeListViewModel: RecipeListViewModel

    companion object {
        const val TAG = "RecipeListActivity"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recipe_list)

        recipeListViewModel = ViewModelProviders.of(this).get(RecipeListViewModel::class.java)

        subscribeObservers()
    }

    private fun subscribeObservers() {
        recipeListViewModel.getRecipes().observe(this, object : Observer<List<Recipe>> {
            override fun onChanged(recipes: List<Recipe>?) {

            }

        })
    }

    private fun testRetrofitRequest() {
        val recipeApi = ServiceGenerator.getRecipeApi()

        // Get a specific recipe
        val responseCall = recipeApi.getRecipe(
            BuildConfig.FOOD_2_FORK_API_KEY,
            "35382"
        )

        responseCall.enqueue(object : Callback<RecipeResponse> {
            override fun onResponse(call: Call<RecipeResponse>, response: Response<RecipeResponse>) {
                Log.d(TAG, "onResponse: Server Response: $response")
                if (response.code() == 200) {
                    Log.d(TAG, "onResponse: response.body() = ${response.body()}")
                    val recipe = response.body()?.getRecipe()
                    Log.d(TAG, "onResponse: recipe = $recipe")
                } else {
                    try {
                        Log.d(TAG, "onResponse: ${response.errorBody()}")
                    } catch (e: IOException) {
                        e.printStackTrace()
                    }
                }
            }

            override fun onFailure(call: Call<RecipeResponse>, t: Throwable) {
                Log.e(TAG, "onResponse: ERROR: " + t.message)
            }

        })

        // Search for recipes
//        val responseCall = recipeApi.searchRecipe(
//            BuildConfig.FOOD_2_FORK_API_KEY,
//            "chicken breast",
//            "1"
//        )
//
//        responseCall.enqueue(object : Callback<RecipeSearchResponse> {
//            override fun onResponse(call: Call<RecipeSearchResponse>, response: Response<RecipeSearchResponse>) {
//                Log.d(TAG, "onResponse: Server Response: $response")
//                if (response.code() == 200) {
//                    Log.d(TAG, "onResponse: response.body() = ${response.body()}")
//                    val recipes: List<Recipe> = ArrayList(response.body()?.getRecipes())
//                    for (recipe in recipes ) {
//                        Log.d(TAG, "onResponse: response.title ${recipe.title}")
//                    }
//                } else {
//                    try {
//                        Log.d(TAG, "onResponse: ${response.errorBody()}")
//                    } catch (e: IOException) {
//                        e.printStackTrace()
//                    }
//                }
//            }
//
//            override fun onFailure(call: Call<RecipeSearchResponse>, t: Throwable) {
//                Log.e(TAG, "onResponse: ERROR: " + t.message)
//            }
//        })
    }
}
