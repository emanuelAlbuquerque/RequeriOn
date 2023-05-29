package com.example.requerion

import RequerimentsModelo
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.recyclerview.widget.RecyclerView
import java.util.ArrayList

class ReqAdapter(private val reqList: ArrayList<RequerimentsModelo>) :
    RecyclerView.Adapter<ReqAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.requeriments_list_item, parent, false)
        return ViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val currentReq = reqList[position]
        holder.tvSUS.text = currentReq.reqSUS
        holder.tvReq.text = currentReq.reqNumero
        holder.tvEspecialidade.text = currentReq.reqEspecialidade
        holder.tvData.text = currentReq.reqData
    }

    override fun getItemCount(): Int {
        return empList.size
    }


    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tvSUS : TextView = itemView.findViewById(R.id.TvSUS)
        val tvReq : TextView = itemView.findViewById(R.id.TvReq)
        val tvEspecialidade : TextView = itemView.findViewById(R.id.TvEspecialidade)
        val tvData : TextView = itemView.findViewById(R.id.TvData)
    }
}