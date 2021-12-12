package com.winterprojects.valetdevices.presentation.customBindingAdapters


import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.BindingAdapter
import coil.load
import coil.transform.RoundedCornersTransformation
import com.winterprojects.valetdevices.R
import com.winterprojects.valetdevices.domain.devices.models.DeviceModel

private const val DEFAULT_ROUNDED_CORNER_IMAGE: Float = 8f

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
         error(R.drawable.ic_no_image_available)
         transformations(RoundedCornersTransformation(DEFAULT_ROUNDED_CORNER_IMAGE))
     }
}