package com.winterprojects.valetdevices.datasource.devices

import com.winterprojects.valetdevices.domain.devices.models.DeviceModel

interface DeviceRemoteDatasource {
    suspend fun getDevices(): List<DeviceModel>
}