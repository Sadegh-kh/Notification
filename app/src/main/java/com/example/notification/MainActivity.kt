package com.example.notification

import android.app.NotificationManager
import android.graphics.BitmapFactory
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.app.NotificationCompat
import com.example.notification.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.btnSendNotification.setOnClickListener {
            //first create channel for notification for Android 8 and up (class MyApp for this)

            val notificationManager=getSystemService(NOTIFICATION_SERVICE)as NotificationManager

            //create notification =>
            val notification=NotificationCompat.Builder(this,"myNotif")
                .setSmallIcon(android.R.drawable.stat_notify_chat)
                .setLargeIcon(BitmapFactory.decodeResource(resources,R.drawable.img_sadegh))
                .setContentTitle("Sadegh Khoshbayan")
                .setContentText("salam,Chetori?Khubi?")
                .build()

            //show notification (id must be a unit)1
            notificationManager.notify((1..1000).random(),notification)

        }
    }
}