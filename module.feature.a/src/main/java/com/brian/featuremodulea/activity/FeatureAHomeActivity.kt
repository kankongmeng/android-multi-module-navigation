package com.brian.featuremodulea.activity

import android.os.Bundle
import com.brian.androidmultimodulenavigation.activity.BaseActivity
import com.brian.core.route.FeatureARouteContract
import com.brian.core.route.FeatureBRouteContract
import com.brian.featuremodulea.R
import kotlinx.android.synthetic.main.feature_a_activity_home.*
import org.koin.android.ext.android.inject

class FeatureAHomeActivity : BaseActivity() {
    private val featureARouteContract: FeatureARouteContract by inject()
    private val featureBRouteContract: FeatureBRouteContract by inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.feature_a_activity_home)

        btnNavigateFeatureBHome.setOnClickListener { featureBRouteContract.navigateToBHome(this, "Hi Home B") }
    }
}
