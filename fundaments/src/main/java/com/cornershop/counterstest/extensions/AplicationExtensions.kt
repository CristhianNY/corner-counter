package com.cornershop.counterstest.extensions

import android.app.Application
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level.DEBUG
import org.koin.core.module.Module

fun Application.initDI(modules: List<Module>) {
    startKoin {
        androidLogger(DEBUG)
        androidContext(this@initDI)
        modules(modules)
    }
}