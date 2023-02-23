package com.example.conversaodeunidade

import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val txtValor = findViewById(R.id.editValor) as EditText
        val spinnerSelecione = findViewById(R.id.spinnerSelecao) as Spinner
        val medidas = resources.getStringArray(R.array.medidas)
        val btnConverter = findViewById(R.id.btnConverter) as Button
        val txtvResultado = findViewById(R.id.txtvResultado) as TextView

        val adapterDados = ArrayAdapter(
            this,
            android.R.layout.simple_spinner_dropdown_item,
            medidas)
        spinnerSelecione.adapter = adapterDados

        var valor: Float = 0f
        var medida: String = ""
        var resultado: Float = 0f

        spinnerSelecione.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                medida = spinnerSelecione.selectedItem.toString()
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {
                val a = 1
            }
        }

        btnConverter.setOnClickListener() {
            try {
                valor = txtValor.text.toString().toFloat()
            } catch (e: java.lang.Exception) {
                txtvResultado.text = "Algo deu errado"
            }

            if (medida == "Bit (b)") {
                resultado = valor * 8
            } else if (medida == "Kilobyte (KB)") {
                resultado = valor * 1000
            } else if (medida == "Megabyte (MB)") {
                resultado = valor * 1000000
            } else if (medida == "Gigabyte (GB)") {
                resultado = valor * 1000000000
            } else if (medida == "Terabyte (TB)") {
                resultado = valor * 1000000000000
            } else {
                txtvResultado.text = "Algo deu errado"
            }

            txtvResultado.text = resultado.toString()

        }

    }
}