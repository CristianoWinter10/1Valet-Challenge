package com.winterprojects.valetdevices.datasource.devices

import com.winterprojects.valetdevices.helpers.BaseTest
import com.winterprojects.valetdevices.helpers.getDeviceDtoTest
import com.winterprojects.valetdevices.helpers.getDeviceModelTest
import kotlinx.coroutines.runBlocking
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.koin.test.inject
import org.koin.test.mock.declareMock
import org.mockito.Mockito
import org.mockito.Mockito.only
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class DeviceRemoteDatasourceTest : BaseTest() {

    private lateinit var clientApi: DeviceClientApi

    private val deviceRemoteDatasource: DeviceRemoteDatasource by inject()

    @Before
    fun setup(){
        clientApi = declareMock()
    }

    @Test
    fun `should call get devices from device client`() {
        runBlocking {
            //Arrange
            Mockito.`when`(clientApi.getAllDevices()).thenReturn(listOf())

            //Act
            deviceRemoteDatasource.getAllDevices()

            //Assert
            Mockito.verify(clientApi, only()).getAllDevices()
        }
    }

    @Test
    fun `should return list device model from device client's get devices method`() {
        runBlocking {
            //Arrange
            Mockito.`when`(clientApi.getAllDevices()).thenReturn(listOf(
                getDeviceDtoTest()
            ))

            //Act
            val deviceModelList = deviceRemoteDatasource.getAllDevices()

            //Assert
            Assert.assertEquals(listOf(getDeviceModelTest()), deviceModelList)
        }
    }
}