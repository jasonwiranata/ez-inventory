package com.b21cap0380.ezinventory.ui.production

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.b21cap0380.ezinventory.data.InventoryData
import com.b21cap0380.ezinventory.databinding.ActivityProductionBinding
import com.b21cap0380.ezinventorymanagement.data.ProductionData
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class ProductionActivity : AppCompatActivity() {
    private lateinit var database: FirebaseDatabase
    private lateinit var myRef : DatabaseReference
    private var _binding: ActivityProductionBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityProductionBinding.inflate(layoutInflater)
        setContentView(binding.root)
        database = FirebaseDatabase.getInstance()
        Log.d("Test1","OK")
        myRef = database.reference
        Log.d("Test2","OK")

        binding.submitProduction.setOnClickListener {
            addProduction()
        }
    }

    private fun addProduction() {
        val productionId = binding.tiProductionId.text.toString()
        val productionDate = binding.tiProductionDate.text.toString()
        val materialName = binding.tiMaterialName.text.toString()
        val materialUsed = Integer.parseInt(binding.tiMaterialUsed.text.toString())
        val materialUnit = binding.tiMaterialUnit.text.toString()
        val productionData = ProductionData(productionId, productionDate, materialName, materialUsed, materialUnit)
        val productId = binding.tiProductId.text.toString()
        val productName = binding.tiProductName.text.toString()
        var productQty = Integer.parseInt(binding.tiProductQty.text.toString())
        val productUnit = binding.tiProductUnit.text.toString()
        val inventoryData = InventoryData(productId, productName, productQty, productUnit)
        myRef.child("production").child(productionId).setValue(productionData).addOnSuccessListener {
            Log.d("Production Add", "SUCCESS")
        }.addOnFailureListener {
            Log.d("Production Failure", "$it")
        }
        myRef.child("inventory").child(productId).child("productQty").get().addOnSuccessListener {
            productQty += Integer.valueOf(it.getValue().toString())
            val inventoryData2 = InventoryData(productId, productName, productQty, productUnit)
            myRef.child("inventory").child(productId).setValue(inventoryData2).addOnSuccessListener {
                Log.d("Inventory Add", "SUCCESS")
            }.addOnFailureListener {
                Log.d("Inventory Failure", "$it")
            }
        }.addOnFailureListener {
            myRef.child("inventory").child(productId).setValue(inventoryData).addOnSuccessListener {
                Log.d("Inventory Add", "SUCCESS")
            }.addOnFailureListener {
                Log.d("Inventory Failure", "$it")
            }
            }
        }
    }