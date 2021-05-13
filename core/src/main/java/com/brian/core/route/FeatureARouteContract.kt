package com.brian.core.route

import android.app.Activity

interface FeatureARouteContract {
    fun navigateToAHome(activity: Activity, str: String?)
}
