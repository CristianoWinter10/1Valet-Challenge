package com.winterprojects.valetdevices.datasource.devices

import com.winterprojects.valetdevices.domain.devices.entities.toModel
import com.winterprojects.valetdevices.domain.devices.models.DeviceFavoriteModel
import com.winterprojects.valetdevices.domain.devices.models.toEntity
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.distinctUntilChanged

class DeviceLocalDatasourceImpl(private val deviceDao: DeviceDao) : DeviceLocalDatasource {
    override suspend fun fetchAll(): List<DeviceFavoriteModel> {
        return deviceDao.fetchAll().map { it.toModel() }
    }

    override suspend fun upInsert(deviceFavorite: DeviceFavoriteModel): Boolean {
        return deviceDao.upInsert(deviceFavorite.toEntity()) > 0
    }

    override suspend fun delete(deviceFavorite: DeviceFavoriteModel) {
        return deviceDao.delete(deviceFavorite.toEntity())
    }

    override fun checkDeviceIsAlreadyFavorite(deviceId: String): Flow<Boolean> {
        return deviceDao.checkIsFavorite(deviceId).distinctUntilChanged()
    }

    override suspend fun fetchAllFavoriteDevices(): List<DeviceFavoriteModel> {
        return deviceDao.fetchAll().map { it.toModel() }
    }

}