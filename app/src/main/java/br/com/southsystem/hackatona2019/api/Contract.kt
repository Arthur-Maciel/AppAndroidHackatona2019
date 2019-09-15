package br.com.southsystem.hackatona2019.api

import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.PUT

interface Contract {

    @GET("issues/")
    fun getDados(
    ): Call<MutableList<Data>>

    @PUT("issues/:[id]")
    fun setDados(
    @Body request: Evento
    ): Call<Evento>

}