package br.com.southsystem.hackatona2019.api

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import java.io.Serializable

@JsonIgnoreProperties(
    "emergencia"
)

class Data : Serializable {
    val id: String?=null
    val area:String?=null
    val latitude:String?=null
    val longitude:String?=null
    val raio:Double?=null
    val historicos:ArrayList<String>?=null
    val comentarios:ArrayList<String>?=null
    val status:Status?=null
    val recursos:Recursos?=null
}

class Status:Serializable{
    val geografia: String?=null
    val situacao:String?=null
    val populacao:Int?=null
}

class Recursos:Serializable{
    val servicos_saude: String?=null
    val servicos_apoio:String?=null
    val posto_bomb: String?=null
    val area:String?=null
    val forn_agua: String?=null
    val telefonia:String?=null
    val internet: String?=null
    val saneamento:String?=null
    val acessibilidade:String?=null
}