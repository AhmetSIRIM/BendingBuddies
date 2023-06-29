package com.whale.bendingbuddies.di.network

import com.whale.bendingbuddies.data.api.BendingBuddyApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Module
@InstallIn(ViewModelComponent::class)
object BendingBuddyNetworkModule {

    @Provides
    @ViewModelScoped
    fun provideBendingBuddyApi(): BendingBuddyApi {
        return Retrofit
            .Builder()
            .baseUrl("https://last-airbender-api.fly.dev/api/v1/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(BendingBuddyApi::class.java)
    }

}