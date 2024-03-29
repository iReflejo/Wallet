package com.svmglobal.wrkitdemo.ui.offers

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.svmglobal.wrkitdemo.R
import com.svmglobal.wrkitdemo.services.InternalApiClient

class OffersListFragment : Fragment() {
    private lateinit var viewModel: OffersViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewModel =
            ViewModelProviders.of(activity!!)
                .get(OffersViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_offer_list, container, false)

        val viewManager = LinearLayoutManager(this.context)
        val viewAdapter = OffersAdapter(
            InternalApiClient.getAllOffers(),
            viewModel
        )

        root.findViewById<RecyclerView>(R.id.offers_view)?.apply {
            setHasFixedSize(true)
            layoutManager = viewManager
            adapter = viewAdapter
        }

        return root
    }
}