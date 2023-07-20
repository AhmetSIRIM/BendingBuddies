package com.bendingbuddies.core.data.di.mapper

import com.bendingbuddies.core.common.mapper.BendingBuddyListMapper
import com.bendingbuddies.core.data.dto.BendingBuddyResponseItem
import com.bendingbuddies.core.data.mapper.BendingBuddyListMapperImpl
import com.bendingbuddies.core.domain.entity.BendingBuddyEntity
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped

@Module
@InstallIn(ViewModelComponent::class)
abstract class MapperModule {

    @Binds
    @ViewModelScoped
    abstract fun bindBendingBuddyListMapper(
        bendingBuddyListMapperImpl: BendingBuddyListMapperImpl
    ): BendingBuddyListMapper<BendingBuddyResponseItem, BendingBuddyEntity>
}