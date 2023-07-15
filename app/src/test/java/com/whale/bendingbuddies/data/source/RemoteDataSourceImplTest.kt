package com.whale.bendingbuddies.data.source

import com.google.common.truth.Truth.assertThat
import com.whale.bendingbuddies.KORRA_PARAMETER
import com.whale.bendingbuddies.data.NetworkResponseState
import com.whale.bendingbuddies.data.api.BendingBuddyApi
import com.whale.bendingbuddies.sampleBendingBuddyResponseItem
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

    /** Success state test of getAllBendingBuddies function */
    @Test
    fun `when getAllBendingBuddies return state is success`() {
        runBlocking {
            Mockito.`when`(bendingBuddyApiForTest.getAllBendingBuddies())
                .thenReturn(
                    listOf(sampleBendingBuddyResponseItem)
                )

            val response = remoteDataSourceImplForTest.getAllBendingBuddies()

            assertThat(response).isInstanceOf(NetworkResponseState.Success::class.java)
        }
    }

    /** Error state test of getAllBendingBuddies function */
    @Test
    fun `when getAllBendingBuddies return state is error`() {
        runBlocking {
            Mockito.`when`(bendingBuddyApiForTest.getAllBendingBuddies())
                .thenReturn(
                    null
                )

            val response = remoteDataSourceImplForTest.getAllBendingBuddies()

            assertThat(response).isInstanceOf(NetworkResponseState.Error::class.java)
        }
    }

    /** Success state test of getBendingBuddyByName function with Korra input */
    @Test
    fun `when getBendingBuddyByName with Korra parameter return state is success`() {
        runBlocking {
            Mockito.`when`(bendingBuddyApiForTest.getBendingBuddyByName(KORRA_PARAMETER))
                .thenReturn(
                    listOf(sampleBendingBuddyResponseItem)
                )

            val response = remoteDataSourceImplForTest.getBendingBuddyByName(KORRA_PARAMETER)

            assertThat(response).isInstanceOf(NetworkResponseState.Success::class.java)
        }
    }

    /** Error state test of getBendingBuddyByName function with Korra input */
    @Test
    fun `when getBendingBuddyByName with Korra parameter return state is error`() {
        runBlocking {
            Mockito.`when`(bendingBuddyApiForTest.getBendingBuddyByName(KORRA_PARAMETER))
                .thenReturn(
                    null
                )

            val response = remoteDataSourceImplForTest.getBendingBuddyByName(KORRA_PARAMETER)

            assertThat(response).isInstanceOf(NetworkResponseState.Error::class.java)
        }
    }

}