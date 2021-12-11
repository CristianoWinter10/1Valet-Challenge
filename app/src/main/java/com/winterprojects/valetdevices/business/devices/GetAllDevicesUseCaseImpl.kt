package com.winterprojects.valetdevices.business.devices

import com.winterprojects.valetdevices.helpers.StateResult
import com.winterprojects.valetdevices.datasource.devices.DeviceRepository
import com.winterprojects.valetdevices.domain.devices.models.DeviceModel

class GetAllDevicesUseCaseImpl(private val deviceRepository: DeviceRepository) :
    GetAllDevicesUseCase {
    override suspend fun invoke(): StateResult<List<DeviceModel>> {
        return try {
            val devices = deviceRepository.getAllDevices()

            if (devices.isEmpty()) {
                StateResult.Empty
            } else {
                StateResult.Loaded(devices)
            }
        } catch (exception: Exception) {
            return StateResult.ErrorState(exception.localizedMessage)
        }
    }
}