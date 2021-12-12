package com.winterprojects.valetdevices.presentation.deviceDetails

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.winterprojects.valetdevices.databinding.FragmentDeviceDetailsBinding

class DeviceDetailsFragment : Fragment() {

    private val args: DeviceDetailsFragmentArgs by navArgs()
    private lateinit var fragmentDeviceDetailsBinding: FragmentDeviceDetailsBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        fragmentDeviceDetailsBinding =
            FragmentDeviceDetailsBinding.inflate(layoutInflater, container, false)

        fragmentDeviceDetailsBinding.device = args.device

        return fragmentDeviceDetailsBinding.root
    }

}