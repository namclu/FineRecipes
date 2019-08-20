package com.namlu.finerecipes.requests.responses

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import com.namlu.finerecipes.models.Recipe

class RecipeSearchResponse {

    @SerializedName("count")
    @Expose
    private val count: Int = 0

    @SerializedName("recipes")
    @Expose
    private val recipes: List<Recipe>? = null

    fun getCount(): Int {
        return count
    }

    fun getRecipes(): List<Recipe>? {
        return recipes
    }

    override fun toString(): String {
        return "RecipeSearchResponse{" +
                "count=" + count +
                ", recipes=" + recipes +
                '}'.toString()
    }
}