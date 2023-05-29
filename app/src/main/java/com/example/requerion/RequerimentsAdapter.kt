package com.example.requerion;

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import java.util.ArrayList

class RequerimentsAdapter(private val reqList: ArrayList<RequerimentsModelo>) :
    RecyclerView.Adapter<RequerimentsAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.requeriments_list_item, parent, false)
        return ViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val currentReq = reqList[position]
        holder.tvSUS.text = "SUS: ${currentReq.reqSUS}"
        holder.tvReq.text = "Número do requerimento: ${currentReq.reqNumero}"
        holder.tvEspecialidade.text = "Especialidade: ${currentReq.reqEspecialidade}"
        holder.tvData.text = "Data: ${currentReq.reqData}"
    }

    override fun getItemCount(): Int {
        return reqList.size
    }


    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tvSUS : TextView = itemView.findViewById(R.id.TvSUS)
        val tvReq : TextView = itemView.findViewById(R.id.TvReq)
        val tvEspecialidade : TextView = itemView.findViewById(R.id.TvEspecialidade)
        val tvData : TextView = itemView.findViewById(R.id.TvData)
    }
}