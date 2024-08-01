package com.example.myapplication.entities

class User {
    var email: String = ""
    var pass: String = ""

    constructor(_email: String,_pass: String){
        this.email = _email
        this.pass = _pass
    }

    constructor()

    fun get_email(): String{
        return  email
    }

    fun  get_pass(): String{
        return pass
    }
}