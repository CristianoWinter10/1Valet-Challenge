package com.winterprojects.valetdevices.datasource.devices

import com.winterprojects.valetdevices.domain.devices.models.DeviceFavoriteModel
import com.winterprojects.valetdevices.domain.devices.models.DeviceModel
import kotlinx.coroutines.flow.Flow

interface DeviceRepository {
    suspend fun getAllDevices(): List<DeviceModel>

    fun checkDeviceIsAlreadyFavorite(deviceId: String): Flow<Boolean>

    suspend fun upInsertDeviceFavorite(deviceFavoriteModel: DeviceFavoriteModel): Boolean

    suspend fun deleteDeviceFavorite(deviceFavoriteModel: DeviceFavoriteModel)

    suspend fun fetchAllFavoriteDevices(): List<DeviceFavoriteModel>
}