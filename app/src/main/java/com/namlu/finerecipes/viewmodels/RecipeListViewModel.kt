package com.namlu.finerecipes.viewmodels

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.ViewModel
import com.namlu.finerecipes.models.Recipe
import com.namlu.finerecipes.repositories.RecipeRepository

class RecipeListViewModel : ViewModel() {
    private val recipeRepository: RecipeRepository = RecipeRepository.getInstance()

    fun getRecipes(): LiveData<List<Recipe>> {
        return recipeRepository.getRecipes()
    }
}