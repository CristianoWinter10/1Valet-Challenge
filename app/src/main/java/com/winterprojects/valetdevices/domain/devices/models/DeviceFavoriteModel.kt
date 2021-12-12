package com.winterprojects.valetdevices.domain.devices.models

import androidx.room.Entity


@Entity
data class DeviceFavoriteModel(
    val id: String,
    val title: String,
    val description: String,
    val imageUrl: String,
    var isFavorite: Boolean
)

