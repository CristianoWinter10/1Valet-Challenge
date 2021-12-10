package com.winterprojects.valetdevices.helpers

import com.winterprojects.valetdevices.domain.devices.dtos.DeviceDto
import com.winterprojects.valetdevices.domain.devices.models.DeviceModel

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
