package com.example.requerion

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import android.view.View
import android.widget.Button
import com.google.firebase.database.*

class RequerimentsActivity : AppCompatActivity() {
    private lateinit var reqRecyclerView: RecyclerView
    private lateinit var reqList: ArrayList<RequerimentsModelo>
    private lateinit var dbRef: DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_requeriments2)

        reqRecyclerView = findViewById(R.id.reqList)
        reqRecyclerView.layoutManager = LinearLayoutManager(this)
        reqRecyclerView.setHasFixedSize(true)

        reqList = arrayListOf<RequerimentsModelo>()

        getEmployeesData()

        val buttonCadastrar: Button = findViewById(R.id.btCadastar)

        buttonCadastrar.setOnClickListener{
            val intent = Intent(this, RegisterRequerimentsActivity::class.java)
          startActivity(intent)
         }

    }
    private fun getEmployeesData() {

        reqRecyclerView.visibility = View.GONE

        dbRef = FirebaseDatabase.getInstance().getReference("Requerimento")

        dbRef.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                reqList.clear()
                if (snapshot.exists()){
                    for (empSnap in snapshot.children){
                        val reqData = empSnap.getValue(RequerimentsModelo::class.java)
                        reqList.add(reqData!!)
                    }

                    val mAdapter = RequerimentsAdapter(reqList)
                    reqRecyclerView.adapter = mAdapter

                    reqRecyclerView.visibility = View.VISIBLE

                }
            }

            override fun onCancelled(error: DatabaseError) {
                TODO("Not yet implemented")
            }
        })
    }
}