package com.svmglobal.wrkitdemo.ui.offers

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import com.svmglobal.wrkitdemo.R
import com.svmglobal.wrkitdemo.databinding.OfferDetailsFragmentBinding

class OfferDetailsFragment : Fragment() {
    private lateinit var viewModel: OffersViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel =
            ViewModelProviders.of(activity!!)
                .get(OffersViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = DataBindingUtil.inflate<OfferDetailsFragmentBinding>(
            inflater,
            R.layout.offer_details_fragment,
            container,
            false
        )
        binding.viewModel = OfferDetailsViewModel(viewModel.selected.value!!)
        return binding.root
    }
}