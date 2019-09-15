package br.com.southsystem.hackatona2019

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import br.com.southsystem.hackatona2019.api.ApiClient
import br.com.southsystem.hackatona2019.api.ConnectionListener
import br.com.southsystem.hackatona2019.api.Data


class DadosViewModel : ViewModel() {

    val dadosLiveData = MutableLiveData<MutableList<Data>>()
    val error = MutableLiveData<String>()


    fun getDados() {
        ApiClient.getDados(object : ConnectionListener<MutableList<Data>> {
            override fun success(data: MutableList<Data>) {
                dadosLiveData.value = data
            }

            override fun fail(errorMessage: String) {
                error.value = errorMessage
            }
        })
    }

}
