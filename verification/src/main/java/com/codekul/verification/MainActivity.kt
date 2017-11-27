package com.codekul.verification

import android.annotation.SuppressLint
import android.content.Intent
import android.graphics.Color
import android.graphics.Typeface
import android.graphics.drawable.GradientDrawable
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.widget.TextInputEditText
import android.support.design.widget.TextInputLayout
import android.view.Gravity
import android.widget.Button
import android.view.View
import android.view.ViewManager
import android.widget.LinearLayout
import org.jetbrains.anko.*
import org.jetbrains.anko.custom.ankoView
import org.jetbrains.anko.sdk25.coroutines.onClick

class MainActivity : AppCompatActivity() {

    inline fun ViewManager.textInputEditText() = textInputEditText {}
    inline fun ViewManager.textInputEditText(theme: Int = 0, init: TextInputEditText.() -> Unit) = ankoView({ TextInputEditText(it) }, theme, init)

    inline fun ViewManager.textInputLayout() = textInputLayout {}
    inline fun ViewManager.textInputLayout(theme: Int = 0, init: TextInputLayout.() -> Unit) = ankoView({ TextInputLayout(it) }, theme, init)

    val ADHAR:Int=12
    lateinit var linear:LinearLayout
    lateinit var adhar:TextInputLayout
    lateinit var adharNum:TextInputEditText
    lateinit var send: Button
    lateinit var resend: Button
    lateinit var otp:TextInputLayout
    lateinit var otpNum:TextInputEditText
    lateinit var verify: Button
    lateinit var clear: Button

    @SuppressLint("ResourceType")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        verticalLayout {

            background=getDrawable(R.drawable.ic_logo)
            lparams(width = matchParent, height = matchParent)


           linearLayout {

                gravity=Gravity.CENTER
                padding = dip(value = 50)
                adhar = textInputLayout {
                    adharNum = textInputEditText {
                        id = R.string.txtAdhar
                        textSize = 24f
                        hint = "Enter Aadhar Number"
                    }
                }.lparams(width=dip(190),height = wrapContent)

                send = button("Send OTP") {
                    id = R.string.btnSend
                    background = buttonBg()
                    textColor = Color.rgb(13, 71, 161)
                    typeface = Typeface.DEFAULT_BOLD
                }
            }

            verticalLayout {


                padding = dip(10)

                otp =  textInputLayout {
                    visibility= View.INVISIBLE
                    otpNum=  textInputEditText {
                        id = R.string.txtOtp
                        textSize=24f
                        hint="Enter OTP"
                        inputType= android.text.InputType.TYPE_CLASS_TEXT or android.text.InputType.TYPE_NUMBER_VARIATION_PASSWORD
                    }
                }.lparams(width= dip(100),height = wrapContent){
                    gravity=Gravity.CENTER
                }

                linear=linearLayout {

                    visibility=View.INVISIBLE
                    padding=dip(20)

                    verify = button("verify adhar") {
                        id = R.string.btnVerify
                        text = "Verify"
                        background = buttonBg()
                        textColor = Color.rgb(13, 71, 161)
                        typeface = Typeface.DEFAULT_BOLD
//                        visibility = View.INVISIBLE
                        onClick {
                            if(otpNum.text.isNotEmpty()) {
                            startActivity(Intent(this@MainActivity, VerifyActivity::class.java))
//                                otpNum.text.clear()
                            backgroundColor=Color.rgb(21,101,192)
                            textColor=Color.WHITE
                            }
                            else{
                                toast("Enter OTP First..!!")
                            }
                        }
                    }.lparams(width = wrapContent, height = wrapContent){
                    horizontalMargin=dip(3)
                }

                    resend = button("Resend OTP") {
                        id = R.string.btnResend
                        textColor = Color.rgb(13, 71, 161)
                        background = buttonBg()
                        typeface = Typeface.DEFAULT_BOLD
//                        visibility = View.INVISIBLE
                        onClick {
                            toast("OTP Resend")
                            backgroundColor=Color.rgb(21,101,192)
                            textColor=Color.WHITE
                            adharNum.text.clear()
                            otpNum.text.clear()
                        }
                    }.lparams(width = wrapContent, height = wrapContent){
                        horizontalMargin=dip(3)
                    }

                    clear = button("Clear All") {
                        id = R.string.btnClear
                        textColor = Color.rgb(13, 71, 161)
                        background = buttonBg()
                        typeface = Typeface.DEFAULT_BOLD
//                        visibility = View.INVISIBLE

                    }.lparams(width = wrapContent, height = wrapContent){
                        horizontalMargin=dip(3)
                    }

                }
            }
        }

        send.onClick {
            if (adharNum.text.isNotEmpty()) {

                if (adharNum.text.length==ADHAR) {

            send.backgroundColor=Color.rgb(21,101,192)
            send.textColor=Color.WHITE
            otp.visibility=View.VISIBLE
            linear.visibility=View.VISIBLE
            verify.background=buttonBg()
            verify.textColor = Color.rgb(13, 71, 161)
            resend.background=buttonBg()
            resend.textColor = Color.rgb(13, 71, 161)
            clear.background=buttonBg()
            clear.textColor = Color.rgb(13, 71, 161)

            toast("OTP Send")

                }
                else{
                    toast("Please Enter Valid Adhar Number..!!")
                }
            }
            else{
                toast("Please Enter Adhar Number First..!!")
            }
        }
        clear.onClick {
            otp.visibility=View.INVISIBLE
            linear.visibility=View.INVISIBLE
            send.background=buttonBg()
            send.textColor = Color.rgb(13, 71, 161)
            clear.backgroundColor=Color.rgb(21,101,192)
            clear.textColor=Color.WHITE
            otpNum.text.clear()
            adharNum.text.clear()
        }
    }

    fun buttonBg() = GradientDrawable().apply {
        shape = GradientDrawable.RECTANGLE
        cornerRadius = 10f
        setStroke(2, Color.rgb(13, 71, 161))
    }

}
