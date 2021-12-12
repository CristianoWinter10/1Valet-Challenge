package com.winterprojects.valetdevices.business.devices

import kotlinx.coroutines.flow.Flow

interface CheckDeviceIsAlreadyFavoriteUseCase {
    operator fun invoke(deviceId: String): Flow<Boolean>
}