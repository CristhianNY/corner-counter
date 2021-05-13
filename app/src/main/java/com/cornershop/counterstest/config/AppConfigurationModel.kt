package com.cornershop.counterstest.config

import com.cornershop.counterstest.config.ModeTypeModel
import org.koin.core.module.Module

data class AppConfigurationModel(
    val mode: ModeTypeModel,
    val baseUrl: String,
    val versionCode: Int,
    val versionName: String,
    val moduleList: List<Module>
)