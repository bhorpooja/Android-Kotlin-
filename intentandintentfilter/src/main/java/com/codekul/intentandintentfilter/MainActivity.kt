package com.codekul.intentandintentfilter

import android.annotation.SuppressLint
import android.content.Intent
import android.net.Uri
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnOkay.setOnClickListener {
            simple()
        }
    }

    private fun web(){
        val webInt=Intent(Intent.ACTION_VIEW)
        webInt.data= Uri.parse("http://codekul.com")
        startActivity(webInt)

    }

    private fun Dial(){
        val dialInt=Intent(Intent.ACTION_DIAL)
        startActivity(dialInt)
    }

    @SuppressLint("MissingPermission")
    private fun call() {
        val calInt = Intent(Intent.ACTION_CALL)
        calInt.data = Uri.parse("tel://7387242702")
        startActivity(calInt)
    }

    private fun simple(){
         val inte= Intent()
        inte.action="com.codekul.action.SIMPLE"
         inte.addCategory("com.codekul.category.ABC")
        inte.data= Uri.parse("http://codekul.com")
         startActivity(inte)

     }
}
