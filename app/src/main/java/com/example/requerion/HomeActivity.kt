package com.example.requerion

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.example.requerion.databinding.ActivityHomeBinding

class HomeActivity : AppCompatActivity() {
    private lateinit var binding: ActivityHomeBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        fun handleClickLogOut() {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        fun handleClickAboutActivity(){
            val intent = Intent(this, AboutActivity::class.java)
            startActivity(intent)
        }

        fun handleClickRequerimentsActivity(){
            val intent = Intent(this, RequerimentsActivity::class.java)
            startActivity(intent)
        }

        val numberSusUser = intent.getStringExtra("numeroSUS")
        val nameUser = "Admin"

        val textViewNameUser = binding.nameUser
        textViewNameUser.text = "${textViewNameUser.text} $nameUser"

        val textViewNumberSUS = binding.numberSUS
        textViewNumberSUS.text = "SUS: $numberSusUser"


        binding.cardLogOut.setOnClickListener{
            handleClickLogOut()
        }

        binding.cardAbout.setOnClickListener{
            handleClickAboutActivity()
        }

        binding.cardReq.setOnClickListener{
            handleClickRequerimentsActivity()
        }

    }
}