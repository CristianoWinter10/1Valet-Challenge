package com.winterprojects.valetdevices.presentation.favorites

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.winterprojects.valetdevices.databinding.ItemDeviceFavoriteBinding
import com.winterprojects.valetdevices.domain.devices.models.DeviceFavoriteModel

class FavoriteAdapter(
    private val onRemoveFavoriteItemClickListener: OnRemoveFavoriteItemClickListener
) :
    ListAdapter<DeviceFavoriteModel, FavoriteAdapter.FavoriteVideoHolder>(diffCallback) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FavoriteVideoHolder {
        val binding =
            ItemDeviceFavoriteBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return FavoriteVideoHolder(binding, onRemoveFavoriteItemClickListener)
    }

    override fun onBindViewHolder(holder: FavoriteVideoHolder, position: Int) {
        holder.bind(position, getItem(position))
    }

    class FavoriteVideoHolder(
        private val binding: ItemDeviceFavoriteBinding,
        private val onRemoveFavoriteItemClickListener: OnRemoveFavoriteItemClickListener
    ) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(position: Int, favoriteDeviceModel: DeviceFavoriteModel) {
            binding.device = favoriteDeviceModel

            binding.buttonFavorite.setOnClickListener {
                onRemoveFavoriteItemClickListener.onRemoveFavoriteItemClickListener(
                    position,
                    favoriteDeviceModel
                )
            }
        }
    }

    companion object {
        val diffCallback = object : DiffUtil.ItemCallback<DeviceFavoriteModel>() {
            override fun areItemsTheSame(
                oldItem: DeviceFavoriteModel,
                newItem: DeviceFavoriteModel
            ): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(
                oldItem: DeviceFavoriteModel,
                newItem: DeviceFavoriteModel
            ): Boolean {
                return oldItem == newItem
            }
        }
    }
}

