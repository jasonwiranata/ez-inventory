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
        myRef = database.reference

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
        val productId = binding.tiProductId.text.toString()
        val productName = binding.tiProductName.text.toString()
        var productQty = Integer.parseInt(binding.tiProductQty.text.toString())
        val productUnit = binding.tiProductUnit.text.toString()
        val productionData = ProductionData(
            productionId,
            productionDate,
            materialName,
            materialUsed,
            materialUnit,
            productId,
            productName,
            productQty,
            productUnit
        )
        val inventoryData = InventoryData(productId, productName, productQty, productUnit)
        myRef.child("production").child(productionId).setValue(productionData)
            .addOnSuccessListener {
                Toast.makeText(this, "Production item successfully added", Toast.LENGTH_SHORT)
                    .show()
                Log.d("Production Add", "SUCCESS")
            }.addOnFailureListener {
            Log.d("Production Failure", "$it")
        }

        myRef.child("inventory").child(productId).child("productQty").get().addOnSuccessListener {
            if (it.exists()) {
                productQty += Integer.valueOf(it.getValue().toString())
                val inventoryData2 = InventoryData(productId, productName, productQty, productUnit)
                myRef.child("inventory").child(productId).setValue(inventoryData2)
                    .addOnSuccessListener {
                        Toast.makeText(this, "Inventory Updated", Toast.LENGTH_SHORT).show()
                        Log.d("Inventory Update", "SUCCESS")
                        clearFields()
                    }.addOnFailureListener {
                    Log.d("Inventory Update", "$it")
                }
            }else{
                myRef.child("inventory").child(productId).setValue(inventoryData).addOnSuccessListener {
                    Toast.makeText(this, "Inventory item successfully added", Toast.LENGTH_SHORT).show()
                    Log.d("Inventory Add", "SUCCESS")
                    clearFields()
                }.addOnFailureListener {
                    Log.d("Inventory Add", "$it")
                }
            }
        }
    }

    private fun clearFields(){
        binding.tiProductionId.setText("")
        binding.tiProductionDate.setText("")
        binding.tiMaterialName.setText("")
        binding.tiMaterialUsed.setText("")
        binding.tiMaterialUnit.setText("")
        binding.tiProductId.setText("")
        binding.tiProductName.setText("")
        binding.tiProductQty.setText("")
        binding.tiProductUnit.setText("")
    }
}
