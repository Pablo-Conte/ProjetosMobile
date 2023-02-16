package com.example.exemplodropdown

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.Spinner
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val spMenuSelecaoPlanetas = findViewById(R.id.spSelecaoPlanetas) as Spinner
        val tvPlaneta = findViewById(R.id.tvPlaneta) as TextView
        val planetas = resources.getStringArray(R.array.sistema_solar)
        val btnVerificar = findViewById(R.id.btnVerificar) as Button
        val adapterDados = ArrayAdapter (
            this, android.R.layout.simple_spinner_dropdown_item, planetas)

        spMenuSelecaoPlanetas.adapter = adapterDados

        spMenuSelecaoPlanetas.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(p0: AdapterView<*>?, view: View?, position: Int, id: Long) {
                tvPlaneta.setText(getString(R.string.msgSelecionado) + planetas[position])
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {

            }
        }

        btnVerificar.setOnClickListener() {
            val sSelecao: String = planetas[spMenuSelecaoPlanetas.selectedItemPosition]
            Toast.makeText(
            this,
            "Planeta selecionado é " + sSelecao,
            Toast.LENGTH_SHORT).show()
        }
    }
}