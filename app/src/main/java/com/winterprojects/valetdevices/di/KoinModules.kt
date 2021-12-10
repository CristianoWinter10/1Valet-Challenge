package com.winterprojects.valetdevices.di

import com.winterprojects.valetdevices.datasource.di.RemoteDI
import com.winterprojects.valetdevices.datasource.di.RetrofitDI

object KoinModules {
    val modules = listOf(
        RetrofitDI.module,
        RemoteDI.module
    )
}