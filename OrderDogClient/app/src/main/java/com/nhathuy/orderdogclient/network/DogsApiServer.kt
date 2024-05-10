package com.nhathuy.orderdogclient.network

import com.nhathuy.orderdogclient.model.Pet
import retrofit2.http.GET
import retrofit2.http.Path

interface DogsApiServer {
    @GET("dog")
    fun getAllDogs():List<Pet>
    @GET("dog/{id}")
    fun getDogById(@Path("id") id:String): Pet
}