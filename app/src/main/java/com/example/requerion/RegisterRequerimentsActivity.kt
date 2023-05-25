package com.example.requerion

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.requerion.databinding.ActivityMainBinding
import com.example.requerion.databinding.ActivityRegisterRequerimentsBinding

class RegisterRequerimentsActivity : AppCompatActivity() {
    private lateinit var binding : ActivityRegisterRequerimentsBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegisterRequerimentsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val btnCadastar = binding.btnCadastrar

        fun onClickCadastrar(){
            val inputSus = binding.edSus
            val inputNumberReq = binding.edNumberReq
            val especialidadeReq = binding.edEspecialidadeReq
            val dataReq = binding.edDataReq

            if(inputSus.isDone && inputNumberReq.isDone && dataReq.isDone){
                val intent = Intent(this, RequerimentsActivity::class.java)
                intent.putExtra("numeroSUS", inputSus.masked)
                intent.putExtra("numberReq", inputNumberReq.masked)
                intent.putExtra("especialidadeReq", especialidadeReq.text.toString())
                intent.putExtra("dataReq", dataReq.masked)

                startActivity(intent)
            }else{
                Toast.makeText(this, R.string.msgInputIncorrect, Toast.LENGTH_SHORT).show()
            }
        }

        btnCadastar.setOnClickListener{
            onClickCadastrar()
        }


    }
}