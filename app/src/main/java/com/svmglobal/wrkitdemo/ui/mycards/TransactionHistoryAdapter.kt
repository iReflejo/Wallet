package com.svmglobal.wrkitdemo.ui.mycards

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.svmglobal.wrkitdemo.R
import com.svmglobal.wrkitdemo.databinding.TransactionHistoryRowItemBinding
import com.svmglobal.wrkitdemo.models.Transaction

class TransactionHistoryAdapter(
    private val dataset: Array<Transaction>
) :
    RecyclerView.Adapter<TransactionHistoryAdapter.TransactionHistoryViewHolder>() {

    inner class TransactionHistoryViewHolder(private val binding: TransactionHistoryRowItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun setTransaction(transaction: Transaction) {
            binding.viewModel = transaction
        }
    }

    // Create new views (invoked by the layout manager)
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): TransactionHistoryViewHolder {
        val itemBinding = DataBindingUtil.inflate<TransactionHistoryRowItemBinding>(
            LayoutInflater.from(parent.context),
            R.layout.transaction_history_row_item,
            parent,
            false
        )
        return TransactionHistoryViewHolder(itemBinding)
    }

    // Replace the contents of a view (invoked by the layout manager)
    override fun onBindViewHolder(holder: TransactionHistoryViewHolder, position: Int) {
        val card = dataset[position]
        holder.setTransaction(card)
    }

    override fun getItemCount() = dataset.size
}