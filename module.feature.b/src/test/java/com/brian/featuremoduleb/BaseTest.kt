package com.brian.featuremoduleb

import com.brian.core.di.provideNetworkModule
import com.brian.featuremoduleb.api.FeatureBApiServices
import com.brian.featuremoduleb.module.featureBModules
import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.MockWebServer
import org.junit.After
import org.junit.Before
import org.koin.core.context.startKoin
import org.koin.core.context.stopKoin
import org.koin.test.KoinTest
import org.koin.test.inject
import java.io.File

abstract class BaseTest : KoinTest {
    protected val featureBApiServices: FeatureBApiServices by inject()
    protected lateinit var mockServer: MockWebServer

    @Before
    open fun setUp() {
        mockServer = MockWebServer()
        mockServer.start()
        startKoin {
            modules(
                listOf(
                    provideNetworkModule(mockServer.url("/").toString()),
                    featureBModules
                )
            )
        }
    }

    @After
    open fun tearDown() {
        mockServer.shutdown()
        stopKoin()
    }

    fun mockHttpResponse(mockServer: MockWebServer, fileName: String, responseCode: Int) =
        mockServer.enqueue(
            MockResponse()
                .setResponseCode(responseCode)
                .setBody(getJson(fileName))
        )

    private fun getJson(path: String): String {
        val uri = this.javaClass.classLoader.getResource(path)
        val file = File(uri.path)
        return String(file.readBytes())
    }
}
