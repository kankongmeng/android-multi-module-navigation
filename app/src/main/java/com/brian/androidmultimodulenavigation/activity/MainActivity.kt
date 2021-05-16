package com.brian.androidmultimodulenavigation.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.brian.androidmultimodulenavigation.R
import com.brian.core.navigation.Navigation
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnNavigateFeatureA.setOnClickListener { Navigation.navigateToAHome(this) }
        btnNavigateFeatureB.setOnClickListener { Navigation.navigateToBHome(this, "Hi Home B") }
    }
}
