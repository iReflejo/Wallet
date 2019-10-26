package com.svmglobal.wrkitdemo.ui.mycards

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.svmglobal.wrkitdemo.R
import com.svmglobal.wrkitdemo.databinding.MyCardRowItemBinding
import com.svmglobal.wrkitdemo.models.Card

class MyCardsAdapter(
    private val dataset: Array<Card>,
    private val viewModel: MyCardsViewModel
) :
    RecyclerView.Adapter<MyCardsAdapter.MyCardsViewHolder>() {

    inner class MyCardsViewHolder(private val binding: MyCardRowItemBinding) :
        RecyclerView.ViewHolder(binding.root),
        View.OnClickListener {

        init {
            binding.root.setOnClickListener(this)
        }

        fun setCard(card: Card) {
            binding.viewModel = card
        }

        override fun onClick(view: View) {
            viewModel.select(binding.viewModel!!)
            val action = MyCardsFragmentDirections.actionNavigationCardsToMyCardDetailsFragment()
            view.findNavController().navigate(action)
        }
    }

    // Create new views (invoked by the layout manager)
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): MyCardsViewHolder {
        val itemBinding = DataBindingUtil.inflate<MyCardRowItemBinding>(
            LayoutInflater.from(parent.context),
            R.layout.my_card_row_item,
            parent,
            false
        )
        return MyCardsViewHolder(itemBinding)
    }

    // Replace the contents of a view (invoked by the layout manager)
    override fun onBindViewHolder(holder: MyCardsViewHolder, position: Int) {
        val card = dataset[position]
        holder.setCard(card)
    }

    override fun getItemCount() = dataset.size
}