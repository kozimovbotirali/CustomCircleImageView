package com.sabgames.circle_image_view

import android.graphics.Bitmap

/**
 * Created by B.Kozimov on 29.10.2021 10:24.
 */
object BitmapHelper {
    fun makeCircledBitmap(bitmap: Bitmap): Bitmap? {
        val intArray = IntArray(bitmap.width * bitmap.height)
        bitmap.getPixels(intArray, 0, bitmap.width, 0, 0, bitmap.width, bitmap.height)

        toCircledImage(intArray, bitmap.width, bitmap.height)

        return Bitmap.createBitmap(intArray, bitmap.width, bitmap.height, Bitmap.Config.ARGB_8888)
    }

    private external fun toCircledImage(pixels: IntArray, width: Int, height: Int)

    init {
        System.loadLibrary("circle-image-view")
    }
}