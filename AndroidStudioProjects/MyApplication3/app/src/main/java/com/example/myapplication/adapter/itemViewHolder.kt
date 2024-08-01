package com.example.myapplication.adapter

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.R

class itemViewHolder(view:View) : RecyclerView.ViewHolder(view) {

    val tituloText : TextView = view.findViewById(R.id.edit_titulo)
    val descricaoText : TextView = view.findViewById(R.id.edit_descricao)
    val valorText : TextView = view.findViewById(R.id.edit_valor)




}