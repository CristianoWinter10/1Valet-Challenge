package com.winterprojects.valetdevices.presentation.devices

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.winterprojects.valetdevices.business.devices.GetAllDevicesUseCase
import com.winterprojects.valetdevices.domain.devices.models.DeviceModel
import com.winterprojects.valetdevices.helpers.StateResult
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class DevicesViewModel(
    private val getAllDevicesUseCase: GetAllDevicesUseCase,
    private val ioDispatcher: CoroutineDispatcher = Dispatchers.IO
) : ViewModel() {

    val devicesLiveData: LiveData<StateResult<List<DeviceModel>>>
        get() = devicesMutableLiveData

    private val devicesMutableLiveData = MutableLiveData<StateResult<List<DeviceModel>>>()

    init {
        viewModelScope.launch {
            devicesMutableLiveData.postValue(StateResult.Loading)

            with(ioDispatcher) {
                getAllDevicesUseCase().let { result ->
                    devicesMutableLiveData.postValue(result)
                }
            }
        }
    }
}