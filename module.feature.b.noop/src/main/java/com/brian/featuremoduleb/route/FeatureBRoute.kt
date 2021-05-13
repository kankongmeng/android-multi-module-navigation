package com.brian.featuremoduleb.route

import android.app.Activity
import android.widget.Toast
import com.brian.core.route.FeatureBRouteContract

class FeatureBRoute : FeatureBRouteContract {
    override fun navigateToBHome(fromActivity: Activity, data: String?) {
        Toast.makeText(
            fromActivity,
            "excludeModuleFeatureB=true in local.properties",
            Toast.LENGTH_SHORT
        ).show()
    }
}
