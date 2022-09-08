package com.example.aplicativo02testebutton

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        // Associar o Button com uma variável
        val btnClique = findViewById(R.id.btnClique) as Button

        btnClique.setOnClickListener {
            val txtvMensagem = findViewById(R.id.txtvMensagem) as TextView
            val etxtMensagem = findViewById(R.id.etxtMensagem) as EditText
            txtvMensagem.setText(etxtMensagem.text)
        }


    }// fim da função "oncreate"


}// Fim da função "Main"