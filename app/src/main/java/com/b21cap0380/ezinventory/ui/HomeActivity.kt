package com.b21cap0380.ezinventory.ui

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.b21cap0380.ezinventory.databinding.ActivityHomeBinding
import com.b21cap0380.ezinventory.ui.inventory.InventoryActivity
import com.b21cap0380.ezinventory.ui.production.ProductionActivity
import com.b21cap0380.ezinventory.ui.productionlist.ProductionListActivity
import com.b21cap0380.ezinventory.ui.sales.SalesActivity
import com.b21cap0380.ezinventory.ui.transaction.TransactionActivity
import com.google.firebase.database.FirebaseDatabase


class HomeActivity : AppCompatActivity() {
    private var _binding: ActivityHomeBinding? = null
    private val binding get() = _binding!!
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.productionBtn.setOnClickListener {
            val intent1 = Intent(this@HomeActivity, ProductionActivity::class.java)
            startActivity(intent1)
        }

        binding.salesBtn.setOnClickListener {
            val intent2 = Intent(this@HomeActivity, SalesActivity::class.java)
            startActivity(intent2)
        }

        binding.inventoryBtn.setOnClickListener {
            val intent3 = Intent(this@HomeActivity, InventoryActivity::class.java)
            startActivity(intent3)
        }

        binding.transactionBtn.setOnClickListener{
            val intent4 = Intent(this@HomeActivity, TransactionActivity::class.java)
            startActivity(intent4)
        }

        binding.productionListBtn.setOnClickListener{
            val intent5 = Intent(this@HomeActivity, ProductionListActivity::class.java)
            startActivity(intent5)
        }
    }
}