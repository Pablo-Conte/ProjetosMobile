package com.example.aplicativo04_dividir

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

        var edtOperando1 = findViewById(R.id.edtOperando1) as EditText;
        var edtOperando2 = findViewById(R.id.edtOperando2) as EditText;

        var btnSoma = findViewById(R.id.btnSoma) as Button;
        var btnSubtrair = findViewById(R.id.btnSubtrair) as Button;
        var btnMultiplicar = findViewById(R.id.btnMultiplicar) as Button;
        var btnDividir = findViewById(R.id.btnDividir) as Button;

        var btnLimpar = findViewById(R.id.btnLimpar) as Button;

        var tvResultado = findViewById(R.id.tvResultado) as TextView;

        btnSoma.setOnClickListener(){
            if (edtOperando1.text.isNotEmpty() && edtOperando2.text.isNotEmpty()){
                var n1 = edtOperando1.text.toString().toFloat()
                var n2 = edtOperando2.text.toString().toFloat()
                var resul = n1 + n2;
                tvResultado.text = resul.toString()
            } else {
                val msg: String = "É preciso digitar os dois operandos"
                Toast.makeText(applicationContext, msg, LENGTH_SHORT).show()
            }

        }

        btnSubtrair.setOnClickListener(){
            if (edtOperando1.text.isNotEmpty() && edtOperando2.text.isNotEmpty()){
                var n1 = edtOperando1.text.toString().toFloat()
                var n2 = edtOperando2.text.toString().toFloat()
                var resul = n1 - n2;
                tvResultado.text = resul.toString()
            } else {
                val msg: String = "É preciso digitar os dois operandos"
                Toast.makeText(applicationContext, msg, LENGTH_SHORT).show()
            }

        }

        btnDividir.setOnClickListener(){
            if (edtOperando1.text.isNotEmpty() && edtOperando2.text.isNotEmpty()){
                var n1 = edtOperando1.text.toString().toFloat()
                var n2 = edtOperando2.text.toString().toFloat()
                var resul = n1 / n2;
                tvResultado.text = resul.toString()
            } else {
                val msg: String = "É preciso digitar os dois operandos"
                Toast.makeText(applicationContext, msg, LENGTH_SHORT).show()
            }

        }

        btnMultiplicar.setOnClickListener(){
            if (edtOperando1.text.isNotEmpty() && edtOperando2.text.isNotEmpty()){
                var n1 = edtOperando1.text.toString().toFloat()
                var n2 = edtOperando2.text.toString().toFloat()
                var resul = n1 * n2;
                tvResultado.text = resul.toString()
            } else {
                val msg: String = "É preciso digitar os dois operandos"
                Toast.makeText(applicationContext, msg, LENGTH_SHORT).show()
            }

        }

        edtOperando1.setOnClickListener(){
            edtOperando1.text.clear()
        }

        edtOperando2.setOnClickListener(){
            edtOperando2.text.clear()
        }

        btnLimpar.setOnClickListener(){
            edtOperando1.text.clear()
            edtOperando2.text.clear()
            tvResultado.setText("Resultado da operação")
            edtOperando1.requestFocus()
        }
    }
}