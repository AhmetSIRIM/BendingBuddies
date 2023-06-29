package com.whale.bendingbuddies.di.mapper

import com.whale.bendingbuddies.data.dto.BendingBuddyResponseItem
import com.whale.bendingbuddies.data.mapper.BendingBuddyListMapper
import com.whale.bendingbuddies.data.mapper.BendingBuddyListMapperImpl
import com.whale.bendingbuddies.data.mapper.BendingBuddyMapper
import com.whale.bendingbuddies.data.mapper.BendingBuddyMapperImpl
import com.whale.bendingbuddies.domain.BendingBuddyEntity
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewComponent
import dagger.hilt.android.scopes.ViewModelScoped

@Module
@InstallIn(ViewComponent::class)
abstract class MapperModule {

    @Binds
    @ViewModelScoped
    abstract fun bindBendingBuddyListMapperImpl(
        bendingBuddyListMapperImpl: BendingBuddyListMapperImpl
    ): BendingBuddyListMapper<BendingBuddyResponseItem, BendingBuddyEntity>

    @Binds
    @ViewModelScoped
    abstract fun bindBendingBuddyMapperImpl(
        bendingBuddyMapperImpl: BendingBuddyMapperImpl
    ): BendingBuddyMapper<BendingBuddyResponseItem, BendingBuddyEntity>

}