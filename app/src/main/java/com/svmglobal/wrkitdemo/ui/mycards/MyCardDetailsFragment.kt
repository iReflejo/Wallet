package com.svmglobal.wrkitdemo.ui.mycards

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.svmglobal.wrkitdemo.R
import com.svmglobal.wrkitdemo.databinding.MyCardDetailsFragmentBinding

class MyCardDetailsFragment : Fragment() {
    private lateinit var viewModel: MyCardsViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel =
            ViewModelProviders.of(activity!!)
                .get(MyCardsViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = DataBindingUtil.inflate<MyCardDetailsFragmentBinding>(
            inflater,
            R.layout.my_card_details_fragment,
            container,
            false
        )
        binding.viewModel = MyCardDetailsViewModel(viewModel.selected.value!!)
        val viewManager = LinearLayoutManager(this.context)

        val viewAdapter = TransactionHistoryAdapter(
            viewModel.selected.value!!.transactions
        )

        binding.root.findViewById<RecyclerView>(R.id.transaction_history)?.apply {
            setHasFixedSize(true)
            layoutManager = viewManager
            adapter = viewAdapter
        }

        return binding.root
    }
}