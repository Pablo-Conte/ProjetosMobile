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

        var btn1 = findViewById(R.id.btn1) as Button
        var btn2 = findViewById(R.id.btn2) as Button
        var btn3 = findViewById(R.id.btn3) as Button
        var btn4 = findViewById(R.id.btn4) as Button
        var btn5 = findViewById(R.id.btn5) as Button
        var btn6 = findViewById(R.id.btn6) as Button
        var btn7 = findViewById(R.id.btn7) as Button
        var btn8 = findViewById(R.id.btn8) as Button
        var btn9 = findViewById(R.id.btn9) as Button

        //Função para colocar números no edit text em focus: putNumber()
        //1 -> Passar um Int no listener do btn@ como parametro
        //2 -> Pegar esse btn e verificar qual dos botões de 1..9 é para jogar dentro do edt em focus
        //3 -> Passar o número para dentro do edt

        fun putNumber(numero: String){
            if (edtOperando1.isFocused) {
                var edt: String = edtOperando1.text.toString() + numero
                if (edtOperando1.text.isNotEmpty()) {
                    edtOperando1.setText(edt)
                } else {
                    edtOperando1.setText(numero)
                }

            }
            if (edtOperando2.isFocused){
                var edt = edtOperando2.text.toString() + numero
                if (edtOperando2.text.isNotEmpty()) {
                    edtOperando2.setText(edt)
                } else {
                    edtOperando2.setText(numero)
                }

            }
        }

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
            btnLimpar.isEnabled = false
        }


        btn1.setOnClickListener(){ putNumber("1") }
        btn2.setOnClickListener(){ putNumber("2") }
        btn3.setOnClickListener(){ putNumber("3") }
        btn4.setOnClickListener(){ putNumber("4") }
        btn5.setOnClickListener(){ putNumber("5") }
        btn6.setOnClickListener(){ putNumber("6") }
        btn7.setOnClickListener(){ putNumber("7") }
        btn8.setOnClickListener(){ putNumber("8") }
        btn9.setOnClickListener(){ putNumber("9") }

    } //fim do create
} //fim do main