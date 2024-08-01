package com.example.myapplication

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.adapter.ItemAdapter
import com.example.myapplication.database.DBHelper
import com.example.myapplication.databinding.ActivityListarApostarBinding
import com.example.myapplication.entities.Aposta

class ListarApostar : AppCompatActivity() {

    private lateinit var binding: ActivityListarApostarBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityListarApostarBinding.inflate(layoutInflater)
        enableEdgeToEdge()
        setContentView(binding.root)



        val db = DBHelper(this)
        val recyclerView: RecyclerView = binding.recy
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = ItemAdapter(db.listarApostas())





        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}