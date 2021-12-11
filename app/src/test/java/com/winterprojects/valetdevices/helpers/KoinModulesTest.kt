package com.winterprojects.valetdevices.helpers

import com.winterprojects.valetdevices.datasource.di.DatasourceDI
import com.winterprojects.valetdevices.datasource.di.RemoteDI
import com.winterprojects.valetdevices.datasource.di.RetrofitTestDI

object KoinModulesTest {
    val testModules = listOf(
        RetrofitTestDI.module,
        RemoteDI.module,
        DatasourceDI.module
    )
}