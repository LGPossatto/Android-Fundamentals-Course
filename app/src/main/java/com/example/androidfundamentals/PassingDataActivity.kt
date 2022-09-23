package com.example.androidfundamentals

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import java.io.Serializable

data class Person(
    val name: String,
    val age: Int,
    val country: String
) : Serializable

class PassingDataActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_passing_data)

        val tvData = findViewById<TextView>(R.id.tvPassedData)
        val tvDataClass = findViewById<TextView>(R.id.tvPassedDataClass)

        val name = intent.getStringExtra("EXTRA_NAME")
        val age = intent.getIntExtra("EXTRA_AGE", 0)
        val country = intent.getStringExtra("EXTRA_COUNTRY")
        val person = intent.getSerializableExtra("EXTRA_PERSON")

        tvData.text = "$name from $country is $age years old"
        tvDataClass.text = person.toString()
    }
}