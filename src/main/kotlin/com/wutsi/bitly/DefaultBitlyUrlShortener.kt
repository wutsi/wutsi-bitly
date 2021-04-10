package com.wutsi.bitly

import net.swisstech.bitly.BitlyClient
import net.swisstech.bitly.model.Response
import net.swisstech.bitly.model.v3.ShortenResponse
import org.slf4j.LoggerFactory

class DefaultBitlyUrlShortener(private val accessToken: String) : BitlyUrlShortener {
    companion object {
        private val LOGGER = LoggerFactory.getLogger(DefaultBitlyUrlShortener::class.java)
    }

    override fun shorten(url: String): String {
        val client = BitlyClient(accessToken)
        val resp: Response<ShortenResponse> = client.shorten()
            .setLongUrl(url)
            .call()

        if (resp.status_code / 100 == 2)
            return resp.data.url
        else {
            LOGGER.warn("Unable to shorten $url. Error=${resp.status_code} - ${resp.status_txt}")
            return url
        }
    }
}
