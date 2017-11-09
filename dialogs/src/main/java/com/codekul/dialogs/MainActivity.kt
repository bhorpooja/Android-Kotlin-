package com.codekul.dialogs

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnAlert.setOnClickListener { shD("alert") }
        btnDt.setOnClickListener { shD("datepicker") }
        btnTm.setOnClickListener { shD("timepicker") }
        btnCust.setOnClickListener { shD("custom") }
    }

    private fun shD(tag:String) {
            val diaFrg=BlankFragment()
            diaFrg.show(supportFragmentManager,tag)
    }
}
