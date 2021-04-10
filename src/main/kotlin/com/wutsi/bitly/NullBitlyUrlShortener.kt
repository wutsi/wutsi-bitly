package com.wutsi.bitly

class NullBitlyUrlShortener : BitlyUrlShortener {
    override fun shorten(url: String) = url
}
