package com.example.requerion

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.requerion.databinding.ActivityMainBinding
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase

class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val btLogin = binding.btnLogin

        fun onCLickLogin(){
            val inputNumberSus = binding.edSus
            val inputCpf = binding.edCpf

            val numberIsDone = binding.edSus.isDone
            val cpfIsDone = binding.edCpf.isDone

            val userMokado = UserModelo("Admin", "000000000000000", "00000000000")

            if(numberIsDone && cpfIsDone){
                if(inputNumberSus.unMasked == userMokado.userSUS && inputCpf.unMasked == userMokado.userCPF){
                    val intentHome = Intent(this, HomeActivity::class.java)
                    intentHome.putExtra("numeroSUS", inputNumberSus.masked)

                    inputNumberSus.setText("")
                    inputCpf.setText("")

                    startActivity(intentHome)
                }else{
                    Toast.makeText(this, R.string.msgIncorrectLogin, Toast.LENGTH_SHORT).show()
                }
            }else{
                Toast.makeText(this, R.string.msgInputIncorrect, Toast.LENGTH_SHORT).show()
            }
        }

        btLogin.setOnClickListener {
            onCLickLogin()
        }
    }
}