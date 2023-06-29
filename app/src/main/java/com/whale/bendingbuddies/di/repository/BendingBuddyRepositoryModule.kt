package com.whale.bendingbuddies.di.repository

import com.whale.bendingbuddies.data.repository.BendingBuddyRepository
import com.whale.bendingbuddies.data.repository.BendingBuddyRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped

@Module
@InstallIn(ViewModelComponent::class)
abstract class BendingBuddyRepositoryModule {

    @Binds
    @ViewModelScoped
    abstract fun bindBendingBuddyRepository(
        bendingBuddyRepositoryImpl: BendingBuddyRepositoryImpl
    ): BendingBuddyRepository

}