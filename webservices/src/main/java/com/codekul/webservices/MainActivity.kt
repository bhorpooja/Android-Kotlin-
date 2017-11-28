package com.codekul.webservices

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import com.android.volley.RequestQueue
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.codekul.webservices.dto.Sapmle
import com.google.gson.Gson

import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    var q:RequestQueue?=null
    var gs:Gson?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        q=Volley.newRequestQueue(this)
    }

    fun onGet(view: View?){
        val url="""http://samples.openweathermap.org/data/2.5/weather?q=${edtCity.text},uk&appid=76d4642058432ea339430be6cc9a4638"""
        q?.add(
                StringRequest(url,
                        {
                            Log.i("@codekul","""$it""")
                            val sm=gs?.fromJson<Sapmle>(it,Sapmle::class.java)
                            txtInfo.text="""${sm?.main?.temp}"""
                        },
                        {}
                )
        )
    }
}
