package com.ezyretirement.app.ext

import android.content.Context
import android.content.res.Resources.getSystem
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatImageView
import androidx.core.widget.doOnTextChanged
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.ezyretirement.app.R
import com.google.android.material.textfield.TextInputLayout
import java.text.DateFormat
import java.text.NumberFormat
import java.util.*
import kotlin.math.roundToInt

fun AppCompatActivity.commitFragment(fragment: Fragment) {
    this.supportFragmentManager.beginTransaction().replace(R.id.container, fragment).commit()
}


fun Fragment.replaceFragmentWith(fragment: Fragment){
    this.parentFragmentManager.beginTransaction()
        .addToBackStack("FRAG")
        .replace(R.id.container,fragment).commit()
}

fun AppCompatImageView.load(context: Context,url:String){
    if (url.isEmpty()) return
    Glide.with(context).load(url).into(this)
}


fun Long.toDateString(dateFormat: Int =  DateFormat.MEDIUM): String {
    val df = DateFormat.getDateInstance(dateFormat, Locale.getDefault())
    return df.format(this)
}


fun Fragment.isInputsValid(vararg inputs:TextInputLayout) :Boolean{
    val size = inputs.size
    var validCounter = 0

    inputs.forEach { input ->
        if ( !input.editText?.text?.isEmpty()!!){
            validCounter++
        }else{
            input.error = "${input.hint} field required!"
        }


    }

    return validCounter >= size
}


fun Fragment.checkInputTexts(vararg inputs:TextInputLayout){
        inputs.forEach { input ->
            input.editText?.doOnTextChanged { text, start, before, count ->
                if (text!!.length < 3){
                    input.error = "${input.hint} is not valid"
                }else{
                    input.error = null
                }
            }
        }
}


fun TextInputLayout.text():String{
    return this.editText!!.text.toString()
}

fun Double.toUSD():String{
    val format: NumberFormat = NumberFormat.getCurrencyInstance()
    format.maximumFractionDigits = 0
    format.currency = Currency.getInstance("USD")

    return format.format(this.roundToInt())
}

val Int.dp: Int get() = (this / getSystem().displayMetrics.density).toInt()