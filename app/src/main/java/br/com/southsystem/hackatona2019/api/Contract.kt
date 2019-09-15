package br.com.southsystem.hackatona2019.api

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers

interface Contract {

    @GET("issues/")
    fun getDados(
    ): Call<MutableList<Data>>

}