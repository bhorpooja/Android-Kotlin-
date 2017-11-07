package com.codekul.services

import android.content.Intent
import android.os.Build
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class MainActivity : AppCompatActivity() {


    private var intentSer:Intent?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        intentSer=Intent(this,MyService::class.java)
    }


    fun onMpStart(view:View){
        if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.O){
        startForegroundService(intentSer)
        }
        else{
            startService(intentSer)
        }
    }
    fun onMpStop(view:View){
        stopService(intentSer)

    }
}
