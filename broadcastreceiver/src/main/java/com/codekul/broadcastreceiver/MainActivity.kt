package com.codekul.broadcastreceiver

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast

class MainActivity : AppCompatActivity() {



    private val receiver=object: BroadcastReceiver() {

        override fun onReceive(con: Context?, data: Intent?) {
            Toast.makeText(con,"Airplane mode changed...!!!",Toast.LENGTH_SHORT).show()
            Log.i("@codekul","App Running")
        }
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val intFil=IntentFilter(Intent.ACTION_AIRPLANE_MODE_CHANGED)
        registerReceiver(receiver,intFil)
    }
}
