package com.example.avaliacao_pablo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val spSelecao = findViewById<Spinner>(R.id.spSelecao)
        val txtMensagem = findViewById<TextView>(R.id.txtMensagem)
        val opcoes = resources.getStringArray(R.array.selecao)

        val adapterDados = ArrayAdapter(
            this,
            android.R.layout.simple_spinner_dropdown_item,
            opcoes)
        spSelecao.adapter = adapterDados

        spSelecao.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>?, View: View, position: Int, id: Long) {
                txtMensagem.setText(opcoes[position])
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {
                TODO("Not yet implemented")
            }
        }
    }
}