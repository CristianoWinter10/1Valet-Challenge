package com.winterprojects.valetdevices.helpers

import com.winterprojects.valetdevices.domain.devices.dtos.DeviceDto
import com.winterprojects.valetdevices.domain.devices.entities.DeviceFavoriteEntity
import com.winterprojects.valetdevices.domain.devices.models.DeviceFavoriteModel
import com.winterprojects.valetdevices.domain.devices.models.DeviceModel

fun getDeviceDtoTest() = DeviceDto(
    currency = "USD",
    description = "",
    id = "1234",
    price = 20.00,
    title = "Sensor",
    type = "Sensor",
    imageUrl = "Test Sensor",
    isFavorite = false
)

fun getDeviceModelTest() = DeviceModel(
    currency = "USD",
    description = "",
    id = "1234",
    price = 20.00,
    title = "Sensor",
    type = "Sensor",
    imageUrl = "Test Sensor",
    isFavorite = false
)

fun getDeviceFavoriteEntityTest() = DeviceFavoriteEntity(
    description = "",
    id = "1234",
    title = "Sensor",
    imageUrl = "Test Sensor"
)

fun getDeviceFavoriteModelTest() = DeviceFavoriteModel(
    description = "",
    id = "1234",
    title = "Sensor",
    imageUrl = "Test Sensor",
    isFavorite = true
)
