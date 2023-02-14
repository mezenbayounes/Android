package com.example.applicationcurriculumvitaev2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.CheckBox
import android.widget.SeekBar
import kotlin.Result

class Resume : AppCompatActivity() {
    private lateinit var gender: String
    lateinit var name: String
    lateinit var email: String
    lateinit var age: String
    private val selectedHobbies = mutableListOf<String>()
    private val selectedLanguages = mutableListOf<String>()
    private var androidSkill = 0
    private var iosSkill = 0
    private var flutterSkill = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_resume)


        name = intent.getStringExtra("name")!!
        email = intent.getStringExtra("email")!!
        age = intent.getStringExtra("age")!!
        gender = intent.getStringExtra("gender")!!

        val languages = listOf<CheckBox>(
            findViewById(R.id.arabicCB),
            findViewById(R.id.englishCB),
            findViewById(R.id.frenchCB)
        )
        languages.forEach { checkBox ->
            checkBox.setOnCheckedChangeListener { buttonView, isChecked ->
                Log.e(
                    "test checkbox",
                    "${buttonView.text} is selected and added to $selectedLanguages"
                )
                if (isChecked)
                    selectedLanguages.add(buttonView.text.toString())
                else
                    selectedLanguages.remove(buttonView.text.toString())
            }
        }
        val hobbies = listOf<CheckBox>(
            findViewById(R.id.musicCB),
            findViewById(R.id.sportCB),
            findViewById(R.id.gamesCB)
        )
        hobbies.forEach { checkBox ->
            checkBox.setOnCheckedChangeListener { buttonView, isChecked ->
                Log.e(
                    "test checkbox",
                    "${buttonView.text} is selected and added to $selectedHobbies"
                )
                if (isChecked)
                    selectedHobbies.add(buttonView.text.toString())
                else
                    selectedHobbies.remove(buttonView.text.toString())
            }
        }
        findViewById<Button>(R.id.submit).setOnClickListener{
            androidSkill = findViewById<SeekBar>(R.id.seekAndroid).progress
            iosSkill = findViewById<SeekBar>(R.id.seekIos).progress
            flutterSkill = findViewById<SeekBar>(R.id.seekFlutter).progress
            submit()
        }

    }

    private fun submit() {
        val intent = Intent(this, com.example.applicationcurriculumvitaev2.Result::class.java)
        intent.putExtra("name", name)
        intent.putExtra("email", email)
        intent.putExtra("age", age)
        intent.putExtra("gender", gender)
        intent.putExtra("android", androidSkill.toString())
        intent.putExtra("ios", iosSkill.toString())
        intent.putExtra("flutter", flutterSkill.toString())
        intent.putExtra("hobbies", "$selectedHobbies")
        intent.putExtra("languages", "$selectedLanguages")
        startActivity(intent)
    }
}