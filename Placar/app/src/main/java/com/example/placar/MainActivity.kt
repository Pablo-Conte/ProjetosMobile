package com.example.placar

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var txtvPontosTime1 = findViewById(R.id.btnPontosTime1) as TextView
        var txtvPontosTime2 = findViewById(R.id.btnPontosTime2) as TextView
        var btnMaisTime1 = findViewById(R.id.btnMaisTime1) as Button
        var btnMaisTime2 = findViewById(R.id.btnMaisTime2) as Button

        fun acrescentarPontos(time: TextView) {

            var numeroPontosTime = time.text.toString().toInt()
            numeroPontosTime = numeroPontosTime + 1
            time.text = numeroPontosTime.toString()
        }

        btnMaisTime1.setOnClickListener() { acrescentarPontos(txtvPontosTime1) }
        btnMaisTime2.setOnClickListener() { acrescentarPontos(txtvPontosTime2) }

    }
}