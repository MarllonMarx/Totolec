package com.example.myapplication.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.R
import com.example.myapplication.entities.Aposta

class ItemAdapter(val items: List<Aposta>) : RecyclerView.Adapter<itemViewHolder>(){


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): itemViewHolder {
       val view = LayoutInflater.from(parent.context).inflate(R.layout.activity_item_aposta,parent,false)

        return  itemViewHolder(view)
    }


    override fun getItemCount(): Int {
       return  items.size
    }

    override fun onBindViewHolder(holder: itemViewHolder, position: Int) {

        holder.tituloText.text = items[position].titulo
        holder.descricaoText.text = items[position].descricao
        holder.valorText.text = "R$ " + items[position].valor.toString()
    }
}