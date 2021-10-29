package com.sabgames.circle_image_view

import android.content.Context
import android.graphics.Bitmap
import android.graphics.ImageDecoder
import android.graphics.drawable.Drawable
import android.net.Uri
import android.os.Build
import android.provider.MediaStore
import android.util.AttributeSet
import androidx.appcompat.content.res.AppCompatResources
import androidx.appcompat.widget.AppCompatImageView
import androidx.core.graphics.drawable.toBitmap
import androidx.core.graphics.drawable.toDrawable

/**
 * Created by B.Kozimov on 29.10.2021 9:32.
 */
class CircleImageView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : AppCompatImageView(context, attrs, defStyleAttr) {

    init {
        val typedArray = context.obtainStyledAttributes(attrs, R.styleable.CircleImageView)
        typedArray.recycle()
    }

    override fun setImageDrawable(drawable: Drawable?) {
        drawable?.toBitmap()?.apply {
            val result = BitmapHelper.makeCircledBitmap(this)
            val d = result?.toDrawable(resources)
            super.setImageDrawable(d)
            return
        }
        super.setImageDrawable(drawable)
    }

    override fun setImageResource(resId: Int) {
        setImageDrawable(AppCompatResources.getDrawable(context, resId))
    }

    override fun setImageBitmap(bm: Bitmap?) {
        bm?.apply {
            val result = BitmapHelper.makeCircledBitmap(this)
            val d = result?.toDrawable(resources)
            super.setImageDrawable(d)
            return
        }
        super.setImageBitmap(bm)
    }

    override fun setImageURI(uri: Uri?) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.P) {
            uri?.let { ImageDecoder.createSource(context.contentResolver, it) }?.let { ImageDecoder.decodeBitmap(it) }
        } else {
            MediaStore.Images.Media.getBitmap(context.contentResolver, uri)
        }?.let {
            setImageBitmap(it)
            return
        }
        super.setImageURI(uri)
    }
}