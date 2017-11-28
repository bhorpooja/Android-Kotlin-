package com.codekul.verification

import android.annotation.SuppressLint
import android.content.Intent
import android.graphics.Color
import android.graphics.Typeface
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import com.codekul.verification.dto.Demo
import com.google.gson.Gson
import com.squareup.picasso.Picasso
import org.jetbrains.anko.*
import org.json.JSONObject
import java.io.InputStream

class VerifyActivity : AppCompatActivity() {

    lateinit var imgUser : ImageView
    lateinit var txtUser : TextView
    lateinit var txtAdhar : TextView
    lateinit var txtId : TextView
    lateinit var txtNumber : TextView
    lateinit var txtName : TextView
    lateinit var txtDob : TextView
    lateinit var txtGender : TextView
    lateinit var txtAddress : TextView

    @SuppressLint("ResourceType")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_verify)
       // setSupportActionBar(toolbar)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
//        alert {
//            title = "Verify Successfully..."
//            yesButton {  }
//        }.show()

        verticalLayout {
            background = getDrawable(R.drawable.ic_logo)
//            toolbar {
//                backgroundColor = Color.rgb(0,105,92)
//                title = "Verify Activity"
//                setNavigationIcon(R.drawable.ic_arrow_back_black_24dp)
//                setNavigationOnClickListener{
//                    onBackPressed()
//                }
//                setTitleTextColor(Color.WHITE)
//            }.lparams(width = matchParent, height = dip(50))


            linearLayout {
                padding = dip(30)
                orientation = LinearLayout.HORIZONTAL

                imgUser=imageView(R.drawable.ic_person_black_24dp)
                {
                    id = R.string.imgUser
                    backgroundColor = Color.LTGRAY
                }.lparams(width = dip(150), height = dip(150)) {
                    horizontalMargin = dip(5)
                }

                verticalLayout {
                    padding = dip(10)
                    txtUser=textView("User_ID : ") {
                        id = R.string.txtUser
                        textSize = 20f
                        typeface = Typeface.DEFAULT_BOLD
                    }
                    txtId= textView("123456789123") {
                        id = R.string.txtId
                        textSize = 20f

                    }.lparams(width = wrapContent, height = wrapContent) {
                        verticalMargin = dip(10)
                    }
                    txtAdhar=textView("Aadhaar_Id : ") {
                        id = R.string.txtAadharNum
                        textSize = 20f
                        typeface = Typeface.DEFAULT_BOLD
                    }
                    txtNumber=textView("1212121212") {
                        id = R.string.txtNumber
                        textSize = 20f
                    }
                }
            }

            //padding = dip(5)
            verticalLayout {

                padding=dip(10)
                lparams(width = wrapContent, height = wrapContent) {
                    horizontalMargin = dip(5)
                }
                txtName = textView("Name : ") {
                    id = R.string.txtName
                    textSize = 20f
                    typeface = Typeface.DEFAULT_BOLD
                }
                txtDob = textView("DOB : ") {
                    id = R.string.txtDob
                    textSize = 20f
                    typeface = Typeface.DEFAULT_BOLD
                }
                txtGender = textView("Gender : ") {
                    id = R.string.txtGender
                    textSize = 20f
                    typeface = Typeface.DEFAULT_BOLD
                }
                txtAddress = textView("Address : ") {
                    id = R.string.txtAddr
                    textSize = 20f
                    typeface = Typeface.DEFAULT_BOLD
                }
            }
        }

        Picasso.with(applicationContext)
                .load("https://i.imgur.com/DvpvklR.png")
                .into(imgUser)

        val ist : InputStream = assets.open("aadhar.json")
        val flDt = ist.bufferedReader().use {
            it.readText()
        }
        val gs= Gson()
        val demo=gs.fromJson<Demo>(flDt,Demo::class.java)
        val name : String = demo.name
        val dob : String = demo.dob
        val gender : String = demo.gender
        val address : String = demo.address


        if (txtName.text.isNotEmpty()) {
            txtName.append(name)
        }
        if (txtDob.text.isNotEmpty()) {
            txtDob.append(dob)
        }
        if (txtGender.text.isNotEmpty()) {
            txtGender.append(gender)
        }
        if (txtAddress.text.isNotEmpty()) {
            txtAddress.append(address)
        }
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        onBack()
        return true
    }

    private fun onBack() {

        startActivity(Intent(this@VerifyActivity,MainActivity::class.java))

    }

}
