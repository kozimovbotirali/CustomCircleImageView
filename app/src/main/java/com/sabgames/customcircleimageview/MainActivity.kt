package com.sabgames.customcircleimageview

import android.graphics.BitmapFactory
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.content.res.AppCompatResources
import com.google.android.material.button.MaterialButton
import com.sabgames.circle_image_view.CircleImageView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<MaterialButton>(R.id.btn1).setOnClickListener {
            findViewById<CircleImageView>(R.id.image).setImageResource(R.drawable.image)
        }
        findViewById<MaterialButton>(R.id.btn2).setOnClickListener {
            findViewById<CircleImageView>(R.id.image).setImageDrawable(AppCompatResources.getDrawable(this, R.drawable.img))
        }
        findViewById<MaterialButton>(R.id.btn3).setOnClickListener {
            val bitmap = BitmapFactory.decodeResource(resources, R.drawable.img2)
            findViewById<CircleImageView>(R.id.image).setImageBitmap(bitmap)
        }
    }
}