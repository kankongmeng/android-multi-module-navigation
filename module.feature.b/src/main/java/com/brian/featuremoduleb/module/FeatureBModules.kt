package com.brian.featuremoduleb.module

import com.brian.core.di.provideNetworkModule
import com.brian.featuremoduleb.api.FeatureBApiServices
import com.brian.featuremoduleb.repository.FeatureBQuoteRepository
import com.brian.featuremoduleb.viewmodel.FeatureBHomeViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.context.loadKoinModules
import org.koin.dsl.module
import retrofit2.Retrofit

private const val FEATURE_B_BASE_URL = "https://60a11b18d2855b00173b1a21.mockapi.io/api/v1/"

val featureBModules = module {
    // Provide an instance for Repository
    factory { FeatureBQuoteRepository(get()) }

    // Provide an instance for ViewModel
    viewModel { FeatureBHomeViewModel(get()) }

    // Provide an instance for Retrofit
    factory { get<Retrofit>().create(FeatureBApiServices::class.java) }
}

val loadFeaturesB by lazy {
    loadKoinModules(
        listOf(
            provideNetworkModule(FEATURE_B_BASE_URL),
            featureBModules
        )
    )
}

fun injectFeaturesB() = loadFeaturesB
