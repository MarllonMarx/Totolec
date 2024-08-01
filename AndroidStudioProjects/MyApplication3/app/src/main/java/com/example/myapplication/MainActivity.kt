package com.example.myapplication

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.myapplication.database.DBHelper
import com.example.myapplication.databinding.ActivityMainBinding
import com.example.myapplication.databinding.CustomToast1Binding
import com.example.myapplication.databinding.CusttomToastBinding
import com.google.android.material.materialswitch.MaterialSwitch

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var custtomToastBinding: CusttomToastBinding
    private  lateinit var customToast1Binding: CustomToast1Binding
    private  lateinit var sharedPrefeUser:SharedPreferences
    private lateinit var editSharedPreferences: SharedPreferences.Editor
    private lateinit var editSharedPreferences1: SharedPreferences.Editor
    private  lateinit var switchPref: SharedPreferences
    private lateinit var editswitchPref: SharedPreferences.Editor

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        custtomToastBinding = CusttomToastBinding.inflate(layoutInflater)
        customToast1Binding = CustomToast1Binding.inflate(layoutInflater)
        setContentView(binding.root)


        val db = DBHelper(this)
         var validar = false

        //Configurar o arquivo sharedpreferences para gravação de emial e senha
        // não esquecer de colocar mode em password

        sharedPrefeUser= getSharedPreferences(getString(R.string.user), Context.MODE_PRIVATE)
        switchPref = getSharedPreferences("login_remember",Context.MODE_PRIVATE)

        if (switchPref.getBoolean("login_remember",false)){

            binding.email.setText(sharedPrefeUser.getString(getString(R.string.user),""))
            binding.senha.setText(sharedPrefeUser.getString(getString(R.string.password),""))
            binding.switchPref.isChecked = true
        }


        var email: String
        var pass: String
        var remember: MaterialSwitch = binding.switchPref
        var toast = Toast(applicationContext).apply {
            duration = Toast.LENGTH_SHORT
            view = custtomToastBinding.root
        }

        var toast1 = Toast(applicationContext).apply {
            duration = Toast.LENGTH_SHORT
            view = customToast1Binding.root
        }




        binding.buttonEntrar.setOnClickListener {
            email = binding.email.text.toString().trim()
            pass = binding.senha.text.toString().trim()

            if (!pass.equals("") && email.equals("")) {
                binding.editSenha.error = null
            }

            if (email.equals("")) {
                binding.editEmail.error = "Campo Obrigatório"
            } else if (pass.equals("")) {
                binding.editEmail.error = null
                binding.editSenha.error = "Campo Obrigatório"


            } else {
                binding.editEmail.error = null
                binding.editSenha.error = null


                validar = db.validarLogin(email, pass)

                if (validar) {
                    editSharedPreferences = sharedPrefeUser.edit()
                    editSharedPreferences.putString(getString(R.string.user), email)
                    editSharedPreferences.apply()


                    editSharedPreferences1 = sharedPrefeUser.edit()
                    editSharedPreferences1.putString(getString(R.string.password), pass)
                    editSharedPreferences1.apply()

                    editswitchPref = switchPref.edit()
                    editswitchPref.putBoolean("login_remember", remember.isChecked)
                    editswitchPref.apply()

                    startActivity(Intent(this, MainHome::class.java))
                    toast1.show()

                } else {
                    Toast.makeText(
                        applicationContext,
                        "Usuário ou Senha Inválidos", Toast.LENGTH_SHORT).show()

                }

            }

        }

        binding.buttonCadastro.setOnClickListener {
            startActivity(Intent(this, MainCadastro::class.java))
        }


    }
}