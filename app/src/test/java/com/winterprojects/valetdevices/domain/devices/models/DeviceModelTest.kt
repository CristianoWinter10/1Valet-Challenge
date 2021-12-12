package com.winterprojects.valetdevices.domain.devices.models

import com.winterprojects.valetdevices.helpers.getDeviceFavoriteModelTest
import com.winterprojects.valetdevices.helpers.getDeviceModelTest
import org.junit.Assert
import org.junit.Test

class DeviceModelTest {

    @Test
    fun `should cast device model to device favorite entity`(){
        //Arrange
        val deviceModelTest = getDeviceModelTest(true)
        val deviceFavoriteModelTest = getDeviceFavoriteModelTest()

        //Act
        val deviceFavoriteModel = deviceModelTest.toDeviceFavoriteModel()

        //Assert
        Assert.assertEquals(deviceFavoriteModel, deviceFavoriteModelTest)
    }
}