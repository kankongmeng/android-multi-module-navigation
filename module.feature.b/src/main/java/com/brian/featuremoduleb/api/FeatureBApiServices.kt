package com.brian.featuremoduleb.api

import com.brian.featuremoduleb.model.FeatureBQuote
import kotlinx.coroutines.Deferred
import retrofit2.http.GET

interface FeatureBApiServices {
    @GET("random")
    fun getQuoteRandom(): Deferred<List<FeatureBQuote>>
}
