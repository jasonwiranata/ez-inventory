package com.b21cap0380.ezProduction.ui.productionlist

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.b21cap0380.ezinventory.databinding.ProductionItemBinding
import com.b21cap0380.ezinventorymanagement.data.ProductionData


class ProductionListAdapter(private val productionList : ArrayList<ProductionData>) : RecyclerView.Adapter<ProductionListAdapter.ViewHolder>() {
    inner class ViewHolder(val binding: ProductionItemBinding): RecyclerView.ViewHolder(binding.root){
        fun bind(Production: ProductionData){
            with(binding){
                tvProductionId.text = Production.productionId
                tvProductionDate.text = Production.productionDate
                tvMaterialName.text = Production.materialName
                tvMaterialUsed.text = Production.materialUsed.toString()
                tvMaterialUnit.text = Production.materialUnit
                tvProductId.text = Production.productId
                tvProductName.text = Production.productName
                tvProductMade.text = Production.productMade.toString()
                tvProductUnit.text = Production.productUnit
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = ProductionItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(productionList[position])
    }

    override fun getItemCount(): Int = productionList.size
}