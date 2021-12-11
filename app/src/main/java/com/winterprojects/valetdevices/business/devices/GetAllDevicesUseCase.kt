package com.winterprojects.valetdevices.business.devices

import com.winterprojects.valetdevices.helpers.StateResult
import com.winterprojects.valetdevices.domain.devices.models.DeviceModel

interface GetAllDevicesUseCase {
    suspend operator fun invoke(): StateResult<List<DeviceModel>>
}