package com.example.requerion

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.requerion.databinding.ActivityAboutBinding
import com.example.requerion.databinding.ActivityHomeBinding

class AboutActivity : AppCompatActivity() {
    private lateinit var binding: ActivityAboutBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_about)
        binding = ActivityAboutBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}