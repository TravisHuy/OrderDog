package com.nhathuy.orderdogclient.mvi

import com.nhathuy.orderdogclient.viewmodel.DogListModel
import com.spotify.mobius.First
import com.spotify.mobius.Init

object DogModelInit {
    operator fun invoke()= Init<DogListModel,DogListEffect> {
        model -> First.first(model, setOf(DogListEffect.LoadDogs))
    }
}