package com.codekul.jsonparsing

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.codekul.jsonparsing.dto.Demo
import com.google.gson.Gson
import org.json.JSONArray
import org.json.JSONObject
import java.io.InputStream

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        gson()
    }

    fun gson(){

        val ist: InputStream = assets.open("my.json")
        val flDt = ist.bufferedReader().use {
            it.readText()
        }


        val gs=Gson()
        val demo=gs.fromJson<Demo>(flDt,Demo::class.java)
        Log.i("@Codekul", """Name : ${demo.nm}""")
        Log.i("@Codekul", """Age : ${demo.age}""")
        Log.i("@Codekul", """isIndian : ${demo.isIndian}""")
        demo.mobs.forEach {
            Log.i("@codekul","""$it""")
        }


    }

    fun normal(){

        val ist: InputStream = assets.open("my.json")
        val flDt = ist.bufferedReader().use {
            it.readText()
        }

        val rtObj = JSONObject(flDt)
        Log.i("@Codekul", """Name : ${rtObj.getString("nm")}""")
        Log.i("@Codekul", """Age : ${rtObj.getInt("age")}""")
        Log.i("@Codekul", """isIndian : ${rtObj.getBoolean("isIndian")}""")
        Log.i("@Codekul", """Sal : ${rtObj.getDouble("sal")}""")


        val inrObj = rtObj.getJSONObject("grp")
        Log.i("@codekul", """Title : ${inrObj.getString("ttl")}""")

        val mobs = rtObj.getJSONArray("mobs")
        mobs.iterator().forEach {
            Log.i("@codekul", """ $it """)
        }
    }

    private operator fun JSONArray.iterator(): Iterator<String>
            = (0 until length()).asSequence().map { get(it) as String }.iterator()

}