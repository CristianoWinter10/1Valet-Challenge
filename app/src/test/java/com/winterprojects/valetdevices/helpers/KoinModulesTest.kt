package com.winterprojects.valetdevices.helpers

import com.winterprojects.valetdevices.datasource.di.RemoteDI

object KoinModulesTest {
    val testModules = listOf(
        RetrofitTestDI.module,
        RemoteDI.module,
    )
}