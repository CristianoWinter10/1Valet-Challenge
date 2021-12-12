package com.winterprojects.valetdevices.domain.devices.models

import android.os.Parcelable
import com.winterprojects.valetdevices.domain.devices.entities.DeviceFavoriteEntity
import kotlinx.parcelize.Parcelize

@Parcelize
data class DeviceModel(
    val currency: String,
    val description: String,
    val id: String,
    val price: Double,
    val title: String,
    val type: String,
    val imageUrl: String,
    val isFavorite: Boolean
) : Parcelable

fun DeviceModel.toDeviceFavoriteEntity(): DeviceFavoriteEntity {
    return DeviceFavoriteEntity(
        id = this.id,
        title = this.title,
        description = this.description,
        imageUrl = this.imageUrl
    )
}