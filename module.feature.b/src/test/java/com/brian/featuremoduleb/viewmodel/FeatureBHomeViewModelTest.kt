package com.brian.featuremoduleb.viewmodel

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.Observer
import com.brian.core.viewmodel.Resource
import com.brian.featuremoduleb.model.FeatureBQuote
import com.brian.featuremoduleb.repository.FeatureBQuoteRepository
import io.mockk.coEvery
import io.mockk.mockk
import io.mockk.verify
import org.junit.Assert
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class FeatureBHomeViewModelTest {
    private lateinit var featureBQuoteRepository: FeatureBQuoteRepository
    private lateinit var featureBHomeViewModel: FeatureBHomeViewModel

    @get:Rule
    val rule = InstantTaskExecutorRule()

    @Before
    fun setUp() {
        featureBQuoteRepository = mockk()
    }

    @Test
    fun `getQuoteRandom when success`() {
        val observer = mockk<Observer<List<FeatureBQuote>>>()
        val result = listOf(FeatureBQuote("quoteText", "quoteAuthor"))
        coEvery { featureBQuoteRepository.getQuoteRandom() } returns Resource.Success(result)

        featureBHomeViewModel = FeatureBHomeViewModel(featureBQuoteRepository)
        featureBHomeViewModel.quote.observeForever(observer)
        featureBHomeViewModel.getQuoteRandom()

        verify {
            observer.onChanged(result)
        }

        Assert.assertEquals("quoteAuthor", featureBHomeViewModel.quote.value?.first()?.quoteAuthor)
    }

    @Test
    fun `getQuoteRandom when error`() {
        val observer = mockk<Observer<Event<String>>>()
        coEvery { featureBQuoteRepository.getQuoteRandom() } returns Resource.Error(Throwable("err"))

        featureBHomeViewModel = FeatureBHomeViewModel(featureBQuoteRepository)
        featureBHomeViewModel.errorEvent.observeForever(observer)
        featureBHomeViewModel.getQuoteRandom()

        verify {
            observer.onChanged(any())
        }

        Assert.assertEquals("err", featureBHomeViewModel.errorEvent.value?.getContentIfNotHandled())
    }
}
