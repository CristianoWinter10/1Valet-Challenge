package com.winterprojects.valetdevices.datasource.devices

import com.winterprojects.valetdevices.helpers.BaseTest
import kotlinx.coroutines.runBlocking
import org.junit.Assert
import org.junit.Test
import org.koin.test.inject
import retrofit2.Retrofit

class DeviceClientApiTest: BaseTest() {

    private val retrofit: Retrofit by inject()

    @Test
    fun `should get device list`() = runBlocking {

        //Arrange
        val client = retrofit.create(DeviceClientApi::class.java)

        //Act
        val devices = client.getAllDevices()

        //Assert
        Assert.assertEquals(devices.size, 2)
    }
}

