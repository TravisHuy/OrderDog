package com.nhathuy.orderdogclient.mvi

import com.nhathuy.orderdogclient.model.Pet

sealed class DogListEvent {
    data class OnDogsLoaded(val listDogs: List<Pet>) :DogListEvent()
    data class OnDogSelected(val dog:Pet) :DogListEvent()
}