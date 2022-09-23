package com.example.androidfundamentals

import android.content.Intent
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
        binding.btnLog.setOnClickListener {
            val firstName = binding.etFirstName.text.toString()
            val lastName = binding.edLastName.text.toString()
            val country = binding.etCountry.text.toString()
            val age = binding.etAge.text.toString().toInt()

            Log.d("ConstraintLayout", "$firstName' $lastName, from $country, was born at $age")
        }


        binding.btnPassData.setOnClickListener {
            val firstName = binding.etFirstName.text.toString()
            val lastName = binding.edLastName.text.toString()
            val country = binding.etCountry.text.toString()
            val age = binding.etAge.text.toString().toInt()

            val person = Person("$firstName $lastName", age, country)

            Intent(this, PassingDataActivity::class.java).also {
                it.putExtra("EXTRA_NAME", "$firstName $lastName")
                it.putExtra("EXTRA_COUNTRY", country)
                it.putExtra("EXTRA_AGE", age.toString().toInt())

                it.putExtra("EXTRA_PERSON", person)

                startActivity(it)
            }
        }
    }
}