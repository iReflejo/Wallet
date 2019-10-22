package com.svmglobal.wrkitdemo.ui.offers

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.svmglobal.wrkitdemo.R
import com.svmglobal.wrkitdemo.databinding.ActivityOfferDetailsBinding
import com.svmglobal.wrkitdemo.models.Offer

class OfferDetailsActivity : AppCompatActivity() {
    private lateinit var binding: ActivityOfferDetailsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_offer_details)
        binding.viewModel = intent.extras!!["offer"] as Offer
    }
}
