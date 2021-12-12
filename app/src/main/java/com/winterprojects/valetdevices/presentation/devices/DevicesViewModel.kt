package com.winterprojects.valetdevices.presentation.devices

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.winterprojects.valetdevices.business.devices.GetAllDevicesUseCase
import com.winterprojects.valetdevices.domain.devices.models.DeviceModel
import com.winterprojects.valetdevices.helpers.StateResult
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class DevicesViewModel(
    private val getAllDevicesUseCase: GetAllDevicesUseCase,
    private val ioDispatcher: CoroutineDispatcher = Dispatchers.IO
) : ViewModel() {


    private var currentListDevices: List<DeviceModel>? = null

    val devicesLiveData: StateFlow<StateResult<List<DeviceModel>>>
        get() = devicesMutableLiveData

    private val devicesMutableLiveData = MutableStateFlow<StateResult<List<DeviceModel>>>(StateResult.Loading)

    init {
        viewModelScope.launch {
            with(ioDispatcher) {
                getAllDevicesUseCase().let { result ->
                    currentListDevices = result.data
                    devicesMutableLiveData.emit(result)
                }
            }
        }
    }

    fun applyFilter(title: String) {
        viewModelScope.launch {
            currentListDevices?.let { devices ->
                devicesMutableLiveData.emit(StateResult.Loaded(devices.filter {
                    it.title.lowercase().contains(
                        title
                    )
                }))
            }
        }
    }
}