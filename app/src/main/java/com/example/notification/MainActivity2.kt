package com.example.notification

import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Intent
import android.graphics.BitmapFactory
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.app.NotificationCompat
import com.example.notification.databinding.ActivityMain2Binding

class MainActivity2 : AppCompatActivity() {
    lateinit var binding: ActivityMain2Binding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding= ActivityMain2Binding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val intent = Intent(this,MainActivity::class.java)
        intent.flags= Intent.FLAG_ACTIVITY_NEW_TASK.or(Intent.FLAG_ACTIVITY_CLEAR_TASK)
        val pendingIntent= PendingIntent.getActivity(this,12,intent,0)

        val notificationManager=getSystemService(NOTIFICATION_SERVICE)as NotificationManager

        //create notification =>
        val notification= NotificationCompat.Builder(this,"myNotif")
            .setSmallIcon(android.R.drawable.stat_notify_chat)
            .setLargeIcon(BitmapFactory.decodeResource(resources,R.drawable.img_sadegh))
            .setContentTitle("Sadegh Khoshbayan")
            .setContentText("salam")



        binding.btnBpicStl.setOnClickListener {
            notification.setContentIntent(pendingIntent)
            notification.setStyle(
                NotificationCompat.BigPictureStyle().bigPicture(BitmapFactory.decodeResource(resources,R.drawable.img_nature))
            )
            notificationManager.notify((1..1000).random(),notification.build())
        }
        binding.btnBtxtStl.setOnClickListener {
            notification.setContentIntent(pendingIntent)
            notification.setStyle(
                NotificationCompat.BigTextStyle().bigText("Lorem ipsum dolor sit amet, consectetur adipiscing elit. Integer nec odio. Praesent libero. Sed cursus ante dapibus diam. Sed nisi. Nulla quis sem at nibh elementum imperdiet. Duis sagittis ipsum. Praesent mauris. Fusce nec tellus sed augue semper porta. Mauris massa. Vestibulum lacinia arcu eget nulla. Class aptent taciti sociosqu ad litora torquent per conubia nostra, per inceptos himenaeos. Curabitur sodales ligula in libero. Sed dignissim lacinia nunc. ")
            )
            notificationManager.notify((1..1000).random(),notification.build())
        }
        binding.btnInbxStl.setOnClickListener {
            notification.setContentIntent(pendingIntent)
            notification.setStyle(
                NotificationCompat.InboxStyle()
                    .addLine("Khubi?")
                    .addLine("chekhabar?")
                    .addLine("chekar mikoni?")
            )
            notificationManager.notify((1..1000).random(),notification.build())
        }
    }
}