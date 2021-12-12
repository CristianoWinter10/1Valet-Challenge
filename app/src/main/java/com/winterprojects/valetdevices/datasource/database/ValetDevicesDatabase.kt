package com.winterprojects.valetdevices.datasource.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.winterprojects.valetdevices.datasource.database.ValetDevicesDatabase.Companion.VERSION
import com.winterprojects.valetdevices.datasource.devices.DeviceDao
import com.winterprojects.valetdevices.domain.devices.entities.DeviceFavoriteEntity

@Database(
    version = VERSION, entities = [
        DeviceFavoriteEntity::class
    ]
)
abstract class ValetDevicesDatabase : RoomDatabase() {

    abstract fun deviceDao(): DeviceDao

    companion object {
        const val VERSION = 1
        const val DATABASE_NAME = "valet_devices_database.db"
    }
}