package com.brian.featuremoduleb.activity

import android.os.Bundle
import com.brian.androidmultimodulenavigation.activity.BaseActivity
import com.brian.featuremoduleb.R
import com.brian.featuremoduleb.route.FeatureBRoute
import kotlinx.android.synthetic.main.feature_b_activity_home.*

class FeatureBHomeActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.feature_b_activity_home)

        tvDesc.text = intent.getStringExtra(FeatureBRoute.INTENT_EXTRA_DATA_STRING_B) ?: "No Intent Data"
    }
}
