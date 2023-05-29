package com.example.requerion

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.requerion.databinding.ActivityRegisterRequerimentsBinding
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class RegisterRequerimentsActivity : AppCompatActivity() {
    private lateinit var binding : ActivityRegisterRequerimentsBinding
    private lateinit var dbRef: DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegisterRequerimentsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val btnCadastar = binding.btnCadastrar
        val edInputSus = binding.edSus
        val edInputNumberReq = binding.edNumberReq
        val edEspecialidadeReq = binding.edEspecialidadeReq
        val edDataReq = binding.edDataReq

        dbRef = FirebaseDatabase.getInstance().getReference("Requerimento")

        fun onClickCadastrar(){
            val sus = edInputSus.unMasked
            val numberReq = edInputNumberReq.unMasked
            val especialidade = edEspecialidadeReq.text.toString()
            val dataReq = edDataReq.masked

            if(sus.isEmpty()){
                edInputSus.error = "Por favor, insira corretamente o seu número do SUS"
                return
            }

            if(numberReq.isEmpty()){
                edInputNumberReq.error = "Por favor, insira o número do seu requerimento"
                return
            }

            if(especialidade.isEmpty()){
                edEspecialidadeReq.error = "Por favor, insira a especialidade do seu requerimento"
                return
            }

            if(dataReq.isEmpty()){
                edDataReq.error = "Por favor, insira a data que foi pedido o seu requerimento"
                return
            }

                val reqID = dbRef.push().key!!

                val requerimento = RequerimentsModelo(reqID, sus, numberReq, especialidade, dataReq)

                dbRef.child(reqID).setValue(requerimento).addOnCompleteListener{
                    Toast.makeText(this, "Cadastro realizado", Toast.LENGTH_SHORT).show()

                    edInputSus.text!!.clear()
                    edInputNumberReq.text!!.clear()
                    edEspecialidadeReq.text!!.clear()
                    edDataReq.text!!.clear()
                }.addOnFailureListener { err ->
                    Toast.makeText(this, "Error ${err.message}", Toast.LENGTH_SHORT).show()
                }
        }

        btnCadastar.setOnClickListener{
            onClickCadastrar()
        }


    }
}