package com.winterprojects.valetdevices.domain.devices.models

data class DeviceModel(
    val currency: String,
    val description: String,
    val id: String,
    val price: Double,
    val title: String,
    val type: String,
    val imageUrl: String,
    val isFavorite: Boolean
)