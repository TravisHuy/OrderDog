package com.nhathuy.orderdogclient.mvi

import com.nhathuy.orderdogclient.mobius.MobiusViewEffect

sealed class DogListViewEffect : MobiusViewEffect {
    data class ShowDogDetails(val petId:String) : DogListViewEffect()
}