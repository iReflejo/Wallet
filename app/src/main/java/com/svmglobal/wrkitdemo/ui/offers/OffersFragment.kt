package com.svmglobal.wrkitdemo.ui.offers

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.svmglobal.wrkitdemo.R

class OffersFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.fragment_offers, container, false)

        if (root.findViewById<View>(R.id.fragment_container) != null && savedInstanceState == null) {
            fragmentManager!!.beginTransaction()
                .add(R.id.fragment_container, OffersListFragment())
                .commit()
        }

        return root
    }
}

