package com.winterprojects.valetdevices.domain.devices.entities

import com.winterprojects.valetdevices.helpers.getDeviceFavoriteEntityTest
import com.winterprojects.valetdevices.helpers.getDeviceFavoriteModelTest
import org.junit.Assert
import org.junit.Test

class DeviceFavoriteEntityTest {

    @Test
    fun `should cast device favorite entity to device favorite model`(){
        //Arrange
        val deviceFavoriteModelTest = getDeviceFavoriteModelTest()
        val deviceFavoriteEntityTest = getDeviceFavoriteEntityTest()

        //Act
        val deviceFavoriteModel = deviceFavoriteEntityTest.toModel()

        //Assert
        Assert.assertEquals(deviceFavoriteModel, deviceFavoriteModelTest)
    }
}