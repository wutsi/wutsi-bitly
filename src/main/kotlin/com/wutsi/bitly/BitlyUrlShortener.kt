package com.wutsi.bitly

interface BitlyUrlShortener {
    fun shorten(url: String): String
}
