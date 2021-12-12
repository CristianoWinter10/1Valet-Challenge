package com.winterprojects.valetdevices.business.devices

import com.winterprojects.valetdevices.domain.devices.models.DeviceFavoriteModel
import com.winterprojects.valetdevices.helpers.StateResult

interface DeleteDeviceFavoriteUseCase {
    suspend operator fun invoke(deviceFavorite: DeviceFavoriteModel): StateResult<Boolean>
}