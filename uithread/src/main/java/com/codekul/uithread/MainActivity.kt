package com.codekul.uithread

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {


    var hand: Handler?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        hand =Handler(Looper.getMainLooper())

    }

    fun onBtnOkay(vw: View?){
        handlerWay()
    }

    fun handlerWay() {
        Thread {
            for (i in 1..10) {
                Thread.sleep(1000)
                hand?.post{txtVw.text="""$i"""}
            }
        }.start()
    }
}

