package com.brian.core.navigation

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import com.brian.core.helper.ViewUtils

object Navigation {
    fun navigateToAHome(act: Activity) {
        val destActName = "com.brian.featuremodulea.activity.FeatureAHomeActivity"
        val toastText = "excludeModuleFeatureA=true in local.properties"

        startNavigation(act, destActName, toastText)
    }

    fun navigateToBHome(act: Activity, data: String) {
        val destActName = "com.brian.featuremoduleb.activity.FeatureBHomeActivity"
        val toastText = "excludeModuleFeatureB=true in local.properties"
        val bundle = Bundle()

        bundle.putString(B_INTENT_EXTRA_DATA_STRING, data)

        startNavigation(act, destActName, toastText, bundle)
    }

    private fun startNavigation(
        act: Activity,
        desActName: String,
        toastText: String,
        bundle: Bundle? = null
    ) {
        try {
            val c = Class.forName(desActName)
            val intent = Intent(act, c)

            if (bundle != null) {
                intent.putExtras(bundle)
            }

            act.startActivity(intent)
        } catch (ignored: ClassNotFoundException) {
            ViewUtils.showToastShort(act, toastText)
        }
    }

    const val B_INTENT_EXTRA_DATA_STRING = "B_INTENT_EXTRA_DATA_STRING"
}
