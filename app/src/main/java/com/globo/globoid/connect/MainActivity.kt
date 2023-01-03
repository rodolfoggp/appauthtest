package com.globo.globoid.connect

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.globo.globoid.connect.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val service get() = GloboIDService(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        setupLayout()
    }

    private fun setupLayout() {
        binding.button.setOnClickListener {
            service.authorize()
        }
    }
}