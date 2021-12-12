package com.winterprojects.valetdevices.business.devices

import com.winterprojects.valetdevices.domain.devices.models.DeviceModel
import com.winterprojects.valetdevices.helpers.StateResult

interface UpdateDeviceFavoriteStatusUseCase {
    suspend operator fun invoke(device: DeviceModel): StateResult<Boolean>
}