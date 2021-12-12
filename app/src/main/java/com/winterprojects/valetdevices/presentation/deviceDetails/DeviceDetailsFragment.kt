package com.winterprojects.valetdevices.presentation.deviceDetails

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.winterprojects.valetdevices.databinding.FragmentDeviceDetailsBinding
import org.koin.androidx.viewmodel.ext.android.viewModel
import org.koin.core.parameter.parametersOf

class DeviceDetailsFragment : Fragment() {

    private val args: DeviceDetailsFragmentArgs by navArgs()

    private lateinit var fragmentDeviceDetailsBinding: FragmentDeviceDetailsBinding

    private val deviceDetailsViewModel: DeviceDetailsViewModel by viewModel {
        parametersOf(args.device)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        fragmentDeviceDetailsBinding =
            FragmentDeviceDetailsBinding.inflate(layoutInflater, container, false)

        setObservers()
        initializeListeners()

        return fragmentDeviceDetailsBinding.root
    }

    private fun setObservers() {
        deviceDetailsViewModel.deviceLiveData.observe(viewLifecycleOwner) { device ->
            fragmentDeviceDetailsBinding.device = device
        }
    }

    private fun initializeListeners() {
        fragmentDeviceDetailsBinding.imageBackButton.setOnClickListener {
            findNavController().popBackStack()
        }

        fragmentDeviceDetailsBinding.buttonFavorite.setOnClickListener {
            deviceDetailsViewModel.updateFavoriteStatus()
        }
    }

}