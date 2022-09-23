package com.example.androidfundamentals

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.RadioButton
import com.example.androidfundamentals.databinding.ActivityCheckboxRadioButtonBinding

class CheckboxRadioButtonActivity : AppCompatActivity() {
    private lateinit var binding: ActivityCheckboxRadioButtonBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCheckboxRadioButtonBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnConfirm.setOnClickListener {
            val meat = findViewById<RadioButton>(binding.rgMeat.checkedRadioButtonId)
            val cheese = binding.cbCheese.isChecked
            val onions = binding.cbOnions.isChecked
            val salad = binding.cbSalad.isChecked

            binding.tvOrder.text = "Your ordered a burger with:\n" +
            "${meat.text}\n" +
            (if (cheese) "Cheese\n" else "") +
            (if (onions) "Onions\n" else "") +
            (if (salad) "Salad\n" else "")
        }
    }
}