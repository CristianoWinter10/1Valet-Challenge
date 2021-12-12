package com.winterprojects.valetdevices.presentation.deviceDetails

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.winterprojects.valetdevices.domain.devices.models.DeviceModel

class DeviceDetailsViewModel(device: DeviceModel) : ViewModel() {
    val deviceLiveData: LiveData<DeviceModel>
        get() = deviceMutableLiveData

    private val deviceMutableLiveData = MutableLiveData<DeviceModel>()

    init {
        deviceMutableLiveData.value = device
    }
}