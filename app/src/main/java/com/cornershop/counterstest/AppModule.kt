package com.cornershop.counterstest

import android.util.Log
import com.cornershop.counterstest.config.*
import org.koin.dsl.module

internal val appModule = module {
    single<Reporter> {
        object : Reporter {
            override fun initialize(initializer: ReporterInitializer) {}

            override fun log(
                key: String,
                value: String,
                logSeverityLevel: ReporterLogSeverityLevel
            ) {
                Log.d(key, value)
            }

            override fun exception(
                exception: Exception,
                logSeverityLevel: ReporterLogSeverityLevel
            ) {
                Log.e("Error", exception.toString())
            }

            override fun recordBreadcrumb(breadCrumb: ReporterBreadCrumb) {}

            override fun setUserData(userData: ReporterUserData) {}
        }
    }
}