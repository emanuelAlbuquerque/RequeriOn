package com.example.requerion

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.requerion.databinding.ActivityMainBinding

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

            val susMokado = "000000000001111"
            val cpfMokado = "11382391439"

            if(numberIsDone && cpfIsDone){
                if(inputNumberSus.unMasked == susMokado && inputCpf.unMasked == cpfMokado){
                    val intent = Intent(this, HomeActivity::class.java)
                    intent.putExtra("numeroSUS", inputNumberSus.masked)

                    inputNumberSus.setText("")
                    inputCpf.setText("")

                    startActivity(intent)
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