package com.kashif.muslim_scientists

import com.kashif.kmmscientists.plugins.configureRouting
import io.ktor.http.*
import kotlin.test.*
import io.ktor.server.testing.*


class ApplicationTest {
    @Test
    fun testRoot() {
        withTestApplication({ configureRouting() }) {
            handleRequest(HttpMethod.Get, "/").apply {
                assertEquals(HttpStatusCode.OK, response.status())
                assertEquals("Hello World!", response.content)
            }
        }
    }
}