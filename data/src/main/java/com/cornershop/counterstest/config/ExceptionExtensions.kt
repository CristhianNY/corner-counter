package com.cornershop.counterstest.config

import com.cornershop.counterstest.exception.Failure
import com.cornershop.counterstest.exception.RemoteTypeError
import com.cornershop.counterstest.functional.CustomResult
import com.squareup.moshi.JsonDataException
import retrofit2.HttpException
import java.net.HttpURLConnection
import java.security.InvalidParameterException

internal fun Exception.toRemoteError(handleError: (Int) -> Failure): CustomResult.Error<Failure> {
   // reporter.exception(this)
    return CustomResult.Error(
        when (this) {
            is NetworkException -> Failure.NetworkConnection
            is InvalidParameterException -> Failure.RemoteError(
                RemoteTypeError.INVALID_PARAMETER_REQUEST,
                this.message
            )
            is JsonDataException -> Failure.RemoteError(RemoteTypeError.INVALID_PARSER_ENTITY, this.message)
            is HttpException ->
                when (val code = this.code()) {
                    HttpURLConnection.HTTP_UNAUTHORIZED -> Failure.SessionExpired
                    else -> handleError(code)
                }
            else -> Failure.RemoteError(RemoteTypeError.GENERIC)
        }
    )
}