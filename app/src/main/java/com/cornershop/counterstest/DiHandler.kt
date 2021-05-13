package com.cornershop.counterstest

import com.cornershop.counterstest.config.networkModule
import com.cornershop.counterstest.di.data.counterDataModule
import com.cornershop.counterstest.di.domain.counterDomainModule
import org.koin.core.module.Module

internal fun getModules() = mutableListOf<Module>().apply {
    addAll(getDomainModules())
    addAll(getDataModules())
    addAll(getPresentationModules())
    addAll(getCoreModule())
}

private fun getPresentationModules() =
    listOf(
        appModule
    )

private fun getDomainModules() =
    listOf(
        counterDomainModule
    )

private fun getDataModules() =
    listOf(
        counterDataModule
    )

private fun getCoreModule() =
    listOf(networkModule)