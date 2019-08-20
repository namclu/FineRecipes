package com.namlu.finerecipes.requests.responses

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import com.namlu.finerecipes.models.Recipe

class RecipeResponse {

    @SerializedName("recipe")
    @Expose
    private val recipe: Recipe? = null

    fun getRecipe(): Recipe? {
        return recipe
    }

    override fun toString(): String {
        return "RecipeResponse{" +
                "recipe=" + recipe +
                '}'.toString()
    }
}