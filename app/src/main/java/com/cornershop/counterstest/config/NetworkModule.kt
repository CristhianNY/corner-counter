package com.cornershop.counterstest.config

import com.cornershop.counterstest.platform.NetworkHandler
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import okhttp3.Authenticator
import okhttp3.CertificatePinner
import okhttp3.OkHttpClient
import okhttp3.Protocol
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.core.qualifier.named
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import java.util.concurrent.TimeUnit

const val HTTPS_PREFIX = "https://"
const val BASE_PATH_URL = "baseUrl"
const val REMOTE_CLIENT_PUBLIC = "publicRetrofit"
internal const val CERTIFICATE_PINNER = "certificatePinner"
const val CERTIFICATE_FINGERPRINT = "certificateFingerprint"

private const val HTTP_CLIENT_TIME_OUT_SECONDS = 120L

val networkModule = module {
    single<NetworkStatus> { NetworkHandler(context = get()) }
    single<Authenticator> { PublicInterceptor() }

    single(named(CERTIFICATE_PINNER)) {
        CertificatePinner.Builder()
            .add(
                get<String>(named(BASE_PATH_URL)).removePrefix(
                    HTTPS_PREFIX
                ),
                get(named(CERTIFICATE_FINGERPRINT))
            )
            .build()
    }

    single<Retrofit>(named(REMOTE_CLIENT_PUBLIC)) {
        val logging = HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BODY
        }
        val moshi = Moshi.Builder()
            .add(KotlinJsonAdapterFactory())
            .build()
        val httpClient = OkHttpClient.Builder()
            .apply {
                readTimeout(HTTP_CLIENT_TIME_OUT_SECONDS, TimeUnit.SECONDS)
                writeTimeout(HTTP_CLIENT_TIME_OUT_SECONDS, TimeUnit.SECONDS)
                connectTimeout(HTTP_CLIENT_TIME_OUT_SECONDS, TimeUnit.SECONDS)
                protocols(listOf(Protocol.HTTP_2, Protocol.HTTP_1_1, Protocol.SPDY_3))
                interceptors().add(logging)
            }

        Retrofit.Builder()
            .baseUrl(get<String>(named(BASE_PATH_URL)))
            .client(httpClient.build())
            .addConverterFactory(MoshiConverterFactory.create(moshi))
            .build()
    }
}