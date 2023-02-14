package com.example.applicationcurriculumvitaev2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class Result : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)
        val values= listOf(intent.getStringExtra("name")!!,intent.getStringExtra("email")!!
            ,intent.getStringExtra("age")!!,intent.getStringExtra("gender")!!
            ,intent.getStringExtra("android")!!,intent.getStringExtra("ios")!!
            ,intent.getStringExtra("flutter")!!)
        var result = ""
        val attrs = listOf("name","email","age","gender","android","ios","flutter")
        for ((attr,value) in attrs.zip(values)){
            result ="$result \n $attr: $value \n"
        }
        result ="\n \n${result}Languages: ${intent.getStringExtra("languages").toString().filter { c-> c.isLetter() || c.isWhitespace() }} \n \n"
        result ="\n ${result}Hobbies: ${intent.getStringExtra("hobbies").toString().filter { c-> c.isLetter() || c.isWhitespace() }} \n"
        findViewById<TextView>(R.id.result).text=result
    }
}