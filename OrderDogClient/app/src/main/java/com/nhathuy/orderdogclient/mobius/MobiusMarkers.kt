package com.nhathuy.orderdogclient.mobius

import androidx.annotation.CallSuper
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import com.spotify.mobius.android.MobiusLoopViewModel
import com.spotify.mobius.functions.Consumer

interface MobiusEffect
interface MobiusViewEffect
interface MobiusEvent
interface MobiusModel
typealias ViewEffectConsumer<T> =Consumer<T>


interface MobiusView<Model:MobiusModel,ViewEffect:MobiusViewEffect>{
    fun handleViewEffect(viewEffect: ViewEffect){
        throw IllegalStateException("handleViewEffect not implement")
    }
    @CallSuper
    fun subscribeToViewEffects(lifecycleOwner: LifecycleOwner,viewModel: MobiusLoopViewModel<Model, out MobiusEvent, out MobiusEffect,ViewEffect>){
        viewModel.viewEffects.setObserver(lifecycleOwner,Observer(this::handleViewEffect),Observer{
            it.forEach(this::handleViewEffect)
        })
    }
}