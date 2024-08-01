package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.RadioButton
import com.example.myapplication.database.DBHelper
import com.example.myapplication.databinding.ActivityMainHomeBinding
import com.google.android.material.snackbar.Snackbar

class MainHome : AppCompatActivity() {

    private  lateinit var binding: ActivityMainHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)


       val  db = DBHelper(this)



        binding.buttonApostar.setOnClickListener {

            var titulo = binding.editTitulo.text.toString()
           var  descricao = binding.editDescricao.text.toString()
           var valor = binding.editValor.text.toString()
           var  formapagamento:String = ""

           binding.radio.setOnCheckedChangeListener { group, checkedId ->

               val radio : RadioButton = findViewById(checkedId)

               formapagamento = radio.text.toString()
           }
            db.apostar(titulo,descricao,valor.toDouble(),formapagamento)

            Snackbar.make(binding.root,"Aposta Efetuada com Sucesso!",Snackbar.LENGTH_SHORT).show()
        }

        binding.buttonListarapostas.setOnClickListener {
            startActivity(Intent(this,ListarApostar::class.java))
        }
    }
}