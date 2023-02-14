package com.example.applicationcurriculumvitaev2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.util.Patterns
import android.widget.Button
import android.widget.RadioGroup
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout

class MainActivity : AppCompatActivity() {
    lateinit var fullName: TextInputEditText
    private lateinit var email: TextInputEditText
    lateinit var age: TextInputEditText
    var gender: String = "Male"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        fullName = findViewById(R.id.fullNameText)
        email = findViewById(R.id.emailText)
        age = findViewById(R.id.ageText)
        findViewById<RadioGroup>(R.id.genderRG).setOnCheckedChangeListener { group, checkedId ->
            gender = when (checkedId) {
                R.id.menRB -> "Male"
                R.id.womenRB -> "Female"
                else -> "Error"
            }
        }
        findViewById<Button>(R.id.toNext).setOnClickListener {
            toNext()
        }
    }

    private fun toNext() {
        var response = true
        val widgets = listOf(fullName, email, age)
        val backgrounds = listOf<TextInputLayout>(
            findViewById(R.id.textInputLayout1),
            findViewById(R.id.textInputLayout2),
            findViewById(R.id.textInputLayout3)
        )
        for ((widget, background) in widgets.zip(backgrounds)) {
            if (widget.text!!.isEmpty()) {
                background.error = "Must not be empty"
                response = false
            }
            else if ((widget == email) && (!widget.text!!.matches(Patterns.EMAIL_ADDRESS.toRegex()))) {
                background.error = "Must Be an email"
                response = false
            }
            else
                background.error = null
        }
        if (response) {
            Log.e("Pass", "Passed congrats!!")
            val intent = Intent(this, Resume::class.java)
            intent.putExtra("name", fullName.text.toString())
            intent.putExtra("email", email.text.toString())
            intent.putExtra("age", age.text.toString())
            intent.putExtra("gender", gender)
            startActivity(intent)
        }
    }
    }