package com.nhathuy.orderdogclient.usecase

import com.nhathuy.orderdogclient.data.PetsRepository
import com.nhathuy.orderdogclient.model.Pet
import io.reactivex.rxjava3.core.Flowable
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

import javax.inject.Inject

class DogUseCase @Inject constructor(private val dogsRepository: PetsRepository) {
    fun getListPets():List<Pet> {
          return  dogsRepository.getListPets()
    }
    fun getPet(id:String): Pet{
          return   dogsRepository.getPet(id)
    }
}