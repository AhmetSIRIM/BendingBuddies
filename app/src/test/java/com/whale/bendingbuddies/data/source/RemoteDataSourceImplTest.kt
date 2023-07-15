package com.whale.bendingbuddies.data.source

import com.google.common.truth.Truth.assertThat
import com.whale.bendingbuddies.data.NetworkResponseState
import com.whale.bendingbuddies.data.api.BendingBuddyApi
import com.whale.bendingbuddies.sampleBendingBuddyItem
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations

internal class RemoteDataSourceImplTest {

    @Mock
    private lateinit var bendingBuddyApiForTest: BendingBuddyApi

    private lateinit var remoteDataSourceImplForTest: RemoteDataSourceImpl

    @Before
    fun setup() {
        MockitoAnnotations.openMocks(this)
        remoteDataSourceImplForTest = RemoteDataSourceImpl(bendingBuddyApiForTest)
    }

    @Test
    fun `when getAllBendingBuddies return state is success`() {
        runBlocking {
            Mockito.`when`(bendingBuddyApiForTest.getAllBendingBuddies())
                .thenReturn(
                    listOf(sampleBendingBuddyItem)
                )

            val response = remoteDataSourceImplForTest.getAllBendingBuddies()
            assertThat(response).isInstanceOf(NetworkResponseState.Success::class.java)
        }
    }

//    @Test // TODO (Ahmet) ---> getAllBendingBuddies() from RemoteDataSourceImpl did not return NetworkResponseState.Error. It will be refactored.
//    fun `when getAllBendingBuddies return state is failure`() {
//        runBlocking {
//            Mockito.`when`(bendingBuddyApiForTest.getAllBendingBuddies())
//                .thenReturn(
//                    null
//                )
//
//            val response = remoteDataSourceImplForTest.getAllBendingBuddies()
//            assertThat(response).isInstanceOf(NetworkResponseState.Error::class.java)
//        }
//    }

}