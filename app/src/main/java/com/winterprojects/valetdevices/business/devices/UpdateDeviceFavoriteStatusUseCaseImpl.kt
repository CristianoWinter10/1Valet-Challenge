package com.winterprojects.valetdevices.business.devices

import com.winterprojects.valetdevices.datasource.devices.DeviceRepository
import com.winterprojects.valetdevices.domain.devices.models.DeviceModel
import com.winterprojects.valetdevices.domain.devices.models.toDeviceFavoriteModel
import com.winterprojects.valetdevices.helpers.StateResult

class UpdateDeviceFavoriteStatusUseCaseImpl(private val repository: DeviceRepository) :
    UpdateDeviceFavoriteStatusUseCase {
    override suspend operator fun invoke(device: DeviceModel): StateResult<Boolean> {
        return try {
            val deviceFavorite = device.toDeviceFavoriteModel()

            if (deviceFavorite.isFavorite) {
                repository.upInsertDeviceFavorite(deviceFavorite)

            } else {
                repository.deleteDeviceFavorite(deviceFavorite)
            }

            StateResult.Loaded(true)
        } catch (ex: Exception) {
            StateResult.ErrorState(ex.localizedMessage)
        }
    }
}