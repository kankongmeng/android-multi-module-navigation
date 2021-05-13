package com.brian.androidmultimodulenavigation.di

import com.brian.core.route.FeatureARouteContract
import com.brian.core.route.FeatureBRouteContract
import com.brian.featuremodulea.route.FeatureARoute
import com.brian.featuremoduleb.route.FeatureBRoute
import org.koin.dsl.module

val routeModule = module {
    factory<FeatureARouteContract> { FeatureARoute() }
    factory<FeatureBRouteContract> { FeatureBRoute() }
}
