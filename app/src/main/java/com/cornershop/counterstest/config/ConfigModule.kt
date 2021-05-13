package com.cornershop.counterstest.config

import org.koin.core.qualifier.named
import org.koin.dsl.module

fun configModule(
    mode: ModeTypeModel,
    baseUrl: String
) = module {
    single { mode }
    single(named(BASE_PATH_URL)) { baseUrl }
}