package com.example.androidfundamentals

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.androidfundamentals.databinding.ActivitySavingDataBinding

class SavingDataActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySavingDataBinding

        override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySavingDataBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val sharedPref = getSharedPreferences("myPref", Context.MODE_PRIVATE)
        val editor = sharedPref.edit()

        binding.btnSave.setOnClickListener {
            val fisrtName = binding.etSaveFirstName.text.toString()
            val lastName = binding.etSaveLastName.text.toString()
            val check = binding.cbCheck.isChecked

            editor.apply {
                putString("firstName", fisrtName)
                putString("lastName", lastName)
                putBoolean("check", check)
                apply()
            }
        }

        binding.btnLoad.setOnClickListener {
            val firstName = sharedPref.getString("firstName", null)
            val lastName = sharedPref.getString("lastName", null)
            val check = sharedPref.getBoolean("check", false)

            binding.etSaveFirstName.setText(firstName)
            binding.etSaveLastName.setText(lastName)
            binding.cbCheck.isChecked = check
        }
    }
}