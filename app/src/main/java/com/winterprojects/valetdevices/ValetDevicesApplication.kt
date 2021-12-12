package com.winterprojects.valetdevices

import android.app.Application
import com.winterprojects.valetdevices.common.di.KoinModules
import org.koin.core.context.startKoin

class ValetDevicesApplication: Application() {
    override fun onCreate() {
        super.onCreate()

        initializeKoin()
    }

    private fun initializeKoin() {
        startKoin {
            modules(
                KoinModules.modules
            )
        }
    }
}