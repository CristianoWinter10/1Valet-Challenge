package com.winterprojects.valetdevices.data.devices.dtos

import com.winterprojects.valetdevices.getDeviceDtoTest
import com.winterprojects.valetdevices.getDeviceModelTest
import org.junit.Assert
import org.junit.Test

class DeviceDtoTest {

    @Test
    fun `should cast device dto to model`(){
        //Arrange
        val deviceModelTest = getDeviceModelTest()
        val deviceDtoTest = getDeviceDtoTest()
        //Act
        val deviceModel = deviceDtoTest.toModel()
        //Assert
        Assert.assertEquals(deviceModel, deviceModelTest)
    }
}