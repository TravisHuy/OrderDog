package com.nhathuy.orderdogclient.mvi

import com.nhathuy.orderdogclient.usecase.DogUseCase
import com.spotify.mobius.rx3.RxMobius
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.ObservableTransformer

object DogSideEffectHandler {
    operator fun invoke(dogUseCase: DogUseCase) : ObservableTransformer<DogListEffect,DogListEvent>{
        val effectHandlerBuilder=RxMobius.subtypeEffectHandler<DogListEffect,DogListEvent>()
        effectHandlerBuilder.addTransformer(DogListEffect.LoadDogs::class.java,
            loadDogs(dogUseCase=dogUseCase)
        )
        return effectHandlerBuilder.build()
    }

    private fun loadDogs(dogUseCase: DogUseCase) = ObservableTransformer<DogListEffect.LoadDogs, DogListEvent> { upstream ->
        upstream.flatMap { effect ->
            val dogs = dogUseCase.getListPets()
            Observable.just(DogListEvent.OnDogsLoaded(dogs))
        }
    }
}