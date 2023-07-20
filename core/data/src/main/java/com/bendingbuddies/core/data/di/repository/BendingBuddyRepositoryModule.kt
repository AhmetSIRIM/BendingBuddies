package com.bendingbuddies.core.data.di.repository

import com.bendingbuddies.core.data.repository.BendingBuddyRepositoryImpl
import com.bendingbuddies.core.domain.repository.BendingBuddyRepository
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