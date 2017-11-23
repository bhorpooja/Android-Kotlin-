package com.codekul.verifyadhar

import android.content.Intent
import android.graphics.Color
import android.graphics.Typeface
import android.graphics.drawable.GradientDrawable
import android.os.Build
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.widget.TextInputEditText
import android.support.design.widget.TextInputLayout
import android.view.Gravity
import android.view.View
import android.view.ViewManager
import android.widget.Button
import org.jetbrains.anko.*
import org.jetbrains.anko.custom.ankoView
import org.jetbrains.anko.sdk25.coroutines.onClick

class MainActivity : AppCompatActivity() {


    inline fun ViewManager.textInputEditText() = textInputEditText {}
    inline fun ViewManager.textInputEditText(theme: Int = 0, init: TextInputEditText.() -> Unit) = ankoView({ TextInputEditText(it) }, theme, init)

    inline fun ViewManager.textInputLayout() = textInputLayout {}
    inline fun ViewManager.textInputLayout(theme: Int = 0, init: TextInputLayout.() -> Unit) = ankoView({ TextInputLayout(it) }, theme, init)

    val ADHAR:Int=12
    lateinit var adhar:TextInputLayout
    lateinit var adharNum:TextInputEditText
    lateinit var send:Button
    lateinit var resend:Button
    lateinit var otp:TextInputLayout
    lateinit var otpNum:TextInputEditText
    lateinit var verify:Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        verticalLayout {

            lparams(width= wrapContent,height = wrapContent)
            padding=dip(70)
            gravity=Gravity.CENTER

            adhar =textInputLayout{
                adharNum = textInputEditText {
                    id=R.id.txtNum
                   textSize=20f
                    hint="Enter Aadhar Number"
                }
            }

            linearLayout {

                padding=dip(20)
                gravity=Gravity.CENTER

                lparams(width= wrapContent,height = wrapContent)

                 send = button("Send OTP") {
                    id = R.id.btnSend
                    background=buttonBg()
                    textColor = Color.rgb(0, 77, 64)
                    typeface= Typeface.DEFAULT_BOLD
//                     backgroundColor = Color.rgb(128, 203, 196)

                }

                resend = button("Resend OTP") {
                    id = R.id.btnResend
                    background=buttonBg()
//                    backgroundColor = Color.rgb(128, 203, 196)
                    textColor = Color.rgb(0, 77, 64)
                    typeface= Typeface.DEFAULT_BOLD
                    visibility=View.INVISIBLE
                    onClick {
                        backgroundColor = Color.rgb(77, 182, 172)
                        toast("OTP Resend")
                    }
                }
            }


            verticalLayout {
                gravity = Gravity.CENTER
                padding = dip(30)

                otp =  textInputLayout {
                    otpNum=  textInputEditText {
                        id = R.id.txtOtp
                        textSize=20f
                        hint="Enter OTP"
                    }
                     visibility=View.INVISIBLE
                }

                linearLayout {

                    padding = dip(20)
                    lparams(width = wrapContent, height = wrapContent)

                 verify=button("verify") {
                        id = R.id.btnVerify
                        text = "Verify"
                        background=buttonBg()
//                        backgroundColor = Color.rgb(77, 182, 172)
                        textColor = Color.rgb(0, 77, 64)
                        typeface= Typeface.DEFAULT_BOLD
                        visibility=View.INVISIBLE
                        onClick {
                            if(otpNum.text.isNotEmpty()) {
                                startActivity(Intent(applicationContext,
                                        VerifyActivity::class.java))
                                otpNum.text.clear()
                            }
                            else{
                                toast("Enter OTP First..!!")
                            }
                        }
                    }
                }
            }

        }

        send.onClick {

            send.backgroundColor=Color.rgb(77, 182, 172)
            if (adharNum.text.isNotEmpty()) {
                if (adharNum.text.length==ADHAR) {

                    resend.visibility=View.VISIBLE
                    otp.visibility=View.VISIBLE
                    verify.visibility=View.VISIBLE
                    toast("OTP Send")
                     adharNum.text.clear()
                }
                else{
                    toast("Please Enter Valid Adhar Number..!!")
                }
            }
            else{
                toast("Please Enter Adhar Number First..!!")
            }
        }



    }
    fun buttonBg() = GradientDrawable().apply {
        shape = GradientDrawable.RECTANGLE
        cornerRadius = 6f
        setStroke(2, Color.rgb(0, 77, 64))
    }
}
