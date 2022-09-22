package com.example.androidfundamentals

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View.INVISIBLE
import android.widget.Button
import android.widget.ImageView

class ImageViewActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_image_view)

        val btnEnhance = findViewById<Button>(R.id.btnEnhance)

        btnEnhance.setOnClickListener {
            val ivMain = findViewById<ImageView>(R.id.ivMain)

            ivMain.setImageResource(R.drawable.kermit02)
            btnEnhance.visibility = INVISIBLE
        }
    }
}