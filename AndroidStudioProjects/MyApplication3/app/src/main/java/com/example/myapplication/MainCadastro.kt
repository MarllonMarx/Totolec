package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.widget.doOnTextChanged
import com.example.myapplication.database.DBHelper
import com.example.myapplication.databinding.ActivityMainCadastroBinding
import com.google.android.material.snackbar.Snackbar

class MainCadastro : AppCompatActivity() {

    private lateinit var binding: ActivityMainCadastroBinding
    private  lateinit var editEmail: String
    private lateinit var editNome: String
    private lateinit var editSenha: String

    val db = DBHelper(this)


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainCadastroBinding.inflate(layoutInflater)
        setContentView(binding.root)



        binding.editSenha.doOnTextChanged() { text, start, count, after ->

            if (text!!.length < 8){
                binding.senha.error = "A senha deve ter no mínimo 8 caracteres"
            }else{
                binding.senha.error = null
            }
        }

        binding.buttonCadastrar.setOnClickListener {
            editEmail = binding.editEmail.text.toString().trim()
            editNome = binding.editNome.text.toString().trim()
            editSenha = binding.editSenha.text.toString().trim()

            if (editEmail.equals("")){
                binding.email.error = "Campo obrigatório!"
            }else{
                binding.email.error = null
            }

            if (editNome.equals("")){
                binding.name.error = "Campo obrigatório!"
            }else{
                binding.name.error = null
            }

            if (editSenha.equals("")){
                binding.senha.error = "Campo obrigatório!"
            }else{
                binding.senha.error = null
            }

            if(db.validarEmail(editEmail)){
                Snackbar.make(binding.root,"E-mail já Cadastrado",Snackbar.LENGTH_SHORT).show()
            }else{
                db.cadastrarUsuario(editNome,editEmail,editSenha)
                startActivity(Intent(this,MainActivity::class.java))
            }
        }

    }
}