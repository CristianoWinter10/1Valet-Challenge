package com.winterprojects.valetdevices.business.devices

import com.winterprojects.valetdevices.datasource.devices.DeviceRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf

class CheckDeviceIsAlreadyFavoriteUseCaseImpl(private val deviceRepository: DeviceRepository) :
    CheckDeviceIsAlreadyFavoriteUseCase {
    override operator fun invoke(deviceId: String): Flow<Boolean> {
        return try {
            deviceRepository.checkDeviceIsAlreadyFavorite(deviceId)
        } catch (ex: Exception) {
            flowOf(false)
        }
    }
}