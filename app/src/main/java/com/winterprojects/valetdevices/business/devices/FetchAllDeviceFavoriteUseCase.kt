package com.winterprojects.valetdevices.business.devices

import com.winterprojects.valetdevices.domain.devices.models.DeviceFavoriteModel
import com.winterprojects.valetdevices.helpers.StateResult


interface FetchAllDeviceFavoriteUseCase {
    suspend operator fun invoke(): StateResult<MutableList<DeviceFavoriteModel>>
}