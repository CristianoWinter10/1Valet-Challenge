package com.winterprojects.valetdevices.presentation.devices

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.Observer
import com.winterprojects.valetdevices.business.devices.GetAllDevicesUseCase
import com.winterprojects.valetdevices.domain.devices.models.DeviceModel
import com.winterprojects.valetdevices.helpers.BaseTest
import com.winterprojects.valetdevices.helpers.StateResult
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.test.TestCoroutineDispatcher
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.setMain
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.rules.TestRule
import org.junit.runner.RunWith
import org.koin.test.mock.declareMock
import org.mockito.Mockito.`when`
import org.mockito.Mockito.verify
import org.mockito.junit.MockitoJUnitRunner


@RunWith(MockitoJUnitRunner::class)
@OptIn(ExperimentalCoroutinesApi::class)
class DevicesViewModelTest : BaseTest() {
    @get:Rule
    var rule: TestRule = InstantTaskExecutorRule()

    private lateinit var getAllDevicesUseCase: GetAllDevicesUseCase

    private lateinit var devicesViewModel: DevicesViewModel

    private lateinit var observer: Observer<StateResult<List<DeviceModel>>>

    @Before
    @Throws(Exception::class)
    fun setUp() {
        Dispatchers.setMain(TestCoroutineDispatcher())

        observer = declareMock()
        getAllDevicesUseCase = declareMock()
    }

    @Test
    fun `should apply empty state`() = runBlocking {
        //Arrange
        `when`(getAllDevicesUseCase.invoke()).thenReturn(StateResult.Empty)
        devicesViewModel = DevicesViewModel(getAllDevicesUseCase)

        //Act
        devicesViewModel.devicesLiveData.observeForever(observer)

        //Assert
        verify(observer).onChanged(StateResult.Empty)
    }


    @Test
    fun `should apply loaded state`()  = runBlocking {
        //Arrange
        `when`(getAllDevicesUseCase.invoke()).thenReturn(StateResult.Loaded(listOf()))
        devicesViewModel = DevicesViewModel(getAllDevicesUseCase)

        //Act
        devicesViewModel.devicesLiveData.observeForever(observer)

        //Assert
        verify(observer).onChanged(StateResult.Loaded(listOf()))
    }

    @Test
    fun `should apply error state`()  = runBlocking {
        //Arrange
        `when`(getAllDevicesUseCase.invoke()).thenReturn(StateResult.ErrorState(""))
        devicesViewModel = DevicesViewModel(getAllDevicesUseCase)

        //Act
        devicesViewModel.devicesLiveData.observeForever(observer)

        //Assert
        verify(observer).onChanged(StateResult.ErrorState(""))
    }

    @After
    fun tearDown() {
        Dispatchers.resetMain()
    }
}