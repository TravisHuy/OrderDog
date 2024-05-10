package com.nhathuy.orderdogclient.data

import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import com.nhathuy.orderdogclient.mobius.WorkRunnersConstants
import com.nhathuy.orderdogclient.network.DogsApiServer
import com.spotify.mobius.android.runners.MainThreadWorkRunner
import com.spotify.mobius.runners.WorkRunner
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import retrofit2.Retrofit
import javax.inject.Named

@Module
@InstallIn(SingletonComponent::class)
class AppComponent {
    private val baseUrl ="http://10.0.2.2:8080/"

    @Provides
    fun provideRetrofit():Retrofit{
        return Retrofit.Builder().addConverterFactory(Json.asConverterFactory("application/json".toMediaType()))
            .baseUrl(baseUrl)
            .build()
    }
    @Provides
    fun provideDogsApiServer(retrofit: Retrofit):DogsApiServer{
        return retrofit.create(DogsApiServer::class.java)
    }
    @Provides
    @Named(WorkRunnersConstants.MAIN_THREAD_WORK_RUNNER)
    fun providesWorkRunner():WorkRunner{
        return MainThreadWorkRunner.create()
    }
}