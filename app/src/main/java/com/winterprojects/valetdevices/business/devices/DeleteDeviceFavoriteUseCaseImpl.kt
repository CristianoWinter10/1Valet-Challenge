package com.winterprojects.valetdevices.business.devices

import com.winterprojects.valetdevices.datasource.devices.DeviceRepository
import com.winterprojects.valetdevices.domain.devices.models.DeviceFavoriteModel
import com.winterprojects.valetdevices.helpers.StateResult

class DeleteDeviceFavoriteUseCaseImpl(private val repository: DeviceRepository) :
    DeleteDeviceFavoriteUseCase {
    override suspend operator fun invoke(deviceFavorite: DeviceFavoriteModel): StateResult<Boolean> {
        return try {
            repository.deleteDeviceFavorite(deviceFavorite)
            return StateResult.Loaded(true)
        } catch (ex: Exception) {
            StateResult.ErrorState(ex.localizedMessage)
        }
    }
}