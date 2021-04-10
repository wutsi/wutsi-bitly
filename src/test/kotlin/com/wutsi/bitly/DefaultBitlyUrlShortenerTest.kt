package com.wutsi.bitly

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

internal class DefaultBitlyUrlShortenerTest {
    private val url = "https://www.google.ca"

    @Test
    fun `shorten url`() {
        val shortener = DefaultBitlyUrlShortener("7c6a88dd1ca7633b0d5e15336184848e0ec5d22c")
        val result = shortener.shorten(url)
        assertEquals("https://bit.ly/2KPbcAE", result)
    }

    @Test
    fun `do not shorten URL with invalid token`() {
        val shortener = DefaultBitlyUrlShortener("xxxx")
        val result = shortener.shorten(url)
        assertEquals(url, result)
    }
}
