package com.nhathuy.orderdogclient.viewmodel

import com.nhathuy.orderdogclient.model.Pet

data class DogListModel(
    val state: ScreenState =ScreenState.Loading,
    val listDogs: List<Pet> = emptyList()
)
enum class ScreenState{
    Loaded,
    Loading
}