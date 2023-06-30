package com.whale.bendingbuddies.di.usecase

import com.whale.bendingbuddies.domain.usecase.GetAllBendingBuddiesUseCase
import com.whale.bendingbuddies.domain.usecase.GetAllBendingBuddiesUseCaseImpl
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

}