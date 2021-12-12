package com.winterprojects.valetdevices.presentation.deviceDetails

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.winterprojects.valetdevices.business.devices.CheckDeviceIsAlreadyFavoriteUseCase
import com.winterprojects.valetdevices.business.devices.UpdateDeviceFavoriteStatusUseCase
import com.winterprojects.valetdevices.domain.devices.models.DeviceModel
import com.winterprojects.valetdevices.helpers.StateResult
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class DeviceDetailsViewModel(
    device: DeviceModel,
    private val checkDeviceIsAlreadyFavoriteUseCase: CheckDeviceIsAlreadyFavoriteUseCase,
    private val updateDeviceFavoriteStatusUseCase: UpdateDeviceFavoriteStatusUseCase,
    private val ioDispatcher: CoroutineDispatcher = Dispatchers.IO

) : ViewModel() {

    val deviceLiveData: LiveData<DeviceModel>
        get() = deviceMutableLiveData

    private val deviceMutableLiveData = MutableLiveData<DeviceModel>()

    init {
        viewModelScope.launch {
            deviceMutableLiveData.value = device
            withContext(ioDispatcher){
                keepCheckingDeviceIsFavorite(device.id, device)
            }
        }
    }

    private suspend fun keepCheckingDeviceIsFavorite(
        deviceId: String,
        device: DeviceModel
    ) {
        checkDeviceIsAlreadyFavoriteUseCase(deviceId).collectLatest { isFavorite ->
            device.isFavorite = isFavorite
            deviceMutableLiveData.postValue(device)
        }
    }

    fun updateFavoriteStatus() {
        deviceLiveData.value?.let { device ->
            viewModelScope.launch {
                withContext(ioDispatcher) {

                    device.isFavorite = !device.isFavorite

                    updateDeviceFavoriteStatusUseCase(device).let { result ->
                        when (result) {
                            is StateResult.ErrorState -> {
                                device.isFavorite = !device.isFavorite
                            }
                            is StateResult.Loaded -> {
                                deviceMutableLiveData.postValue(device)
                            }
                            else -> {
                                device.isFavorite = !device.isFavorite
                            }
                        }

                        deviceMutableLiveData.postValue(device)
                    }
                }
            }
        }
    }
}