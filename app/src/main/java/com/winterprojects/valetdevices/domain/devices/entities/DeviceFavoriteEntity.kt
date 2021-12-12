package com.winterprojects.valetdevices.domain.devices.entities

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.winterprojects.valetdevices.domain.devices.models.DeviceFavoriteModel


@Entity(tableName = "DeviceFavorites")
data class DeviceFavoriteEntity(
    @PrimaryKey
    val id: String,
    val title: String,
    val description: String,
    val imageUrl: String
)


fun DeviceFavoriteEntity.toModel(): DeviceFavoriteModel {
    return DeviceFavoriteModel(
        id = this.id,
        title = this.title,
        description = this.description,
        imageUrl = this.imageUrl,
        isFavorite = true
    )
}

