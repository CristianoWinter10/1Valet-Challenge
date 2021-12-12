package com.winterprojects.valetdevices.datasource.devices

import com.winterprojects.valetdevices.helpers.BaseTest
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test
import org.koin.test.mock.declareMock
import org.mockito.Mockito
import org.mockito.Mockito.only

class DeviceRepositoryTest: BaseTest() {

    private lateinit var deviceRemoteDatasource: DeviceRemoteDatasource

    private lateinit var deviceLocalDatasource: DeviceLocalDatasource

    private lateinit var deviceRepository: DeviceRepository

    @Before
    fun setup() {
        deviceRemoteDatasource = declareMock()
        deviceLocalDatasource = declareMock()
        deviceRepository = DeviceRepositoryImpl(deviceRemoteDatasource, deviceLocalDatasource)
    }

    @Test
    fun `should call get devices from device remote datasource`() {
        runBlocking {
            //Arrange
            Mockito.`when`(deviceRemoteDatasource.getAllDevices()).thenReturn(listOf())

            //Act
            deviceRepository.getAllDevices()

            //Assert
            Mockito.verify(deviceRemoteDatasource, only()).getAllDevices()
        }
    }
}