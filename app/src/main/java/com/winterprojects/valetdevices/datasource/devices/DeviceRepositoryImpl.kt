package com.winterprojects.valetdevices.datasource.devices

import com.winterprojects.valetdevices.domain.devices.models.DeviceFavoriteModel
import com.winterprojects.valetdevices.domain.devices.models.DeviceModel
import kotlinx.coroutines.flow.Flow

class DeviceRepositoryImpl(
    private val deviceRemoteDatasource: DeviceRemoteDatasource,
    private val deviceLocalDatasource: DeviceLocalDatasource
) : DeviceRepository {
    override suspend fun getAllDevices(): List<DeviceModel> {
        return deviceRemoteDatasource.getAllDevices()
    }

    override suspend fun fetchAllFavoriteDevices(): List<DeviceFavoriteModel> {
        return deviceLocalDatasource.fetchAllFavoriteDevices()
    }

    override fun checkDeviceIsAlreadyFavorite(deviceId: String): Flow<Boolean> {
        return deviceLocalDatasource.checkDeviceIsAlreadyFavorite(deviceId)
    }

    override suspend fun upInsertDeviceFavorite(deviceFavoriteModel: DeviceFavoriteModel): Boolean {
        return deviceLocalDatasource.upInsert(deviceFavoriteModel)
    }

    override suspend fun deleteDeviceFavorite(deviceFavoriteModel: DeviceFavoriteModel) {
        deviceLocalDatasource.delete(deviceFavoriteModel)
    }
}