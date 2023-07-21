package com.bendingbuddies.core.domain.usecase

import app.cash.turbine.test
import com.bendingbuddies.core.common.NetworkResponseState
import com.bendingbuddies.core.domain.KORRA_PARAMETER
import com.bendingbuddies.core.domain.NetworkResponseStateEnumForTest
import com.google.common.truth.Truth
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test
import org.mockito.InjectMocks
import org.mockito.MockitoAnnotations

class GetBendingBuddyByNameUseCaseTest {

    @InjectMocks
    private lateinit var fakeGetBendingBuddyByNameUseCase: FakeGetBendingBuddyByNameUseCase

    @Before
    fun setup() {
        MockitoAnnotations.openMocks(this)
    }

    /** Loading state test of getBendingBuddyByNameUseCase with Korra input */
    @Test
    fun `When Loading state is expected from getBendingBuddyByNameUseCase with Korra input`() {
        runBlocking {

            fakeGetBendingBuddyByNameUseCase(KORRA_PARAMETER).test {
                Truth.assertThat(
                    awaitItem()
                ).isInstanceOf(NetworkResponseState.Loading::class.java)
                cancelAndIgnoreRemainingEvents()
            }

        }

    }

    /** Success state test of getBendingBuddyByNameUseCase with Korra input */
    @Test
    fun `When Success state is expected from getBendingBuddyByNameUseCase with Korra input`() {
        runBlocking {

            fakeGetBendingBuddyByNameUseCase.setNetworkResponseStateForTest(
                NetworkResponseStateEnumForTest.SUCCESS
            )

            fakeGetBendingBuddyByNameUseCase(KORRA_PARAMETER).test {
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

    /** Error state test of getBendingBuddyByNameUseCase with Korra input */
    @Test
    fun `When Error state is expected from getBendingBuddyByNameUseCase with Korra input`() {
        runBlocking {

            fakeGetBendingBuddyByNameUseCase.setNetworkResponseStateForTest(
                NetworkResponseStateEnumForTest.ERROR
            )

            fakeGetBendingBuddyByNameUseCase(KORRA_PARAMETER).test {
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