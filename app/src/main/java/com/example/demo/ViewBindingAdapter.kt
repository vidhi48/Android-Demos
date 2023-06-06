package com.example.demo

import android.widget.Button
import androidx.appcompat.content.res.AppCompatResources
import androidx.databinding.BindingAdapter
import com.example.demo.model.DrawableResource

@BindingAdapter("iconDrawable")
fun Button.setIcon(imageUrl: DrawableResource) {
    when (imageUrl) {
        is DrawableResource.Bitmap -> return
        is DrawableResource.Drawable -> setCompoundDrawablesRelativeWithIntrinsicBounds(AppCompatResources.getDrawable(context, imageUrl.id), null, null, null)
    }
    compoundDrawablesRelative.filterNotNull().forEach { drawable ->
        drawable.mutate().setTint(resources.getColor(android.R.color.white, context.theme))
    }
}
