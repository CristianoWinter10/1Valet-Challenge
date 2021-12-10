package com.winterprojects.valetdevices.datasource.devices

import com.winterprojects.valetdevices.domain.devices.dtos.DeviceDto
import retrofit2.http.GET

private const val BASE_URL = "devices"

interface DeviceClientApi {

    @GET(BASE_URL)
    suspend fun getAllDevices(): List<DeviceDto>

}