package com.winterprojects.valetdevices.presentation.devices

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.winterprojects.valetdevices.databinding.FragmentDevicesBinding
import com.winterprojects.valetdevices.domain.devices.models.DeviceModel
import com.winterprojects.valetdevices.helpers.StateResult
import org.koin.android.ext.android.inject

class DevicesFragment : Fragment() {

    private val devicesViewModel: DevicesViewModel by inject()

    private lateinit var devicesBinding: FragmentDevicesBinding

    private lateinit var devicesAdapter: DevicesAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        devicesBinding = FragmentDevicesBinding.inflate(layoutInflater, container, false)

        setAdapters()
        setObservers()

        return devicesBinding.root
    }

    private fun setAdapters() {
        devicesAdapter = DevicesAdapter()
        devicesBinding.recyclerViewDevices.apply {
            adapter = devicesAdapter
            layoutManager = LinearLayoutManager(context)
        }
    }

    private fun setObservers() {
        devicesViewModel.devicesLiveData.observe(this) { stateResult ->
            when (stateResult) {
                StateResult.Empty -> Toast.makeText(context, "Empty", Toast.LENGTH_LONG).show()
                is StateResult.ErrorState -> Toast.makeText(context, "Error", Toast.LENGTH_LONG)
                    .show()
                is StateResult.Loaded -> updateList(stateResult.data)
                StateResult.Loading -> Toast.makeText(context, "Loading", Toast.LENGTH_LONG).show()
            }
        }
    }

    private fun updateList(devices: List<DeviceModel>) {
        devicesAdapter.submitList(devices)
    }

}