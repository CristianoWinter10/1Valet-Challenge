package com.winterprojects.valetdevices.business.devices

import com.winterprojects.valetdevices.datasource.devices.DeviceRepository
import com.winterprojects.valetdevices.helpers.BaseTest
import com.winterprojects.valetdevices.helpers.StateResult
import com.winterprojects.valetdevices.helpers.getDeviceModelTest
import kotlinx.coroutines.runBlocking
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.koin.test.inject
import org.koin.test.mock.declareMock
import org.mockito.Mockito

class GetAllDevicesUseCaseTest: BaseTest() {
    private lateinit var deviceRepository: DeviceRepository

    private val getAllDevicesUseCase: GetAllDevicesUseCase by inject()

    @Before
    fun setup() {
        deviceRepository = declareMock()
    }

    @Test
    fun `should call get devices from device repository`() {
        runBlocking {
            //Arrange
            Mockito.`when`(deviceRepository.getAllDevices()).thenReturn(listOf())

            //Act
            getAllDevicesUseCase()

            //Assert
            Mockito.verify(deviceRepository, Mockito.only()).getAllDevices()
        }
    }

    @Test
    fun `should return empty data from getAllDevicesUseCase`() {
        runBlocking {
            //Arrange
            Mockito.`when`(deviceRepository.getAllDevices()).thenReturn(listOf())

            //Act
            val result = getAllDevicesUseCase()

            //Assert
            Assert.assertEquals(StateResult.Empty, result)
        }
    }

    @Test
    fun `should return loaded data from getAllDevicesUseCase`() {
        runBlocking {
            //Arrange
            Mockito.`when`(deviceRepository.getAllDevices()).thenReturn(listOf(getDeviceModelTest()))

            //Act
            val result = getAllDevicesUseCase()

            //Assert
            Assert.assertEquals(StateResult.Loaded(listOf(getDeviceModelTest())), result)
        }
    }

    @Test
    fun `should return error data from getAllDevicesUseCase`() {
        runBlocking {
            //Arrange
            Mockito.`when`(deviceRepository.getAllDevices()).thenReturn(null)

            //Act
            val result = getAllDevicesUseCase()

            //Assert
            Assert.assertEquals(StateResult.ErrorState::class.toString(), result::class.toString())
        }
    }
}