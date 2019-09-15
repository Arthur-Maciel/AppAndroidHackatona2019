package br.com.southsystem.hackatona2019

import android.os.AsyncTask

data class Area(
    val area : String,
    val latitude : Double,
    val longitude : Double,
    val raio : Int,
    val Status : Status
)