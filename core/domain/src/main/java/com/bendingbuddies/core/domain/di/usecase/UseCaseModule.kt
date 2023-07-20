package com.bendingbuddies.core.domain.di.usecase

import com.bendingbuddies.core.domain.usecase.GetAllBendingBuddiesUseCase
import com.bendingbuddies.core.domain.usecase.GetAllBendingBuddiesUseCaseImpl
import com.bendingbuddies.core.domain.usecase.GetBendingBuddyByNameUseCase
import com.bendingbuddies.core.domain.usecase.GetBendingBuddyByNameUseCaseImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped

@Module
@InstallIn(ViewModelComponent::class)
abstract class UseCaseModule {

    @Binds
    @ViewModelScoped
    abstract fun bindGetAllBendingBuddiesUseCase(
        getAllBendingBuddiesUseCaseImpl: GetAllBendingBuddiesUseCaseImpl
    ): GetAllBendingBuddiesUseCase

    @Binds
    @ViewModelScoped
    abstract fun bindGetBendingBuddyByNameUseCase(
        getBendingBuddyByNameUseCaseImpl: GetBendingBuddyByNameUseCaseImpl
    ): GetBendingBuddyByNameUseCase

}