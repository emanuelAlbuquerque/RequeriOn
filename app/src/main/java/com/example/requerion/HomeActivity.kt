package com.example.requerion

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
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

        val nameUser = "José Emanuel da Silva Souza Albuquerque"
        val edNameUser = binding.nameUser
        edNameUser.text = "${edNameUser.text} $nameUser"

        val textViewNumberSUS = binding.numberSUS
        val numberSusUser = intent.getStringExtra("numeroSUS")
        textViewNumberSUS.text = "SUS: $numberSusUser"


        binding.cardLogOut.setOnClickListener{
            handleClickLogOut()
        }

        binding.cardAbout.setOnClickListener{
            handleClickAboutActivity()
        }

    }
}