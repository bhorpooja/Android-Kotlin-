package com.codekul.broadcastreceiver

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.util.Log
import android.widget.Toast

class MyReceiver : BroadcastReceiver() {

    override fun onReceive(context: Context, intent: Intent) {

        Toast.makeText(context,"App not Running... Mode changed...",Toast.LENGTH_SHORT).show()
        Log.i("@codekul","app not running")

    }

}
