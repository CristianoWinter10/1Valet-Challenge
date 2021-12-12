package com.winterprojects.valetdevices.business.devices

import com.winterprojects.valetdevices.datasource.devices.DeviceRepository
import com.winterprojects.valetdevices.domain.devices.models.DeviceFavoriteModel
import com.winterprojects.valetdevices.helpers.StateResult

class FetchAllDeviceFavoriteUseCaseImpl(private val deviceRepository: DeviceRepository) :
    FetchAllDeviceFavoriteUseCase {
    override suspend operator fun invoke(): StateResult<MutableList<DeviceFavoriteModel>> {
        return try {
            val favorites = deviceRepository.fetchAllFavoriteDevices()

            if (favorites.isNotEmpty()) {
                StateResult.Loaded(favorites as MutableList<DeviceFavoriteModel>)
            } else {
                StateResult.Empty
            }
        } catch (ex: Exception) {
            StateResult.ErrorState(ex.localizedMessage)
        }
    }
}