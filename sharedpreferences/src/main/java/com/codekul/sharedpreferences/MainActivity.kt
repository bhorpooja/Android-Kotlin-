package com.codekul.sharedpreferences

import android.content.Context
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import org.jetbrains.anko.button
import org.jetbrains.anko.sdk25.coroutines.onClick
import org.jetbrains.anko.verticalLayout

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val prefs=getSharedPreferences("My_Prefs", Context.MODE_PRIVATE)

        verticalLayout {
            button("save"){
                onClick {
                    val editor=prefs.edit()
                    editor.putInt("My_Int",10)
                    editor.putFloat("My_Float",10.5f)
                    editor.apply()
                }
            }

            button("read"){
                onClick {
                    Log.i("@codekul","""Int ${prefs.getInt("My_Int",-1)} Float ${prefs.getFloat("My_Float",-1f)}""")
                }
            }
        }
    }
}
