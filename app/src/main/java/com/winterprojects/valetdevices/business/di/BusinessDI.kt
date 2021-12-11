package com.winterprojects.valetdevices.business.di

import com.winterprojects.valetdevices.business.devices.GetAllDevicesUseCase
import com.winterprojects.valetdevices.business.devices.GetAllDevicesUseCaseImpl
import org.koin.dsl.module

object BusinessDI {
    val module = module {
        single<GetAllDevicesUseCase> {
            GetAllDevicesUseCaseImpl(get())
        }
    }
}