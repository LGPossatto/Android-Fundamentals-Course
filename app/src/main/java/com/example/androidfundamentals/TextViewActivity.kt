package com.example.androidfundamentals

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.androidfundamentals.databinding.ActivityMainBinding
import com.example.androidfundamentals.databinding.ActivityTextViewBinding

class TextViewActivity : AppCompatActivity() {
    private lateinit var binding: ActivityTextViewBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTextViewBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var count = 0
        binding.btnPluss.setOnClickListener {
            count++
            binding.tvCounter.text = "Counter: $count"
        }
    }
}