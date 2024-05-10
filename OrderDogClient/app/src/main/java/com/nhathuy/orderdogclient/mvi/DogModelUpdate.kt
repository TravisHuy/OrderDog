package com.nhathuy.orderdogclient.mvi

import com.nhathuy.orderdogclient.mobius.ViewEffectConsumer
import com.nhathuy.orderdogclient.viewmodel.DogListModel
import com.spotify.mobius.Next
import com.spotify.mobius.Update

class DogModelUpdate(val viewEffectConsumer:ViewEffectConsumer<DogListViewEffect>):Update<DogListModel,DogListEvent,DogListEffect> {
    override fun update(
        model: DogListModel,
        event: DogListEvent
    ): Next<DogListModel, DogListEffect> {
        return when(event){
            is DogListEvent.OnDogSelected ->{
                viewEffectConsumer.accept(DogListViewEffect.ShowDogDetails(event.dog.id))
                Next.noChange()
            }
            is DogListEvent.OnDogsLoaded ->{
                Next.next(model.copy(listDogs = event.listDogs))
            }
        }
    }
}