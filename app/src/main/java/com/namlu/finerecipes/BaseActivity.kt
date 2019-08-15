package com.namlu.finerecipes

import android.support.constraint.ConstraintLayout
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.FrameLayout
import android.widget.ProgressBar

abstract class BaseActivity : AppCompatActivity() {

    lateinit var mProgressBar: ProgressBar

    override fun setContentView(layoutResID: Int) {

        val constraintLayout: ConstraintLayout  =
            layoutInflater.inflate(R.layout.activity_base, null) as ConstraintLayout
        val frameLayout: FrameLayout = constraintLayout.findViewById(R.id.activity_content)
        mProgressBar = constraintLayout.findViewById(R.id.progress_bar)

        // FrameLayout acts as a container for any activity that extends BaseActivity
        layoutInflater.inflate(layoutResID, frameLayout, true)
        super.setContentView(constraintLayout)
    }

    fun showProgressBar(visible: Boolean) {
        if(visible) {
            mProgressBar.visibility = View.VISIBLE

        } else {
            mProgressBar.visibility = View.INVISIBLE
        }
    }
}