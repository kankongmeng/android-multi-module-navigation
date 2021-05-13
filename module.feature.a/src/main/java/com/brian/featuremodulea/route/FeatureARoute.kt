package com.brian.featuremodulea.route

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import com.brian.core.route.FeatureARouteContract
import com.brian.featuremodulea.activity.FeatureAHomeActivity

class FeatureARoute : FeatureARouteContract {
    override fun navigateToAHome(fromActivity: Activity, data: String?) {
        val intent = Intent(fromActivity, FeatureAHomeActivity::class.java)
        if (data != null) {
            val bundle = Bundle()
            bundle.putString(INTENT_EXTRA_DATA_STRING, data)
            intent.putExtras(bundle)
        }

        fromActivity.startActivity(intent)
    }

    companion object {
        const val INTENT_EXTRA_DATA_STRING = "INTENT_EXTRA_DATA_STRING"
    }
}
