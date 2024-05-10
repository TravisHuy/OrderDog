package com.nhathuy.orderdogclient.data

import com.nhathuy.orderdogclient.model.Pet
import com.nhathuy.orderdogclient.network.DogsApiServer
import javax.inject.Inject


class PetsRepository @Inject constructor(private val dogsApiServer:DogsApiServer) {
     fun getListPets():List<Pet>{
        return dogsApiServer.getAllDogs()
    }
     fun getPet(id:String):Pet{
        return dogsApiServer.getDogById(id)
    }
}