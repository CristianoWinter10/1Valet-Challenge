package com.winterprojects.valetdevices.business.di

import com.winterprojects.valetdevices.business.devices.CheckDeviceIsAlreadyFavoriteUseCase
import com.winterprojects.valetdevices.business.devices.CheckDeviceIsAlreadyFavoriteUseCaseImpl
import com.winterprojects.valetdevices.business.devices.DeleteDeviceFavoriteUseCase
import com.winterprojects.valetdevices.business.devices.DeleteDeviceFavoriteUseCaseImpl
import com.winterprojects.valetdevices.business.devices.FetchAllDeviceFavoriteUseCase
import com.winterprojects.valetdevices.business.devices.FetchAllDeviceFavoriteUseCaseImpl
import com.winterprojects.valetdevices.business.devices.GetAllDevicesUseCase
import com.winterprojects.valetdevices.business.devices.GetAllDevicesUseCaseImpl
import com.winterprojects.valetdevices.business.devices.UpInsertDeviceFavoriteUseCase
import com.winterprojects.valetdevices.business.devices.UpInsertDeviceFavoriteUseCaseImpl
import com.winterprojects.valetdevices.business.devices.UpdateDeviceFavoriteStatusUseCase
import com.winterprojects.valetdevices.business.devices.UpdateDeviceFavoriteStatusUseCaseImpl
import org.koin.dsl.module

object BusinessDI {
    val module = module {
        single<GetAllDevicesUseCase> {
            GetAllDevicesUseCaseImpl(get())
        }

        single<CheckDeviceIsAlreadyFavoriteUseCase> {
            CheckDeviceIsAlreadyFavoriteUseCaseImpl(get())
        }

        single<DeleteDeviceFavoriteUseCase> {
            DeleteDeviceFavoriteUseCaseImpl(get())
        }

        single<FetchAllDeviceFavoriteUseCase> {
            FetchAllDeviceFavoriteUseCaseImpl(get())
        }

        single<UpdateDeviceFavoriteStatusUseCase> {
            UpdateDeviceFavoriteStatusUseCaseImpl(get())
        }

        single<UpInsertDeviceFavoriteUseCase> {
            UpInsertDeviceFavoriteUseCaseImpl(get())
        }
    }
}