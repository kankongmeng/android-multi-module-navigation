package com.brian.featuremoduleb.repository

import com.brian.featuremoduleb.api.FeatureBApiServices
import com.brian.featuremoduleb.model.FeatureBQuote
import com.brian.core.viewmodel.Resource

class FeatureBQuoteRepository(private val api: FeatureBApiServices) {
    suspend fun getQuoteRandom(): Resource<List<FeatureBQuote>> {
        return try {
            val result = api.getQuoteRandom().await()
            Resource.Success(result)
        } catch (ex: Exception) {
            Resource.Error(ex)
        }
    }
}
