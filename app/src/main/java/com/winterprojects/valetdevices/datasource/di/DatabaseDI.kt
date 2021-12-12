package com.winterprojects.valetdevices.datasource.di

import androidx.room.Room
import com.winterprojects.valetdevices.datasource.database.ValetDevicesDatabase
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

object DatabaseDI {
    val module = module {
        single {
            Room.databaseBuilder(
                androidContext(),
                ValetDevicesDatabase::class.java,
                ValetDevicesDatabase.DATABASE_NAME
            ).build()
        }

        single {
            get<ValetDevicesDatabase>().deviceDao()
        }
    }
}