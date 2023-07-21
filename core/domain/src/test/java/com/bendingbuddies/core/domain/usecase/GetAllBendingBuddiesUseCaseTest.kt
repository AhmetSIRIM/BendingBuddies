package com.bendingbuddies.core.domain.usecase

import app.cash.turbine.test
import com.bendingbuddies.core.common.NetworkResponseState
import com.bendingbuddies.core.domain.NetworkResponseStateEnumForTest
import com.google.common.truth.Truth
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test
import org.mockito.InjectMocks
import org.mockito.MockitoAnnotations

class GetAllBendingBuddiesUseCaseTest {

    @InjectMocks
    private lateinit var fakeGetAllBendingBuddiesUseCase: FakeGetAllBendingBuddiesUseCase

    @Before
    fun setup() {
        MockitoAnnotations.openMocks(this)
    }

    /** Loading state test of getAllBendingBuddiesUseCase */
    @Test
    fun `When Loading state is expected from getAllBendingBuddiesUseCase`() {
        runBlocking {

            fakeGetAllBendingBuddiesUseCase().test {
                Truth.assertThat(
                    awaitItem()
                ).isInstanceOf(NetworkResponseState.Loading::class.java)
                cancelAndIgnoreRemainingEvents()
            }

        }

    }

    /** Success state test of getAllBendingBuddiesUseCase */
    @Test
    fun `When Success state is expected from getAllBendingBuddiesUseCase`() {
        runBlocking {

            fakeGetAllBendingBuddiesUseCase.setNetworkResponseStateForTest(
                NetworkResponseStateEnumForTest.SUCCESS
            )

            fakeGetAllBendingBuddiesUseCase().test {
                Truth.assertThat(
                    awaitItem()
                ).isInstanceOf(NetworkResponseState.Loading::class.java)
                Truth.assertThat(
                    awaitItem()
                ).isInstanceOf(NetworkResponseState.Success::class.java)
                awaitComplete()
            }

        }

    }

    /** Error state test of getAllBendingBuddiesUseCase */
    @Test
    fun `When Error state is expected from getAllBendingBuddiesUseCase`() {
        runBlocking {

            fakeGetAllBendingBuddiesUseCase.setNetworkResponseStateForTest(
                NetworkResponseStateEnumForTest.ERROR
            )

            fakeGetAllBendingBuddiesUseCase().test {
                Truth.assertThat(
                    awaitItem()
                ).isInstanceOf(NetworkResponseState.Loading::class.java)
                Truth.assertThat(
                    awaitItem()
                ).isInstanceOf(NetworkResponseState.Error::class.java)
                awaitComplete()
            }

        }

    }

}