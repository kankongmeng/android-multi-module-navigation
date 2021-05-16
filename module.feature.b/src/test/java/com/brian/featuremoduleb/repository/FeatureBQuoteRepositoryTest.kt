package com.brian.featuremoduleb.repository

import com.brian.core.viewmodel.Resource
import com.brian.featuremoduleb.BaseTest
import kotlinx.coroutines.runBlocking
import org.junit.Assert.*
import org.junit.Test
import java.net.HttpURLConnection

class FeatureBQuoteRepositoryTest : BaseTest() {
    @Test
    fun `getQuoteRandom on success`() {
        mockHttpResponse(mockServer, "quote_data.json", HttpURLConnection.HTTP_OK)

        val repository = FeatureBQuoteRepository(featureBApiServices)
        val resource = runBlocking { repository.getQuoteRandom() }

        assertTrue(resource is Resource.Success)
        val data = (resource as Resource.Success).data
        assertNotNull(data)
        assertEquals("Thomas Edison", data[0].quoteAuthor)
    }

    @Test
    fun `getQuoteRandom on failure exception`() {
        mockHttpResponse(mockServer, "quote_data.json", HttpURLConnection.HTTP_NOT_FOUND)

        val repository = FeatureBQuoteRepository(featureBApiServices)
        val resource = runBlocking { repository.getQuoteRandom() }

        assertTrue(resource is Resource.Error)
        val data = (resource as Resource.Error).exception.message
        assertNotNull(data)
    }
}
