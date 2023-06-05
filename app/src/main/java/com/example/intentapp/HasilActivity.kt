package com.example.intentapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class HasilActivity : AppCompatActivity() {
    lateinit var text: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_hasil)
        text = findViewById(R.id.textHasil)
        val message = intent.getStringExtra("String")
        if(message != null) {
            text.text = message
        }
        val myObj = intent.getBundleExtra("Bundle")
        if(myObj != null){
            text.text = "Nama = "+myObj.getString("Nama") + "\nUmur = " + myObj.getInt("Umur") + "\n" + myObj.getString("OK")
        }
    }
}