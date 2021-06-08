package com.b21cap0380.ezinventory.ui.inventory

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.b21cap0380.ezinventory.data.InventoryData
import com.b21cap0380.ezinventory.databinding.InventoryItemBinding

class InventoryAdapter(private val inventoryList : ArrayList<InventoryData>) : RecyclerView.Adapter<InventoryAdapter.ViewHolder>() {
    inner class ViewHolder(val binding: InventoryItemBinding):RecyclerView.ViewHolder(binding.root){
        fun bind(inventory: InventoryData){
            with(binding){
                tvProductId.text = inventory.productId
                tvProductName.text = inventory.productName
                tvProductQty.text = inventory.productQty.toString()
                tvProductUnit.text = inventory.productUnit
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = InventoryItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(inventoryList[position])
    }

    override fun getItemCount(): Int = inventoryList.size
}