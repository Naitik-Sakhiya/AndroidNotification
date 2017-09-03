package com.naitiks.androidnotification

import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v4.app.NotificationCompat
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.Button

class MainActivityKt : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val createNotif = findViewById(R.id.btn_notif) as Button
        createNotif.setOnClickListener { addNotification() }
    }

    private fun addNotification() {
        val builder = NotificationCompat.Builder(this)
                .setSmallIcon(R.mipmap.ic_launcher)
                .setContentTitle("Just Notification")
                .setContentText("Header Text")
                .setSubText("Sub Text")

        val contentIntent = PendingIntent.getActivity(this@MainActivityKt, 0, (Intent()),
                PendingIntent.FLAG_UPDATE_CURRENT)
        builder.setContentIntent(contentIntent)

        // Add as notification
        val manager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
        manager.notify(0, builder.build())
    }
}
