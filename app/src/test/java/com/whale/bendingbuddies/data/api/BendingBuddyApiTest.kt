package com.whale.bendingbuddies.data.api

import com.google.common.truth.Truth.assertThat
import com.whale.bendingbuddies.GET_ALL_BENDING_BUDDIES_PATH
import com.whale.bendingbuddies.GET_BENDING_BUDDY_BY_NAME_PATH_WITH_KORRA_INPUT
import com.whale.bendingbuddies.KORRA_PARAMETER
import com.whale.bendingbuddies.SAMPLE_RESPONSE_FILE_NAME_FOR_GET_ALL_BENDING_BUDDIES
import com.whale.bendingbuddies.SAMPLE_RESPONSE_FILE_NAME_FOR_GET_BENDING_BUDDY_BY_NAME_WITH_KORRA_INPUT
import com.whale.bendingbuddies.data.dto.BendingBuddyResponseItem
import kotlinx.coroutines.runBlocking
import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.MockWebServer
import okio.buffer
import okio.source
import org.junit.After
import org.junit.Before
import org.junit.Test
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class BendingBuddyApiTest {

    private lateinit var bendingBuddyApiForTest: BendingBuddyApi
    private val mockWebServer = MockWebServer()

    @Before
    fun setupMockWebServer() {

        mockWebServer.start(8080)

        bendingBuddyApiForTest = Retrofit
            .Builder()
            .baseUrl(mockWebServer.url(""))
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(BendingBuddyApi::class.java)

    }

    /** Response validation test */
    @Test
    fun `when getAllBendingBuddies request returns valid response element`() {
        runBlocking {
            enqueueResponse(SAMPLE_RESPONSE_FILE_NAME_FOR_GET_ALL_BENDING_BUDDIES)

            val response = bendingBuddyApiForTest.getAllBendingBuddies()

            assertThat(response?.first()).isInstanceOf(BendingBuddyResponseItem::class.java)
        }
    }

    /** Path validation test of getAllBendingBuddies request */
    @Test
    fun `when getAllBendingBuddies request path is same`() {
        runBlocking {
            enqueueResponse(SAMPLE_RESPONSE_FILE_NAME_FOR_GET_ALL_BENDING_BUDDIES)

            val response = bendingBuddyApiForTest.getAllBendingBuddies()
            val request = mockWebServer.takeRequest()

            assertThat(response).isNotNull()
            assertThat(request.path).isEqualTo(GET_ALL_BENDING_BUDDIES_PATH)
        }
    }

    /** Null check test of getAllBendingBuddies request response */
    @Test
    fun `when getAllBendingBuddies request response is not null`() {
        runBlocking {
            enqueueResponse(SAMPLE_RESPONSE_FILE_NAME_FOR_GET_ALL_BENDING_BUDDIES)

            val response = bendingBuddyApiForTest.getAllBendingBuddies()

            assertThat(response).isNotNull()
        }
    }

    /** Path validation test of getBendingBuddyByName request with Korra input */
    @Test
    fun `when getBendingBuddyByName request with Korra input path is same`() {
        runBlocking {
            enqueueResponse(SAMPLE_RESPONSE_FILE_NAME_FOR_GET_BENDING_BUDDY_BY_NAME_WITH_KORRA_INPUT)

            val response = bendingBuddyApiForTest.getBendingBuddyByName(KORRA_PARAMETER)
            val request = mockWebServer.takeRequest()

            assertThat(response).isNotNull()
            assertThat(request.path).isEqualTo(GET_BENDING_BUDDY_BY_NAME_PATH_WITH_KORRA_INPUT)
        }
    }

    /** Null check test of getBendingBuddyByName request response with Korra input */
    @Test
    fun `when getBendingBuddyByName request is not null`() {
        runBlocking {
            enqueueResponse(SAMPLE_RESPONSE_FILE_NAME_FOR_GET_BENDING_BUDDY_BY_NAME_WITH_KORRA_INPUT)

            val response = bendingBuddyApiForTest.getBendingBuddyByName(KORRA_PARAMETER)

            assertThat(response).isNotNull()
        }
    }

    /** Response correctness test of getBendingBuddyByName request with Korra input */
    @Test
    fun `when getBendingBuddyByName request with Korra parameter is return correct response`() {
        runBlocking {
            enqueueResponse(SAMPLE_RESPONSE_FILE_NAME_FOR_GET_BENDING_BUDDY_BY_NAME_WITH_KORRA_INPUT)

            val response = bendingBuddyApiForTest.getBendingBuddyByName(KORRA_PARAMETER)

            assertThat(response?.first()?.name).isEqualTo(KORRA_PARAMETER)
        }
    }

    private fun enqueueResponse(fileName: String) {
        javaClass.classLoader?.let {
            val inputStream = it.getResourceAsStream(fileName)
            val source = inputStream.source().buffer()
            val mockResponse = MockResponse()
            mockResponse.setBody(source.readString(Charsets.UTF_8))
            mockWebServer.enqueue(mockResponse)
        }
    }

    @After
    fun shutDownMockWebServer() {
        mockWebServer.shutdown()
    }

}