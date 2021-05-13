package com.brian.featuremoduleb.route

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import com.brian.core.route.FeatureBRouteContract
import com.brian.featuremoduleb.activity.FeatureBHomeActivity

class FeatureBRoute : FeatureBRouteContract {
    override fun navigateToBHome(fromActivity: Activity, data: String?) {
        val intent = Intent(fromActivity, FeatureBHomeActivity::class.java)
        if (data != null) {
            val bundle = Bundle()
            bundle.putString(INTENT_EXTRA_DATA_STRING_B, data)
            intent.putExtras(bundle)
        }

        fromActivity.startActivity(intent)
    }

    companion object {
        const val INTENT_EXTRA_DATA_STRING_B = "INTENT_EXTRA_DATA_STRING_B"
    }
}
