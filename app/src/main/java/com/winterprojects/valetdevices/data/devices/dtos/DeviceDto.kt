package com.winterprojects.valetdevices.data.devices.dtos

import com.winterprojects.valetdevices.data.devices.models.DeviceModel

data class DeviceDto(
    val currency: String,
    val description: String,
    val id: String,
    val price: Int,
    val title: String,
    val type: String,
    val imageUrl: String,
    val isFavorite: Boolean
)

fun DeviceDto.toModel(): DeviceModel {
    return DeviceModel(
        currency = this.currency,
        description = this.description,
        id = this.id,
        price = this.price,
        title = this.title,
        type = this.type,
        imageUrl = this.imageUrl,
        isFavorite = this.isFavorite
    )
}