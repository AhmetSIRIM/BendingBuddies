package com.whale.bendingbuddies.di.mapper

import com.whale.bendingbuddies.data.dto.BendingBuddyResponseItem
import com.whale.bendingbuddies.data.mapper.BendingBuddyListMapper
import com.whale.bendingbuddies.data.mapper.BendingBuddyListMapperImpl
import com.whale.bendingbuddies.data.mapper.BendingBuddyMapper
import com.whale.bendingbuddies.data.mapper.BendingBuddyMapperImpl
import com.whale.bendingbuddies.domain.BendingBuddyEntity
import com.whale.bendingbuddies.ui.detail.BendingBuddyDetailUiMapperImpl
import com.whale.bendingbuddies.ui.detail.DetailUiData
import com.whale.bendingbuddies.ui.home.BendingBuddyHomeUiMapperImpl
import com.whale.bendingbuddies.ui.home.HomeUiData
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
    abstract fun bindBendingBuddyMapper(
        bendingBuddyMapperImpl: BendingBuddyMapperImpl
    ): BendingBuddyMapper<BendingBuddyResponseItem, BendingBuddyEntity>

    @Binds
    @ViewModelScoped
    abstract fun bindBendingBuddyListMapper(
        bendingBuddyListMapperImpl: BendingBuddyListMapperImpl
    ): BendingBuddyListMapper<BendingBuddyResponseItem, BendingBuddyEntity>

    @Binds
    @ViewModelScoped
    abstract fun bindBendingBuddyHomeUiMapper(
        bendingBuddyHomeUiMapperImpl: BendingBuddyHomeUiMapperImpl
    ): BendingBuddyListMapper<BendingBuddyEntity, HomeUiData>

    @Binds
    @ViewModelScoped
    abstract fun bindBendingBuddyDetailUiMapper(
        bendingBuddyDetailUiMapperImpl: BendingBuddyDetailUiMapperImpl
    ): BendingBuddyMapper<BendingBuddyEntity, DetailUiData>

}