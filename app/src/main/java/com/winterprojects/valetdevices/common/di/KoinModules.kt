package com.winterprojects.valetdevices.common.di

import com.winterprojects.valetdevices.business.di.BusinessDI
import com.winterprojects.valetdevices.datasource.di.DatasourceDI
import com.winterprojects.valetdevices.datasource.di.RemoteDI
import com.winterprojects.valetdevices.datasource.di.RetrofitDI
import com.winterprojects.valetdevices.presentation.di.PresentationDI

object KoinModules {
    val modules = listOf(
        RetrofitDI.module,
        RemoteDI.module,
        DatasourceDI.module,
        BusinessDI.module,
        PresentationDI.module
    )
}