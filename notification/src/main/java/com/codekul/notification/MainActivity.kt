package com.codekul.notification

import android.annotation.TargetApi
import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Intent
import android.os.Build
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.annotation.RequiresApi
import android.support.v4.app.NotificationCompat
import android.view.View

    class MainActivity : AppCompatActivity() {

        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            setContentView(R.layout.activity_main)
        }

        fun onBtnNotify(vw: View?) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                postOrieo()
            } else preOrieo()
        }

        @RequiresApi(Build.VERSION_CODES.O)
        @TargetApi(Build.VERSION_CODES.O)
        private fun postOrieo() {

            val mNotificationManager = getSystemService(NOTIFICATION_SERVICE) as NotificationManager
            val mChannel =
                    NotificationChannel(
                            "myId-12345",
                            "sample",
                            NotificationManager.IMPORTANCE_HIGH
                    )

            mChannel.description = "this is sample description"
            //mChannel.enableLights(true)
            //mChannel.lightColor = Color.RED
            /*mChannel.enableVibration(true)
            mChannel.vibrationPattern =
                    longArrayOf(
                            100, 200, 300, 400, 500, 400, 300, 200, 400
                    )*/
            mNotificationManager.createNotificationChannel(mChannel)

            val noti = NotificationCompat.Builder(this, "myId-12345")
            noti.setSmallIcon(R.mipmap.ic_launcher)
            mNotificationManager.notify(1234, noti.build())
        }

        private fun preOrieo() {

            val manager = getSystemService(NOTIFICATION_SERVICE) as NotificationManager

            if (Build.VERSION.SDK_INT < Build.VERSION_CODES.O) {

                val pedInt = PendingIntent.getActivity(
                        this,
                        1589,
                        Intent(this, NotificationActivity::class.java),
                        PendingIntent.FLAG_UPDATE_CURRENT
                )
                val noti = NotificationCompat.Builder(this, "myId-1234")
                        .setSmallIcon(R.mipmap.ic_launcher_round)
                        .setContentTitle("Title")
                        .setDefaults(Notification.DEFAULT_ALL)
                        .setContentInfo("Content Info")
                        .setContentIntent(pedInt)
                        .setAutoCancel(true)
                        .addAction(R.mipmap.ic_launcher, "Action", pedInt)
                        .setContentText("Text").build()

                manager.notify(
                        12345,
                        noti
                )
            }
        }
    }

