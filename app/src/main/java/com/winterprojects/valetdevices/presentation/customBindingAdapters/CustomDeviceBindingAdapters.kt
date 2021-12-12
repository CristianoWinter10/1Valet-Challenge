package com.winterprojects.valetdevices.presentation.customBindingAdapters


import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.databinding.BindingAdapter
import coil.load
import coil.transform.RoundedCornersTransformation
import com.google.android.material.button.MaterialButton
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

@BindingAdapter("handleDeviceType")
fun TextView.handleDeviceType(type: String) {
    text = if (type.isBlank()) {
        context.getString(
            R.string.no_type_informed
        )
    } else {
        type
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
fun ImageView.loadImage(url: String?) {
    load(url) {
        crossfade(true)
        placeholder(R.drawable.ic_image_placeholder)
        error(R.drawable.ic_no_image_available)
        transformations(RoundedCornersTransformation(DEFAULT_ROUNDED_CORNER_IMAGE))
    }
}

@BindingAdapter("handleDeviceFavorite")
fun Button.handleDeviceFavorite(isFavorite: Boolean) {
    with(this as MaterialButton) {
        if(!isFavorite){
            this.setText(R.string.add)
            this.setTextColor(ContextCompat.getColor(context, R.color.color_primary_variant))
            this.setBackgroundColor(ContextCompat.getColor(context, R.color.color_favorite_status))
            this.icon = ContextCompat.getDrawable(context, R.drawable.ic_favorite_filled)
            this.iconTint = ContextCompat.getColorStateList(context, R.color.white)
            this.strokeColor = ContextCompat.getColorStateList(context, R.color.color_favorite_status)
        } else{
            this.setText(R.string.remove)
            this.setTextColor(ContextCompat.getColor(context, R.color.color_primary_variant))
            this.setBackgroundColor(ContextCompat.getColor(context, android.R.color.transparent))
            this.icon = ContextCompat.getDrawable(context, R.drawable.ic_favorite_border)
            this.iconTint = ContextCompat.getColorStateList(context, R.color.color_favorite_status)
            this.strokeColor = ContextCompat.getColorStateList(context, R.color.color_primary_variant)
        }
    }
}