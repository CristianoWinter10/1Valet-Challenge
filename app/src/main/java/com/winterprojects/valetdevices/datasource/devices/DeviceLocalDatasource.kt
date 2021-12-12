package com.winterprojects.valetdevices.datasource.devices

import com.winterprojects.valetdevices.domain.devices.models.DeviceFavoriteModel
import kotlinx.coroutines.flow.Flow

interface DeviceLocalDatasource {
    suspend fun fetchAll(): List<DeviceFavoriteModel>

    suspend fun upInsert(deviceFavorite: DeviceFavoriteModel): Boolean

    suspend fun delete(deviceFavorite: DeviceFavoriteModel)

    fun checkDeviceIsAlreadyFavorite(deviceId: String): Flow<Boolean>

    suspend fun fetchAllFavoriteDevices(): List<DeviceFavoriteModel>

}