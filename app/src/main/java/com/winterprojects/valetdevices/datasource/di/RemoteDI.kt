package com.winterprojects.valetdevices.datasource.di

import com.winterprojects.valetdevices.datasource.devices.DeviceClientApi
import org.koin.dsl.module
import retrofit2.Retrofit

object RemoteDI {
    val module = module {
        factory<DeviceClientApi> {
            get<Retrofit>().create(DeviceClientApi::class.java)
        }
    }
}