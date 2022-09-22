package com.example.androidfundamentals

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.androidfundamentals.databinding.ActivityConstraintLayoutBinding

class ConstraintLayoutActivity : AppCompatActivity() {
    private lateinit var binding: ActivityConstraintLayoutBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityConstraintLayoutBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //val btnSubmit = findViewById<Button>(R.id.btnSubmit)
        binding.btnSubmit.setOnClickListener {
            val firstName = binding.etFirstName.text
            val lastName = binding.edLastName.text
            val country = binding.etCountry.text
            val birthDate = binding.etBirthDate.text

            Log.d("ConstraintLayout", "$firstName' $lastName, from $country, was born at $birthDate")
        }
    }
}