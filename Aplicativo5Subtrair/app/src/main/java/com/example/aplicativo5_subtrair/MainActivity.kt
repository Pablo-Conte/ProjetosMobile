package com.example.aplicativo5_subtrair

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import android.widget.Toast.LENGTH_SHORT

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var edtOperando1 = findViewById(R.id.edtOperando1) as EditText
        var edtOperando2 = findViewById(R.id.edtOperando2) as EditText
        var btnCalcular = findViewById(R.id.btnCalcular) as Button
        var btnLimpar = findViewById(R.id.btnLimpar) as Button
        var tvResultado = findViewById(R.id.tvResultado) as TextView
        var errorMessage: String = ""

        btnLimpar.isEnabled = false

        btnCalcular.setOnClickListener() {
            if(edtOperando1.text.isNotEmpty() && edtOperando2.text.isNotEmpty()){
                try {
                    var subtracao: Int = edtOperando1.text.toString().toInt() - edtOperando2.text.toString().toInt()
                    tvResultado.setText("Resultado da Operação: " + subtracao.toString())
                    btnLimpar.isEnabled = true
                } catch (e:Exception) {
                    edtOperando1.text.clear()
                    edtOperando2.text.clear()
                    edtOperando1.requestFocus()
                    btnLimpar.isEnabled = false
                    errorMessage = "Dígitos inválidos, por favor, preencha os campos novamente com número inteiros positivos"
                    Toast.makeText(applicationContext, errorMessage, LENGTH_SHORT).show()
                }
            } else {
                errorMessage = "Você deixou um dos campos vazios, por favor preencha-os"
                Toast.makeText(applicationContext, errorMessage, LENGTH_SHORT).show()
            }



        }

        btnLimpar.setOnClickListener() {

            edtOperando1.text.clear()
            edtOperando2.text.clear()
            edtOperando1.requestFocus()
            tvResultado.setText("Resultado da Operação")
            btnLimpar.isEnabled = false
        }

    } //fim do create
} //fim do main