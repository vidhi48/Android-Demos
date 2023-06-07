package com.example.demo

import android.widget.Button
import androidx.appcompat.content.res.AppCompatResources
import androidx.databinding.BindingAdapter
import com.example.demo.model.DrawableResource

@BindingAdapter("startIconDrawable", "startIconColor", requireAll = false)
fun Button.setIcon(imageUrl: DrawableResource, colorId: Int?) {
    when (imageUrl) {
        is DrawableResource.Bitmap -> return
        is DrawableResource.Drawable -> setCompoundDrawablesRelativeWithIntrinsicBounds(
            AppCompatResources.getDrawable(context, imageUrl.id),
            null,
            null,
            null
        )
    }

    if (colorId != null) {
        compoundDrawablesRelative.filterNotNull().forEach { drawable ->
            drawable.mutate().setTint(context.resources.getColor(colorId, context.theme))
        }
    }
}