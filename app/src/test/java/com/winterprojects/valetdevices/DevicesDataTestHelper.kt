package com.winterprojects.valetdevices

import com.winterprojects.valetdevices.data.devices.dtos.DeviceDto
import com.winterprojects.valetdevices.data.devices.models.DeviceModel

fun getDeviceDtoTest() = DeviceDto(
    currency = "USD",
    description = "",
    id = "1234",
    price = 20,
    title = "Sensor",
    type = "Sensor",
    imageUrl = "Test Sensor",
    isFavorite = false
)

fun getDeviceModelTest() = DeviceModel(
    currency = "USD",
    description = "",
    id = "1234",
    price = 20,
    title = "Sensor",
    type = "Sensor",
    imageUrl = "Test Sensor",
    isFavorite = false
)
