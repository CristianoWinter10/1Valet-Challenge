package com.winterprojects.valetdevices.database.devices

import android.content.Context
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.winterprojects.valetdevices.datasource.database.ValetDevicesDatabase
import com.winterprojects.valetdevices.datasource.devices.DeviceDao
import com.winterprojects.valetdevices.domain.devices.entities.DeviceFavoriteEntity
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.runBlocking
import org.junit.After
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import java.io.IOException

@RunWith(AndroidJUnit4::class)
class SimpleEntityReadWriteTest {

    private lateinit var deviceDao: DeviceDao
    private lateinit var db: ValetDevicesDatabase

    @Before
    fun createDb() {
        val context = ApplicationProvider.getApplicationContext<Context>()
        db = Room.inMemoryDatabaseBuilder(
            context, ValetDevicesDatabase::class.java
        ).build()
        deviceDao = db.deviceDao()
    }

    @After
    @Throws(IOException::class)
    fun closeDb() {
        db.close()
    }

    @Test
    @Throws(Exception::class)
    fun shouldInsertAndGetDataInserted() {
        runBlocking {
            val deviceFavoriteEntity = DeviceFavoriteEntity(
                "1",
                "Device 1",
                "Test",
                ""
            )

            deviceDao.upInsert(deviceFavoriteEntity)

            val devices = deviceDao.fetchAll()

            Assert.assertEquals(1, devices.size)
        }
    }

    @Test
    @Throws(Exception::class)
    fun shouldDeleteAllData() {
        runBlocking {
            val deviceFavoriteEntity = DeviceFavoriteEntity(
                "1",
                "Device 1",
                "Test",
                ""
            )

            deviceDao.upInsert(deviceFavoriteEntity)
            deviceDao.delete(deviceFavoriteEntity)
            val devices = deviceDao.fetchAll()

            Assert.assertEquals(0, devices.size)
        }
    }

    @Test
    @Throws(Exception::class)
    fun shouldReturnIsFavoriteAllData() {
        runBlocking {
            val deviceFavoriteEntity = DeviceFavoriteEntity(
                "1",
                "Device 1",
                "Test",
                ""
            )

            deviceDao.upInsert(deviceFavoriteEntity)

            val isFavorite = deviceDao.checkIsFavorite(deviceFavoriteEntity.id).first()

            Assert.assertEquals(true, isFavorite)

        }
    }
}