package com.namlu.finerecipes

import android.os.Bundle
import android.view.View
import android.widget.Button

class RecipeListActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recipe_list)

        // Test BaseActivity
        val buttonTest = findViewById<Button>(R.id.btn_test)
        buttonTest.setOnClickListener {
            if (mProgressBar.visibility == View.VISIBLE) {
                showProgressBar(false)
            } else {
                showProgressBar(true)

            }
        }
    }
}
