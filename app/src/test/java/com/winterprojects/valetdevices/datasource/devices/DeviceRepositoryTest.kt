package com.winterprojects.valetdevices.datasource.devices

import com.winterprojects.valetdevices.helpers.BaseTest
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.koin.test.inject
import org.koin.test.mock.declareMock
import org.mockito.Mockito
import org.mockito.Mockito.only
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class DeviceRepositoryTest : BaseTest() {

    private lateinit var deviceRemoteDatasource: DeviceRemoteDatasource

    private val deviceRepository: DeviceRepository by inject()

    @Before
    fun setup() {
        deviceRemoteDatasource = declareMock()
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