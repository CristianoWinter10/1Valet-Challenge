package com.winterprojects.valetdevices.datasource.di

import com.winterprojects.valetdevices.datasource.devices.DeviceLocalDatasource
import com.winterprojects.valetdevices.datasource.devices.DeviceLocalDatasourceImpl
import com.winterprojects.valetdevices.datasource.devices.DeviceRemoteDatasource
import com.winterprojects.valetdevices.datasource.devices.DeviceRemoteDatasourceImpl
import com.winterprojects.valetdevices.datasource.devices.DeviceRepository
import com.winterprojects.valetdevices.datasource.devices.DeviceRepositoryImpl
import org.koin.dsl.module

object DatasourceDI {
    val module = module {
        single<DeviceRemoteDatasource> {
            DeviceRemoteDatasourceImpl(get())
        }

        single<DeviceLocalDatasource> {
            DeviceLocalDatasourceImpl(get())
        }

        single<DeviceRepository> {
            DeviceRepositoryImpl(get(), get())
        }
    }
}
