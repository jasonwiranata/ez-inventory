package com.b21cap0380.ezinventory.ui.productionlist

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import com.b21cap0380.ezProduction.ui.productionlist.ProductionListAdapter
import com.b21cap0380.ezinventory.databinding.ActivityProductionListBinding
import com.b21cap0380.ezinventorymanagement.data.ProductionData
import com.google.firebase.database.*

class ProductionListActivity : AppCompatActivity() {
    private var _binding: ActivityProductionListBinding? = null
    private val binding get() = _binding!!
    private lateinit var database : FirebaseDatabase
    private lateinit var myRef : DatabaseReference
    private lateinit var productionList : ArrayList<ProductionData>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityProductionListBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.rvProductionList.layoutManager = LinearLayoutManager(this)
        binding.rvProductionList.setHasFixedSize(true)
        productionList = arrayListOf<ProductionData>()
        getProductionData()
    }

    private fun getProductionData() {
        database = FirebaseDatabase.getInstance()
        myRef = database.getReference("production")
        myRef.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                if(snapshot.exists()){
                    for(productionSnapshot in snapshot.children){
                        val production = productionSnapshot.getValue(ProductionData::class.java)
                        productionList.add(production!!)
                    }
                    binding.rvProductionList.adapter = ProductionListAdapter(productionList)
                }
            }
            override fun onCancelled(error: DatabaseError) {
                Log.d("Inventory View", "$error")
            }

        })
    }
}