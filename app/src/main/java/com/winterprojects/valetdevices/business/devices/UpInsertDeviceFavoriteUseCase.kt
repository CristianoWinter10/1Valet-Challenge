package com.winterprojects.valetdevices.business.devices

import com.winterprojects.valetdevices.domain.devices.models.DeviceFavoriteModel
import com.winterprojects.valetdevices.helpers.StateResult

interface UpInsertDeviceFavoriteUseCase {
    suspend operator fun invoke(deviceFavoriteModel: DeviceFavoriteModel): StateResult<Boolean>
}