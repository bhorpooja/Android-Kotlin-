package com.codekul.services

import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.Service
import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.media.MediaPlayer
import android.os.Build
import android.os.IBinder
import android.support.v4.app.NotificationCompat

class MyService : Service() {


    private var mp:MediaPlayer?=null

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {

        mp= MediaPlayer.create(this,R.raw.my)
        mp?.start()

        showInForeground()
//        return START_NOT_STICKY
        return START_STICKY
    }

    override fun onDestroy() {
        mp?.stop()
        mp?.release()
        super.onDestroy()
    }
    override fun onBind(intent: Intent): IBinder? {
        throw UnsupportedOperationException("Not yet implemented")
    }

    private fun showInForeground() {
        val notiMgr = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {

            val id = "1234"
            val name = "normal"
            val description = "description"
            val importance = android.app.NotificationManager.IMPORTANCE_LOW
            val mChannel = NotificationChannel(id, name, importance)
            mChannel.description = description
            mChannel.enableLights(true)
            mChannel.lightColor = Color.RED
            mChannel.enableVibration(true)

            val bldr = NotificationCompat.Builder(this, "1234")
            bldr.setSmallIcon(R.drawable.ic_audiotrack_black_24dp)
                    .setContentText("Content Text")
                    .setContentInfo("Info")
                    .setContentTitle("Title")

            val mNotificationManager = getSystemService(Context.NOTIFICATION_SERVICE) as android.app.NotificationManager
            mNotificationManager.createNotificationChannel(mChannel)
            startForeground(1234, bldr.build())
            //mNotificationManager.notify(456, bldr.build())

        } else {
            val bldr = NotificationCompat.Builder(this)
            bldr.setSmallIcon(R.drawable.ic_audiotrack_black_24dp)
                    .setContentText("Content Text")
                    .setContentInfo("Info")
                    .setContentTitle("Title")
            val notification = bldr.build()
            startForeground(1234, notification)
        }
    }
}
