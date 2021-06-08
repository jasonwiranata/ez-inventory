package com.b21cap0380.ezinventory.ui.transaction

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import com.b21cap0380.ezinventory.databinding.ActivityTransactionBinding
import com.b21cap0380.ezinventorymanagement.data.TransactionData
import com.google.firebase.database.*

class TransactionActivity : AppCompatActivity() {
    private var _binding: ActivityTransactionBinding? = null
    private val binding get() = _binding!!
    private lateinit var database : FirebaseDatabase
    private lateinit var myRef : DatabaseReference
    private lateinit var TransactionList : ArrayList<TransactionData>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityTransactionBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.rvTransaction.layoutManager = LinearLayoutManager(this)
        binding.rvTransaction.setHasFixedSize(true)
        TransactionList = arrayListOf<TransactionData>()
        getTransactionData()
    }

    private fun getTransactionData() {
        database = FirebaseDatabase.getInstance()
        myRef = database.getReference("transaction")
        myRef.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                if(snapshot.exists()){
                    for(TransactionSnapshot in snapshot.children){
                        val Transaction = TransactionSnapshot.getValue(TransactionData::class.java)
                        TransactionList.add(Transaction!!)
                    }
                    binding.rvTransaction.adapter = TransactionAdapter(TransactionList)
                }
            }

            override fun onCancelled(error: DatabaseError) {
                Log.d("Transaction View", "$error")
            }

        })
    }
}