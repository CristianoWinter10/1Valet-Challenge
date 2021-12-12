package com.winterprojects.valetdevices.presentation.customBindingAdapters


import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.BindingAdapter
import coil.load
import com.winterprojects.valetdevices.R
import com.winterprojects.valetdevices.domain.devices.models.DeviceModel

@BindingAdapter("handleDeviceDescription")
fun TextView.handleDeviceDescription(description: String) {
    text = if (description.isBlank()) {
        context.getString(
            R.string.no_description_informed
        )
    } else {
        description
    }
}

@BindingAdapter("handleDevicePrice")
fun TextView.handleDevicePrice(deviceModel: DeviceModel) {
    text = String.format(
        resources.getString(R.string.format_price_currency),
        deviceModel.price,
        deviceModel.currency
    )

}

@BindingAdapter("loadImage")
fun ImageView.loadImage(url: String) {
     load(url){
         crossfade(true)
         placeholder(R.drawable.ic_image_placeholder)
         error(R.drawable.ic_image_failed)
     }
}