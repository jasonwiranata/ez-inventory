package com.b21cap0380.ezinventory.ui.sales

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.b21cap0380.ezinventory.data.InventoryData
import com.b21cap0380.ezinventory.databinding.ActivitySalesBinding
import com.b21cap0380.ezinventorymanagement.data.TransactionData
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class SalesActivity : AppCompatActivity() {
    private lateinit var database: FirebaseDatabase
    private lateinit var myRef : DatabaseReference
    private var _binding: ActivitySalesBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivitySalesBinding.inflate(layoutInflater)
        setContentView(binding.root)
        database = FirebaseDatabase.getInstance()
        myRef = database.reference

        binding.submitSales.setOnClickListener {
            addTransaction()
        }
    }

    private fun addTransaction() {
        val TransactionId = binding.tiTransactionId.text.toString()
        val TransactionDate = binding.tiTransactionDate.text.toString()
        val productId = binding.tiProductId.text.toString()
        val productName = binding.tiProductName.text.toString()
        var productQty = Integer.parseInt(binding.tiProductSold.text.toString())
        val productUnit = binding.tiProductUnit.text.toString()
        val TransactionData = TransactionData(TransactionId, TransactionDate, productId, productName, productQty, productUnit)
        myRef.child("transaction").child(TransactionId).setValue(TransactionData).addOnSuccessListener {
            Toast.makeText(this, "Transaction item successfully added", Toast.LENGTH_SHORT).show()
            Log.d("Transaction Add", "SUCCESS")
        }.addOnFailureListener {
            Log.d("Transaction Failure", "$it")
        }
        myRef.child("inventory").child(productId).child("productQty").get().addOnSuccessListener {
            productQty = Integer.valueOf(it.getValue().toString()) - productQty
            val inventoryData = InventoryData(productId, productName, productQty, productUnit)
            myRef.child("inventory").child(productId).setValue(inventoryData).addOnSuccessListener {
                Toast.makeText(this, "Inventory item successfully updated", Toast.LENGTH_SHORT).show()
                Log.d("Inventory Update", "SUCCESS")
            }.addOnFailureListener {
                Log.d("Inventory Failure", "$it")
            }
        }.addOnFailureListener {
                myRef.child("transaction").child(TransactionId).removeValue()
                Toast.makeText(this, "Inventory item does not exist", Toast.LENGTH_SHORT).show()
                Log.d("Inventory Failure", "$it")
        }
        binding.tiTransactionId.setText("")
        binding.tiTransactionDate.setText("")
        binding.tiProductId.setText("")
        binding.tiProductName.setText("")
        binding.tiProductSold.setText("")
        binding.tiProductUnit.setText("")
        }
}