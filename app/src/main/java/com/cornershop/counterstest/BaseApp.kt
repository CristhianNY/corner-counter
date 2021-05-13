package com.cornershop.counterstest

import android.app.Application
import com.cornershop.counterstest.config.AppConfigurationModel
import com.cornershop.counterstest.config.configModule
import com.cornershop.counterstest.extensions.initDI
import org.koin.core.module.Module

fun Application.initCore(data: AppConfigurationModel) {
    val modules: MutableList<Module> = getModules()
    with(data) {
        modules.add(configModule(data.mode, baseUrl))
        if (moduleList.isNotEmpty()) {
            modules.addAll(moduleList)
        }
    }
    initDI(modules)
}