package com.nhathuy.orderdogclient.mvi

sealed class DogListEffect {
    object LoadDogs:DogListEffect()
}