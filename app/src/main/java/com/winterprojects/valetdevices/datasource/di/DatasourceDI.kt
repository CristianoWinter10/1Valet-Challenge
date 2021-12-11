package com.winterprojects.valetdevices.datasource.di

import com.winterprojects.valetdevices.datasource.devices.DeviceRemoteDatasource
import com.winterprojects.valetdevices.datasource.devices.DeviceRemoteDatasourceImpl
import org.koin.dsl.module

object DatasourceDI {
    val module = module {
        single<DeviceRemoteDatasource> {
            DeviceRemoteDatasourceImpl(get())
        }
    }
}
