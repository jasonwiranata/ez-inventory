package com.b21cap0380.ezinventory.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import com.b21cap0380.ezinventory.databinding.ActivitySplashScreenBinding

class SplashScreenActivity : AppCompatActivity() {
    private val splashTime:Long = 2500
    private var _binding: ActivitySplashScreenBinding? = null
    private val binding get() = _binding!!
    private lateinit var handler: Handler
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivitySplashScreenBinding.inflate(layoutInflater)
        setContentView(binding.root)
        handler = Handler(mainLooper)
        handler.postDelayed({
            val intent = Intent(this, HomeActivity::class.java)
            startActivity(intent)
            finish()
        }, splashTime)
    }
}