package com.brian.androidmultimodulenavigation.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.brian.androidmultimodulenavigation.R
import com.brian.core.route.FeatureARouteContract
import com.brian.core.route.FeatureBRouteContract
import kotlinx.android.synthetic.main.activity_main.*
import org.koin.android.ext.android.inject

class MainActivity : AppCompatActivity() {
    private val featureARouteContract: FeatureARouteContract by inject()
    private val featureBRouteContract: FeatureBRouteContract by inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnNavigateFeatureA.setOnClickListener { featureARouteContract.navigateToAHome(this, "Hi Home A") }
        btnNavigateFeatureB.setOnClickListener { featureBRouteContract.navigateToBHome(this, "Hi Home B") }
    }
}
