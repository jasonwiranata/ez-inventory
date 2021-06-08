package com.b21cap0380.ezinventory.ui.inventory

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import com.b21cap0380.ezinventory.data.InventoryData
import com.b21cap0380.ezinventory.databinding.ActivityInventoryBinding
import com.google.firebase.database.*

class InventoryActivity : AppCompatActivity() {
    private var _binding: ActivityInventoryBinding? = null
    private val binding get() = _binding!!
    private lateinit var database : FirebaseDatabase
    private lateinit var myRef : DatabaseReference
    private lateinit var inventoryList : ArrayList<InventoryData>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityInventoryBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.rvInventory.layoutManager = LinearLayoutManager(this)
        binding.rvInventory.setHasFixedSize(true)
        inventoryList = arrayListOf<InventoryData>()
        getInventoryData()
    }

    private fun getInventoryData() {
        database = FirebaseDatabase.getInstance()
        myRef = database.getReference("inventory")
        myRef.addValueEventListener(object : ValueEventListener{
            override fun onDataChange(snapshot: DataSnapshot) {
                if(snapshot.exists()){
                    for(inventorySnapshot in snapshot.children){
                        val inventory = inventorySnapshot.getValue(InventoryData::class.java)
                        inventoryList.add(inventory!!)
                    }
                    binding.rvInventory.adapter = InventoryAdapter(inventoryList)
                }
            }

            override fun onCancelled(error: DatabaseError) {
                Log.d("Inventory View", "$error")
            }

        })
    }
}