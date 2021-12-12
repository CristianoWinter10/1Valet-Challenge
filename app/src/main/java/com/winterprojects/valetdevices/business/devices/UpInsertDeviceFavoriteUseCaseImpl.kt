package com.winterprojects.valetdevices.business.devices

import com.winterprojects.valetdevices.datasource.devices.DeviceRepository
import com.winterprojects.valetdevices.domain.devices.models.DeviceFavoriteModel
import com.winterprojects.valetdevices.helpers.StateResult

class UpInsertDeviceFavoriteUseCaseImpl(private val repository: DeviceRepository) :
    UpInsertDeviceFavoriteUseCase {
    override suspend operator fun invoke(deviceFavoriteModel: DeviceFavoriteModel): StateResult<Boolean> {
        return try {
            return StateResult.Loaded(repository.upInsertDeviceFavorite(deviceFavoriteModel))
        } catch (ex: Exception) {
            StateResult.ErrorState(ex.localizedMessage)
        }
    }
}