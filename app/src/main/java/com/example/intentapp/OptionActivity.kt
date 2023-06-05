package com.example.intentapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.Toast

class OptionActivity : AppCompatActivity() {
    lateinit var radioGroup: RadioGroup
    lateinit var pilih: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_option)

        pilih = findViewById(R.id.pilihButton)
        radioGroup = findViewById(R.id.radio_group)

        pilih.setOnClickListener{
            var id: Int = radioGroup.checkedRadioButtonId
            val radio: RadioButton = findViewById(id)
            setResult(RESULT_OK, Intent().putExtra("Warna",radio.text))
            finish()
        }
    }
}