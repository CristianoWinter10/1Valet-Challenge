package com.winterprojects.valetdevices.presentation.devices

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.Observer
import com.winterprojects.valetdevices.domain.devices.models.DeviceModel
import com.winterprojects.valetdevices.helpers.BaseTest
import com.winterprojects.valetdevices.helpers.getDeviceModelTest
import com.winterprojects.valetdevices.presentation.deviceDetails.DeviceDetailsViewModel
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
import org.mockito.Mockito.notNull
import org.mockito.Mockito.verify
import org.mockito.junit.MockitoJUnitRunner


@RunWith(MockitoJUnitRunner::class)
@OptIn(ExperimentalCoroutinesApi::class)
class DeviceDetailsViewModelTest : BaseTest() {
    @get:Rule
    var rule: TestRule = InstantTaskExecutorRule()

    private lateinit var deviceDetailsViewModel: DeviceDetailsViewModel

    private lateinit var observer: Observer<DeviceModel>

    @Before
    @Throws(Exception::class)
    fun setUp() {
        Dispatchers.setMain(TestCoroutineDispatcher())

        observer = declareMock()
    }

    @Test
    fun `should init state with a model data`() = runBlocking {
        //Arrange
        deviceDetailsViewModel = DeviceDetailsViewModel(getDeviceModelTest())

        //Act
        deviceDetailsViewModel.deviceLiveData.observeForever(observer)

        //Assert
        verify(observer).onChanged(notNull())
    }


    @After
    fun tearDown() {
        Dispatchers.resetMain()
    }
}