package com.bendingbuddies.core.data.source

import com.bendingbuddies.core.common.NetworkResponseState
import com.bendingbuddies.core.data.KORRA_PARAMETER
import com.bendingbuddies.core.data.api.BendingBuddyApi
import com.bendingbuddies.core.data.sampleBendingBuddyResponseItem
import com.google.common.truth.Truth.assertThat
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

    /** Try-block test of getAllBendingBuddies function of RemoteDataSourceImpl */
    @Test
    fun `when getAllBendingBuddies pass the try-block`() {
        runBlocking {
            Mockito.`when`(bendingBuddyApiForTest.getAllBendingBuddies())
                .thenReturn(listOf(sampleBendingBuddyResponseItem))

            val response = remoteDataSourceImplForTest.getAllBendingBuddies()

            assertThat(response).isInstanceOf(NetworkResponseState.Success::class.java)
        }
    }

    /** Catch-block test of getAllBendingBuddies function of RemoteDataSourceImpl */
    @Test
    fun `when getAllBendingBuddies can not pass the try-block`() {
        runBlocking {
            Mockito.`when`(bendingBuddyApiForTest.getAllBendingBuddies())
                .thenReturn(null)

            val response = remoteDataSourceImplForTest.getAllBendingBuddies()

            assertThat(response).isInstanceOf(NetworkResponseState.Error::class.java)
        }
    }

    /** Try-block test of getBendingBuddyByName function of RemoteDataSourceImpl with Korra input */
    @Test
    fun `when getBendingBuddyByName with Korra input pass the try-block`() {
        runBlocking {
            Mockito.`when`(bendingBuddyApiForTest.getBendingBuddyByName(KORRA_PARAMETER))
                .thenReturn(listOf(sampleBendingBuddyResponseItem))

            val response = remoteDataSourceImplForTest.getBendingBuddyByName(KORRA_PARAMETER)

            assertThat(response).isInstanceOf(NetworkResponseState.Success::class.java)
        }
    }

    /** Catch-block test of getBendingBuddyByName function of RemoteDataSourceImpl with Korra input */
    @Test
    fun `when getBendingBuddyByName with Korra input can not pass the try-block`() {
        runBlocking {
            Mockito.`when`(bendingBuddyApiForTest.getBendingBuddyByName(KORRA_PARAMETER))
                .thenReturn(null)

            val response = remoteDataSourceImplForTest.getBendingBuddyByName(KORRA_PARAMETER)

            assertThat(response).isInstanceOf(NetworkResponseState.Error::class.java)
        }
    }

}