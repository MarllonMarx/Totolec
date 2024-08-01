package com.example.myapplication.entities

class Aposta {

    var id: Int = 0
    var titulo: String = ""
    var descricao: String = ""
    var valor: Double = 0.0
    var formaPagamento: String = ""


    constructor()

    constructor(_id:Int,_titulo:String, _descricao: String, _valor: Double,_formaPagamento: String){
        this.id = _id
        this.titulo = _titulo
        this.descricao = _descricao
        this.valor = _valor
        this.formaPagamento = _formaPagamento

    }
}