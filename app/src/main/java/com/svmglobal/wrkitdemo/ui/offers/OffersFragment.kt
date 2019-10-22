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

class OffersFragment : Fragment() {

    private lateinit var offersViewModel: OffersViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        offersViewModel =
            ViewModelProviders.of(this).get(OffersViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_offers, container, false)

        val viewManager = LinearLayoutManager(this.context)
        val viewAdapter = OffersAdapter(InternalApiClient.getAllImages(), offersViewModel)

        root.findViewById<RecyclerView>(R.id.offers_view).apply {
            setHasFixedSize(true)
            layoutManager = viewManager
            adapter = viewAdapter
        }

        return root
    }
}