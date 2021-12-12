package com.winterprojects.valetdevices.domain.devices.models

import androidx.room.Entity
import com.winterprojects.valetdevices.domain.devices.entities.DeviceFavoriteEntity

@Entity
data class DeviceFavoriteModel(
    val id: String,
    val title: String,
    val description: String,
    val imageUrl: String,
    var isFavorite: Boolean
)

fun DeviceFavoriteModel.toEntity(): DeviceFavoriteEntity {
    return DeviceFavoriteEntity(
        id = this.id,
        title = this.title,
        description = this.description,
        imageUrl = this.imageUrl
    )
}


