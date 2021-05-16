package com.brian.featuremoduleb.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.brian.core.viewmodel.BaseViewModel
import com.brian.featuremoduleb.model.FeatureBQuote
import com.brian.featuremoduleb.repository.FeatureBQuoteRepository
import com.brian.core.viewmodel.Resource

class FeatureBHomeViewModel(private val quoteRepository: FeatureBQuoteRepository) : BaseViewModel() {
    private val _quote = MutableLiveData<List<FeatureBQuote>>()
    val quote: LiveData<List<FeatureBQuote>> get() = _quote

    private val _errorEvent = MutableLiveData<Event<String>>()
    val errorEvent: LiveData<Event<String>> get() = _errorEvent

    fun getQuoteRandom() {
        onIO {
            when (val result = quoteRepository.getQuoteRandom()) {
                is Resource.Success -> _quote.postValue(result.data)
                is Resource.Error -> result.exception.message?.let {
                    _errorEvent.postValue(Event(it))
                }
            }
        }
    }
}
