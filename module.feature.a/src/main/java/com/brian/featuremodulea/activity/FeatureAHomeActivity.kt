package com.brian.featuremodulea.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.brian.core.navigation.Navigation
import com.brian.featuremodulea.R
import kotlinx.android.synthetic.main.feature_a_activity_home.*

class FeatureAHomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.feature_a_activity_home)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        btnNavigateFeatureBHome.setOnClickListener {
            Navigation.navigateToBHome(this, "Hi Home B, I from Feature A")
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        finish()
        return true
    }
}
