package com.example.calculator

import android.media.VolumeShaper.Operation
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import java.nio.DoubleBuffer

class MainActivity : AppCompatActivity() {
    lateinit var textview:TextView
    lateinit var button_plus:Button
    lateinit var button_minus:Button
    lateinit var button_multiply:Button
    lateinit var button_div:Button
    lateinit var button_clear:Button
    lateinit var button_mod:Button
    lateinit var button_res:Button
    var lastNumber:Double=0.0//first input number in calclator
    var operator:Char?=null
    lateinit var operation:operations

    var secondNumber:Double=0.0


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        init()
        callBacks()
    }
    fun init(){
        textview=findViewById(R.id.txt1)
        button_plus=findViewById(R.id.btn1)
        button_minus=findViewById(R.id.btn2)
        button_multiply=findViewById(R.id.btn3)
        button_div=findViewById(R.id.btn4)
        button_clear=findViewById(R.id.btn8)
        button_mod=findViewById(R.id.btn12)
        button_res=findViewById(R.id.btn20)
    }
    fun callBacks(){
        button_clear.setOnClickListener { //button C-->do clear in textView
        clearInput()
        }
        button_plus.setOnClickListener {
            SavingFirstNumber()
            operation=operations.Plus

        }
        button_minus.setOnClickListener {
            SavingFirstNumber()
            operation=operations.Minus

        }
        button_multiply.setOnClickListener {
            SavingFirstNumber()
            operation=operations.Multiply
        }
        button_div.setOnClickListener {
            SavingFirstNumber()
            operation=operations.Div
        }
        button_mod.setOnClickListener {
            SavingFirstNumber()
            operation=operations.Mod

        }
        button_res.setOnClickListener {
            secondNumber=textview.text.toString().toDouble()
            val res=CurrentOperation()

            textview.text=res.toString()
        }

    }
    fun clearInput(){
        textview.text=""
    }
    fun SavingFirstNumber(){
        lastNumber=textview.text.toString().toDouble()
        clearInput()
    }
    fun CurrentOperation():Double{
        return when(operation){
            operations.Plus -> lastNumber+secondNumber
            operations.Minus -> lastNumber-secondNumber
            operations.Multiply ->lastNumber*secondNumber
            operations.Div -> lastNumber/secondNumber
            operations.Mod -> lastNumber%secondNumber
        }
    }
    //Numbers 1,2,3,4,5,6,7,8,9
    fun onclickNumber(V:View){
        var new_digit=(V as Button).text.toString()//new value in text view
        var old_digit=textview.text.toString()//old value in textView
        textview.text=old_digit+new_digit//old +new in textView
    }
}