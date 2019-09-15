package br.com.southsystem.hackatona2019.api

interface ConnectionListener<T> {

    fun success(data: T)
    fun fail(errorMessage: String)

}