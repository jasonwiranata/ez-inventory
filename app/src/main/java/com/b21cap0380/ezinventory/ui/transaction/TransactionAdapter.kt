package com.b21cap0380.ezinventory.ui.transaction

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.b21cap0380.ezinventory.databinding.TransactionItemBinding
import com.b21cap0380.ezinventorymanagement.data.TransactionData

class TransactionAdapter(private val TransactionList : ArrayList<TransactionData>) : RecyclerView.Adapter<TransactionAdapter.ViewHolder>() {
    inner class ViewHolder(val binding: TransactionItemBinding): RecyclerView.ViewHolder(binding.root){
        fun bind(Transaction: TransactionData){
            with(binding){
                tvTransactionId.text = Transaction.transactionId
                tvTransactionDate.text = Transaction.transactionDate
                tvProductId.text = Transaction.productId
                tvProductName.text = Transaction.productName
                tvProductSold.text = Transaction.productSold.toString()
                tvProductUnit.text = Transaction.productUnit
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = TransactionItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(TransactionList[position])
    }

    override fun getItemCount(): Int = TransactionList.size
}