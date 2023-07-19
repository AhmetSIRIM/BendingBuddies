package com.whale.bendingbuddies.data.repository

import app.cash.turbine.test
import com.google.common.truth.Truth.assertThat
import com.whale.bendingbuddies.KORRA_PARAMETER
import com.whale.bendingbuddies.NetworkResponseStateEnumForTest
import com.whale.bendingbuddies.data.NetworkResponseState
import com.whale.bendingbuddies.data.mapper.BendingBuddyListMapperImpl
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test

internal class BendingBuddyRepositoryTest {

    private lateinit var bendingBuddyListMapperImpl: BendingBuddyListMapperImpl
    private lateinit var fakeBendingBuddyRepository: FakeBendingBuddyRepository

    @Before
    fun setup() {
        bendingBuddyListMapperImpl = BendingBuddyListMapperImpl()
        fakeBendingBuddyRepository = FakeBendingBuddyRepository(bendingBuddyListMapperImpl)
    }

    /** Loading state test of getAllBendingBuddies function */
    @Test
    fun `When Loading state is expected from getAllBendingBuddies`() {
        runBlocking {

            fakeBendingBuddyRepository.getAllBendingBuddies().test {
                assertThat(
                    awaitItem()
                ).isInstanceOf(NetworkResponseState.Loading::class.java)
                cancelAndIgnoreRemainingEvents()
            }

        }
    }

    /** Success state test of getAllBendingBuddies function */
    @Test
    fun `When Success state is expected from getAllBendingBuddies`() {
        runBlocking {

            fakeBendingBuddyRepository.setNetworkResponseStateForTest(
                NetworkResponseStateEnumForTest.SUCCESS
            )

            fakeBendingBuddyRepository.getAllBendingBuddies().test {
                assertThat(
                    awaitItem()
                ).isInstanceOf(NetworkResponseState.Loading::class.java)
                assertThat(
                    awaitItem()
                ).isInstanceOf(NetworkResponseState.Success::class.java)
                awaitComplete()
            }

        }
    }

    /** Error state test of getAllBendingBuddies function */
    @Test
    fun `When Error state is expected from getAllBendingBuddies`() {
        runBlocking {

            fakeBendingBuddyRepository.setNetworkResponseStateForTest(
                NetworkResponseStateEnumForTest.ERROR
            )

            fakeBendingBuddyRepository.getAllBendingBuddies().test {
                assertThat(
                    awaitItem()
                ).isInstanceOf(NetworkResponseState.Loading::class.java)
                assertThat(
                    awaitItem()
                ).isInstanceOf(NetworkResponseState.Error::class.java)
                awaitComplete()
            }

        }
    }

    /** Loading state test of getBendingBuddyByName function with Korra input */
    @Test
    fun `When Loading state is expected from getBendingBuddyByName with Korra input`() {
        runBlocking {

            fakeBendingBuddyRepository.getBendingBuddyByName(KORRA_PARAMETER).test {
                assertThat(
                    awaitItem()
                ).isInstanceOf(NetworkResponseState.Loading::class.java)
                cancelAndIgnoreRemainingEvents()
            }

        }
    }

    /** Success state test of getBendingBuddyByName function with Korra input */
    @Test
    fun `When Success state is expected from getBendingBuddyByName with Korra input`() {
        runBlocking {

            fakeBendingBuddyRepository.setNetworkResponseStateForTest(
                NetworkResponseStateEnumForTest.SUCCESS
            )

            fakeBendingBuddyRepository.getBendingBuddyByName(KORRA_PARAMETER).test {
                assertThat(
                    awaitItem()
                ).isInstanceOf(NetworkResponseState.Loading::class.java)
                assertThat(
                    awaitItem()
                ).isInstanceOf(NetworkResponseState.Success::class.java)
                awaitComplete()
            }

        }
    }

    /** Error state test of getBendingBuddyByName function with Korra input */
    @Test
    fun `When Error state is expected from getBendingBuddyByName with Korra input`() {
        runBlocking {

            fakeBendingBuddyRepository.setNetworkResponseStateForTest(
                NetworkResponseStateEnumForTest.ERROR
            )

            fakeBendingBuddyRepository.getBendingBuddyByName(KORRA_PARAMETER).test {
                assertThat(
                    awaitItem()
                ).isInstanceOf(NetworkResponseState.Loading::class.java)
                assertThat(
                    awaitItem()
                ).isInstanceOf(NetworkResponseState.Error::class.java)
                awaitComplete()
            }

        }
    }

}
