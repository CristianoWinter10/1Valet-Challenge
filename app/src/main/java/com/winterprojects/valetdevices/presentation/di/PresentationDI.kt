package com.winterprojects.valetdevices.presentation.di

import com.winterprojects.valetdevices.presentation.devices.DevicesViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

object PresentationDI {
    val module = module {
        viewModel {
            DevicesViewModel(get())
        }
    }
}