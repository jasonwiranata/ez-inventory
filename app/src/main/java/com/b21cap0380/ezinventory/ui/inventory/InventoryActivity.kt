package com.b21cap0380.ezinventory.ui.inventory

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.b21cap0380.ezinventory.databinding.ActivityInventoryBinding

class InventoryActivity : AppCompatActivity() {
    private var _binding: ActivityInventoryBinding? = null
    private val binding get() = _binding!!
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityInventoryBinding.inflate(layoutInflater)
        setContentView(binding.root)

    }
}