package com.winterprojects.valetdevices.presentation.favorites

import com.winterprojects.valetdevices.domain.devices.models.DeviceFavoriteModel

interface OnRemoveFavoriteItemClickListener {
    fun onRemoveFavoriteItemClickListener(itemPosition: Int, deviceFavorite: DeviceFavoriteModel)
}