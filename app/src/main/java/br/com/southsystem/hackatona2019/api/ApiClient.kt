package br.com.southsystem.hackatona2019.api

import org.jetbrains.annotations.Contract
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


object ApiClient {
    private val API_URL_BASE = "https://hackatona-desastres.herokuapp.com/v1/"

    private val requestClient by lazy {
        client.create(br.com.southsystem.hackatona2019.api.Contract::class.java)
    }

    private val client: Retrofit = Retrofit.Builder().let {
        it.baseUrl(API_URL_BASE)
        it.addConverterFactory(GsonConverterFactory.create())
        it.build()
    }

    fun getDados(connectionListener: ConnectionListener<MutableList<Data>>) {
        requestClient.getDados().enqueue(object : Callback<MutableList<Data>> {
            override fun onFailure(call: Call<MutableList<Data>>, t: Throwable) {
                connectionListener.fail("Erro de conexão")
            }

            override fun onResponse(
                call: Call<MutableList<Data>>,
                response: Response<MutableList<Data>>
            ) {
                if (response.isSuccessful) {
                    connectionListener.success(response.body()!!)
                } else {
                    connectionListener.fail(response.message())
                }
            }
        })
    }
}