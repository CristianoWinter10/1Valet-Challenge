package com.winterprojects.valetdevices.presentation.devices

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.winterprojects.valetdevices.databinding.ItemDeviceBinding
import com.winterprojects.valetdevices.domain.devices.models.DeviceModel

class DevicesAdapter :
    ListAdapter<DeviceModel, DevicesAdapter.DeviceViewHolder>(diffCallback) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DeviceViewHolder {
        val binding =
            ItemDeviceBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return DeviceViewHolder(binding)
    }

    override fun onBindViewHolder(holder: DeviceViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    class DeviceViewHolder(
        private val binding: ItemDeviceBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(deviceModel: DeviceModel) {
            binding.device = deviceModel
        }
    }

    companion object {
        val diffCallback = object : DiffUtil.ItemCallback<DeviceModel>() {
            override fun areItemsTheSame(oldItem: DeviceModel, newItem: DeviceModel): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(oldItem: DeviceModel, newItem: DeviceModel): Boolean {
                return oldItem == newItem
            }
        }
    }
}

