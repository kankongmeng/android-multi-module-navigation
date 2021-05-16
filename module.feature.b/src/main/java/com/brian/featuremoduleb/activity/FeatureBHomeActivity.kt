package com.brian.featuremoduleb.activity

import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.Observer
import com.brian.core.activity.BaseActivity
import com.brian.featuremoduleb.R
import com.brian.featuremoduleb.module.injectFeaturesB
import com.brian.featuremoduleb.route.FeatureBRoute
import com.brian.featuremoduleb.viewmodel.FeatureBHomeViewModel
import kotlinx.android.synthetic.main.feature_b_activity_home.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class FeatureBHomeActivity : BaseActivity<FeatureBHomeViewModel>() {
    override val viewModel: FeatureBHomeViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        injectFeaturesB()
        super.onCreate(savedInstanceState)
        setContentView(R.layout.feature_b_activity_home)

        tvDesc.text =
            intent.getStringExtra(FeatureBRoute.INTENT_EXTRA_DATA_STRING_B) ?: "No Intent Data"

        initObserver()
        viewModel.getQuoteRandom()
    }

    private fun initObserver() {
        viewModel.quote.observe(this, Observer {
            if (it.isNotEmpty()) tvQuote.text = it[0].quoteText
        })
        viewModel.errorEvent.observe(this, Observer { showError ->
            Toast.makeText(this, showError.getContentIfNotHandled(), Toast.LENGTH_SHORT).show()
        })
    }
}
