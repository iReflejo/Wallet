package com.svmglobal.wrkitdemo.ui.offers

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.svmglobal.wrkitdemo.databinding.OfferRowItemBinding
import com.svmglobal.wrkitdemo.models.Offer

class OffersAdapter(private val dataset: Array<Offer>) :
    RecyclerView.Adapter<OffersAdapter.OffersViewHolder>() {

    class OffersViewHolder(private val binding: OfferRowItemBinding) : RecyclerView.ViewHolder(binding.root),
        View.OnClickListener {

        init {
            binding.root.setOnClickListener(this)
        }

        fun setOffer(offer: Offer){
            binding.viewModel.select(offer)
        }

        override fun onClick(view: View) {
            val intent = Intent(view.context, OfferDetailsActivity::class.java)
            view.context.startActivity(intent)
        }
    }

    // Create new views (invoked by the layout manager)
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): OffersViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val itemBinding = OfferRowItemBinding.inflate(layoutInflater, parent, false)
        return OffersViewHolder(itemBinding)
    }

    // Replace the contents of a view (invoked by the layout manager)
    override fun onBindViewHolder(holder: OffersViewHolder, position: Int) {
        val offer = dataset[position]
        holder.setOffer(offer)
    }

    override fun getItemCount() = dataset.size
}