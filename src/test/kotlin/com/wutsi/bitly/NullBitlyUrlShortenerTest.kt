package com.wutsi.bitly

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

internal class NullBitlyUrlShortenerTest {
    @Test
    fun test() {
        val url = "http://www.google.ca"
        assertEquals(url, NullBitlyUrlShortener().shorten(url))
    }
}
