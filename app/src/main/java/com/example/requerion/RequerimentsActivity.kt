package com.example.requerion

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.requerion.databinding.ActivityMainBinding
import com.example.requerion.databinding.ActivityRequeriments2Binding

class RequerimentsActivity : AppCompatActivity() {
    private lateinit var binding : ActivityRequeriments2Binding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRequeriments2Binding.inflate(layoutInflater)
        setContentView(binding.root)

        val sus = binding.textViewSUS
        val number = binding.textViewNumberReq
        val espec = binding.textViewEspec
        val data = binding.textViewData

        sus.text = intent.getStringExtra("numeroSUS")
        number.text = intent.getStringExtra("numberReq")
        espec.text = intent.getStringExtra("especialidadeReq")
        data.text = intent.getStringExtra("dataReq")


        binding.btCadastar.setOnClickListener{
            val intent = Intent(this, RegisterRequerimentsActivity::class.java)
            startActivity(intent)
        }

    }
}