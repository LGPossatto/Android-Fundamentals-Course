package com.example.androidfundamentals

import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.app.TaskStackBuilder
import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.os.Build
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import com.example.androidfundamentals.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    // NOTIFICATION VALS
    val CHANNEL_ID = "channelId"
    val CHANNEL_NAME = "channelName"
    val NOTIFICATION_ID = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnLinearLayout.setOnClickListener {
            val intent = Intent(this, LinearLayoutActivity::class.java)
            startActivity(intent)
        }

        binding.btnConstraintLayout.setOnClickListener {
            val intent = Intent(this, ConstraintLayoutActivity::class.java)
            startActivity(intent)
        }

        binding.btnTextView.setOnClickListener {
            val intent = Intent(this, TextViewActivity::class.java)
            startActivity(intent)
        }

        binding.btnEditText.setOnClickListener {
            val intent = Intent(this, EditTextActivity::class.java)
            startActivity(intent)
        }

        binding.btnImageView.setOnClickListener {
            val intent = Intent(this, ImageViewActivity::class.java)
            startActivity(intent)
        }

        binding.btnCheckboxRadioButton.setOnClickListener {
            val intent = Intent(this, CheckboxRadioButtonActivity::class.java)
            startActivity(intent)
        }

        binding.btnToast.setOnClickListener {
            Toast.makeText(this, "Normal Toast", Toast.LENGTH_SHORT).show()
        }

        binding.btnCustomToast.setOnClickListener {
            Toast(this).apply {
                duration = Toast.LENGTH_LONG
                view = layoutInflater.inflate(R.layout.activity_custom_toast, findViewById<ConstraintLayout>(R.id.clCustomToast))
                show()
            }
        }

        binding.btnPassingData.setOnClickListener {
            val intent = Intent(this, ConstraintLayoutActivity::class.java)
            startActivity(intent)
        }

        binding.btnPermissions.setOnClickListener {
            val intent = Intent(this, PermissionsActivity::class.java)
            startActivity(intent)
        }

        binding.btnImplicitIntents.setOnClickListener {
            val intent = Intent(this, ImplicitIntentsActivity::class.java)
            startActivity(intent)
        }

        binding.btnToolBarMenu.setOnClickListener {
            val intent = Intent(this, ToolBarMenuActivity::class.java)
            startActivity(intent)
        }

        binding.btnAlertDialog.setOnClickListener {
            val intent = Intent(this, AlertDialogActivity::class.java)
            startActivity(intent)
        }

        binding.btnSpinner.setOnClickListener {
            val intent = Intent(this, SpinnerActivity::class.java)
            startActivity(intent)
        }

        binding.btnFragments.setOnClickListener {
            val intent = Intent(this, FragmentActivity::class.java)
            startActivity(intent)
        }

        binding.btnSaveData.setOnClickListener {
            val intent = Intent(this, SavingDataActivity::class.java)
            startActivity(intent)
        }

        // NOTIFICATION
        createNotificationChannel()

        val notIntent = Intent(this, MainActivity::class.java)
        val pendingIntent = TaskStackBuilder.create(this).run {
            addNextIntentWithParentStack(notIntent)
            getPendingIntent(0, PendingIntent.FLAG_UPDATE_CURRENT)
        }

        val notification = NotificationCompat.Builder(this, CHANNEL_ID)
            .setContentTitle("Notification Title")
            .setContentText("This is a Text")
            .setSmallIcon(R.drawable.kermit01)
            .setPriority(NotificationCompat.PRIORITY_HIGH)
            .setContentIntent(pendingIntent)
            .build()

        val notificationManger = NotificationManagerCompat.from(this)

        binding.btnNotification.setOnClickListener {
            notificationManger.notify(NOTIFICATION_ID, notification)
        }

        binding.btnDragDrop.setOnClickListener {
            val intent = Intent(this, DragDropActivity::class.java)
            startActivity(intent)
        }
    }

    fun createNotificationChannel() {
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val channel = NotificationChannel(
                CHANNEL_ID,
                CHANNEL_NAME,
                NotificationManager.IMPORTANCE_DEFAULT).apply {
                    lightColor = Color.GREEN
                    enableLights(true)
            }

            val manager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
            manager.createNotificationChannel(channel)
        }
    }
}