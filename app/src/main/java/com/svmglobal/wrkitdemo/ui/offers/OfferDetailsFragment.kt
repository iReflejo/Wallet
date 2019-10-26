package com.svmglobal.wrkitdemo.ui.offers

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import com.squareup.picasso.Picasso
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

        val paymentMethodContainer =
            binding.root.findViewById<LinearLayout>(R.id.payment_methods_container)

        viewModel.selected.value!!.paymentMethods.withIndex().forEach { (i, paymentMethod) ->
            val imageView = ImageView(binding.root.context)
            paymentMethodContainer.addView(imageView, i)

            imageView.layoutParams.height = ViewGroup.LayoutParams.WRAP_CONTENT
            imageView.layoutParams.width = ViewGroup.LayoutParams.WRAP_CONTENT
            imageView.maxHeight = 100
            imageView.adjustViewBounds = true
            imageView.setPadding(15, 0, 15, 0)
            imageView.scaleType = ImageView.ScaleType.FIT_CENTER

            Picasso.get().load(paymentMethod.logoUrl).into(imageView)
        }
        return binding.root
    }
}