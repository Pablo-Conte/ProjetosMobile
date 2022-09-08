package com.example.aplicativo03_soma

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import android.view.View;

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val etxtn1 = findViewById(R.id.etxtn1) as EditText
        val etxtn2 = findViewById(R.id.etxtn2) as EditText
        val txtvSoma = findViewById(R.id.txtvSoma) as TextView
        val btnSomar = findViewById(R.id.btnSomar) as Button
        val btnLimpar = findViewById(R.id.btnLimpar) as Button
        val imgvStarBright = findViewById(R.id.imgvStarBright) as ImageView

        btnSomar.setOnClickListener {

            imgvStarBright.setVisibility(View.VISIBLE)

            val n1 = etxtn1.getText().toString().toInt()
            val n2 = etxtn2.getText().toString().toInt()

            val resultadoSoma = n1 + n2

            var a = resultadoSoma.toString()

            txtvSoma.setText("Result: " + a.toString())

        }

        btnLimpar.setOnClickListener(){
            etxtn1.text.clear()
            etxtn2.text.clear()
            txtvSoma.setText("Result")
            etxtn1.requestFocus()
            imgvStarBright.setVisibility(View.INVISIBLE)
        }

        etxtn1.setOnClickListener(){
            etxtn1.text.clear()
            imgvStarBright.setVisibility(View.INVISIBLE)
        }

        etxtn2.setOnClickListener() {
            etxtn2.text.clear()
            imgvStarBright.setVisibility(View.INVISIBLE)
        }

    }
}