package com.brian.featuremodulea.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.brian.core.route.FeatureBRouteContract
import com.brian.featuremodulea.R
import kotlinx.android.synthetic.main.feature_a_activity_home.*
import org.koin.android.ext.android.inject

class FeatureAHomeActivity : AppCompatActivity() {
    private val featureBRouteContract: FeatureBRouteContract by inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.feature_a_activity_home)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        btnNavigateFeatureBHome.setOnClickListener {
            featureBRouteContract.navigateToBHome(
                this,
                "Hi Home B"
            )
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        finish()
        return true
    }
}
