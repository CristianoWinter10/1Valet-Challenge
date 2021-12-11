package com.winterprojects.valetdevices.datasource.devices

import com.winterprojects.valetdevices.domain.devices.models.DeviceModel

class DeviceRepositoryImpl(private val deviceRemoteDatasource: DeviceRemoteDatasource) :
    DeviceRepository {
    override suspend fun getAllDevices(): List<DeviceModel> {
        return deviceRemoteDatasource.getAllDevices()
    }
}