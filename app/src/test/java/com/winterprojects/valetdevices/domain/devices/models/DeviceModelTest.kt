package com.winterprojects.valetdevices.domain.devices.models

import com.winterprojects.valetdevices.domain.devices.dtos.toModel
import com.winterprojects.valetdevices.helpers.getDeviceDtoTest
import com.winterprojects.valetdevices.helpers.getDeviceFavoriteEntityTest
import com.winterprojects.valetdevices.helpers.getDeviceModelTest
import org.junit.Assert
import org.junit.Test

class DeviceModelTest {

    @Test
    fun `should cast device model to device favorite entity`(){
        //Arrange
        val deviceModelTest = getDeviceModelTest()
        val deviceFavoriteEntityTest = getDeviceFavoriteEntityTest()

        //Act
        val deviceFavoriteEntity = deviceModelTest.toDeviceFavoriteEntity()

        //Assert
        Assert.assertEquals(deviceFavoriteEntity, deviceFavoriteEntityTest)
    }
}