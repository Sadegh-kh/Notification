package com.example.notification

import android.app.Application
import android.app.NotificationChannel
import android.app.NotificationManager
import android.os.Build

//it's create before MainActivity and we can use in the all Activities
class MyApp:Application() {

    override fun onCreate() {
        super.onCreate()

        //for android 8 and up
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
        val notificationManager=getSystemService(NOTIFICATION_SERVICE)as NotificationManager
        val notificationChannel= NotificationChannel("myNotif","Football",NotificationManager.IMPORTANCE_HIGH)
            notificationChannel.description="these notifications show detail form Football"

            notificationManager.createNotificationChannel(notificationChannel)

        }
    }

}