package com.nhathuy.orderdogclient.viewmodel

import com.nhathuy.orderdogclient.mobius.ViewEffectConsumer
import com.nhathuy.orderdogclient.mobius.WorkRunnersConstants
import com.nhathuy.orderdogclient.mvi.*
import com.nhathuy.orderdogclient.usecase.DogUseCase
import com.spotify.mobius.MobiusLoop
import com.spotify.mobius.android.MobiusLoopViewModel
import com.spotify.mobius.runners.WorkRunner
import com.spotify.mobius.runners.WorkRunners
import com.spotify.mobius.rx3.RxMobius
import dagger.hilt.android.lifecycle.HiltViewModel
import com.spotify.mobius.functions.Function as MobiusFunction
import javax.inject.Inject
import javax.inject.Named

@HiltViewModel
class DogListingViewModel @Inject constructor(
    private val dogUseCase: DogUseCase,
    @Named(WorkRunnersConstants.MAIN_THREAD_WORK_RUNNER) workRunner:WorkRunner
):MobiusLoopViewModel<DogListModel,DogListEvent,DogListEffect,DogListViewEffect>
    (MobiusFunction<ViewEffectConsumer<DogListViewEffect>, MobiusLoop.Factory<DogListModel,DogListEvent,DogListEffect>>{
        val sideEffectHandler=DogSideEffectHandler(dogUseCase = dogUseCase)
        RxMobius.loop(
            DogModelUpdate(it),
            sideEffectHandler
        )
},
    DogListModel(),
    DogModelInit(),
    workRunner,
    10)
