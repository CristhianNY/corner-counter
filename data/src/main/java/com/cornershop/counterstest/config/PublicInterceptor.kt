package com.cornershop.counterstest.config

import okhttp3.Authenticator
import okhttp3.Request
import okhttp3.Response
import okhttp3.Route

class PublicInterceptor : Authenticator {

    override fun authenticate(
        route: Route?,
        response: Response
    ): Request? = response.request.newBuilder().build()
}