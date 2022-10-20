package com.example.androidfundamentals

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView

class ImplicitIntentsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_implicit_intents)

        findViewById<ImageView>(R.id.btnChooseImg).setOnClickListener {
         Intent(Intent.ACTION_GET_CONTENT).also {
             it.type = "image/*"
             startActivityForResult(it, 0)
         }
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (resultCode == Activity.RESULT_OK && requestCode == 0) {
            var uri = data?.data
            findViewById<ImageView>(R.id.ivImageBox).setImageURI(uri)
        }
    }
}