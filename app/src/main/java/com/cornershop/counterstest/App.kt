package com.cornershop.counterstest

import android.app.Application
import androidx.lifecycle.LifecycleObserver
import com.cornershop.counterstest.BuildConfig.*
import com.cornershop.counterstest.config.AppConfigurationModel
import com.cornershop.counterstest.config.ModeTypeModel

class App : Application() , LifecycleObserver {

    override fun onCreate() {
        super.onCreate()

        initCore(
            AppConfigurationModel(
                ModeTypeModel.DEBUG,
                BASE_URL,
                VERSION_CODE,
                VERSION_NAME,
                getModules()
            )
        )
    }
}