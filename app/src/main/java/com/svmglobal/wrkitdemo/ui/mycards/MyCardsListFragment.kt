package com.svmglobal.wrkitdemo.ui.mycards

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.chip.Chip
import com.svmglobal.wrkitdemo.R
import com.svmglobal.wrkitdemo.services.InternalApiClient

class MyCardsListFragment : Fragment() {
    private lateinit var viewModel: MyCardsViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewModel =
            ViewModelProviders.of(activity!!)
                .get(MyCardsViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_my_card_list, container, false)

        val viewManager = LinearLayoutManager(this.context)
        val viewAdapter = MyCardsAdapter(
            InternalApiClient.getAllCards(),
            viewModel
        )

        root.findViewById<RecyclerView>(R.id.my_cards_view)?.apply {
            setHasFixedSize(true)
            layoutManager = viewManager
            adapter = viewAdapter
        }

        val chip = root.findViewById<Chip>(R.id.add_new_card)
        chip.setOnClickListener {
            val action = MyCardsFragmentDirections.actionNavigationCardsToMyCardDetailsFragment()
            it.findNavController().navigate(action)
        }

        return root
    }


}