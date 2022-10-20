package com.example.androidfundamentals

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.example.androidfundamentals.databinding.ActivityAlertDialogBinding

class AlertDialogActivity : AppCompatActivity() {
    private lateinit var binding: ActivityAlertDialogBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAlertDialogBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var confirmDialog = AlertDialog.Builder(this)
            .setTitle("Yes!")
            .setMessage("Do you want to press yes?")
            .setIcon(R.drawable.ic_check)
            .setPositiveButton("Yes") { _, _ ->
                Toast.makeText(this, "You pressed Yes!", Toast.LENGTH_SHORT).show()
            }
            .setNegativeButton("No") {_, _ ->
                Toast.makeText(this, "Nooooooooooooooooooo!", Toast.LENGTH_SHORT).show()
            }
            .create()

        binding.btnAlertYes.setOnClickListener {
            confirmDialog.show()
        }

        var options = arrayOf<String>("Option 1", "Option 2", "Option 3")
        var chooseOneDialog = AlertDialog.Builder(this)
            .setTitle("Choose One!")
            .setSingleChoiceItems(options, 0) {_, i ->
                Toast.makeText(this, options[i], Toast.LENGTH_SHORT).show()
            }
            .setPositiveButton("Confirm") { _, _ ->
                Toast.makeText(this, "Confirm", Toast.LENGTH_SHORT).show()
            }
            .setNegativeButton("Deny") {_, _ ->
                Toast.makeText(this, "DENIED", Toast.LENGTH_SHORT).show()
            }
            .create()

        binding.btnChooseOne.setOnClickListener {
            chooseOneDialog.show()
        }

        var multiChoiceDialog = AlertDialog.Builder(this)
            .setTitle("Choose whatever!")
            .setMultiChoiceItems(options, booleanArrayOf(true, false, false)) {_, i, isChecked ->
                if (isChecked) {
                    Toast.makeText(this, "${options[i]} is checked", Toast.LENGTH_SHORT).show()
                } else {
                    Toast.makeText(this, "${options[i]} is unchecked", Toast.LENGTH_SHORT).show()
                }
            }
            .setPositiveButton("Confirm") { _, _ ->
                Toast.makeText(this, "Confirm", Toast.LENGTH_SHORT).show()
            }
            .setNegativeButton("Deny") {_, _ ->
                Toast.makeText(this, "DENIED", Toast.LENGTH_SHORT).show()
            }
            .create()

        binding.btnMultiChoice.setOnClickListener {
            multiChoiceDialog.show()
        }
    }
}