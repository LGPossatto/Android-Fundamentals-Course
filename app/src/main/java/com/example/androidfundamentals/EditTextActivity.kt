package com.example.androidfundamentals

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class EditTextActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit_text)

        var btnAdd = findViewById<Button>(R.id.btnAdd)

        btnAdd.setOnClickListener {
            var etFirst = findViewById<EditText>(R.id.etFirstNumber)
            var etSecond = findViewById<EditText>(R.id.etSecondNumber)
            var tvResult = findViewById<TextView>(R.id.tvResult)

            tvResult.text = (etFirst.text.toString().toInt() + etSecond.text.toString().toInt()).toString()
        }
    }
}