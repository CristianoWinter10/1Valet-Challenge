package com.winterprojects.valetdevices.datasource.devices

import com.winterprojects.valetdevices.domain.devices.dtos.toModel
import com.winterprojects.valetdevices.domain.devices.models.DeviceModel

class DeviceRemoteDatasourceImpl(private val deviceClientApi: DeviceClientApi) :
    DeviceRemoteDatasource {
    override suspend fun getDevices(): List<DeviceModel> {
        return deviceClientApi.getAllDevices().map { it.toModel() }
    }
}