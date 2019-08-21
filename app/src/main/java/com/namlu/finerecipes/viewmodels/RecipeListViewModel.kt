package com.namlu.finerecipes.viewmodels

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import com.namlu.finerecipes.models.Recipe


class RecipeListViewModel : ViewModel() {

    private val recipes = MutableLiveData<List<Recipe>>()

    fun getRecipes(): LiveData<List<Recipe>> {
        return recipes
    }

}