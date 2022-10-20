package com.example.segundosemestreaula1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AlertDialog

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnSorry = findViewById(R.id.btnSorry) as Button
        val txtSorry = findViewById(R.id.txtSorry) as TextView


        btnSorry.setOnClickListener({
            txtSorry.setText("I fucked up!")
        })
    }
}