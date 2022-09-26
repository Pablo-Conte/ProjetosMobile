package com.example.aplicativo5_subtrair

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        var btnSoma = findViewById(R.id.btnSoma) as Button
        var btnSubtracao = findViewById(R.id.btnSubtrair) as Button
        var btnDivisao = findViewById(R.id.btnDividir) as Button
        var btnMultiplicacao = findViewById(R.id.btnMultiplicacao) as Button
        var btnLimpar = findViewById(R.id.btnLimpar) as Button
        var errorMessage: String = ""
        var tvOperacao = findViewById(R.id.tvOperacao) as TextView
        var tvNumeros = findViewById(R.id.tvNumeros) as TextView

        var btn1 = findViewById(R.id.btn1) as Button
        var btn2 = findViewById(R.id.btn2) as Button
        var btn3 = findViewById(R.id.btn3) as Button
        var btn4 = findViewById(R.id.btn4) as Button
        var btn5 = findViewById(R.id.btn5) as Button
        var btn6 = findViewById(R.id.btn6) as Button
        var btn7 = findViewById(R.id.btn7) as Button
        var btn8 = findViewById(R.id.btn8) as Button
        var btn9 = findViewById(R.id.btn9) as Button
        var btn0 = findViewById(R.id.btn0) as Button
        var btnIgual = findViewById(R.id.btnIgual) as Button
        var btnPonto = findViewById(R.id.btnPonto) as Button

        fun putNumber(numero: String){

            btnPonto.isEnabled = true
            btnLimpar.isEnabled = true
            tvOperacao.setText(tvOperacao.text.toString() + numero)
            tvNumeros.setText(tvNumeros.text.toString() + numero)
        }

        var operando1: String = ""
        var operando2: String = ""
        var operacao: String = ""
        var resultado: Float = 0f

        btnLimpar.isEnabled = false
        btnPonto.isEnabled = false
        btnIgual.isEnabled = false

        btnSubtracao.setOnClickListener() {

            operando1 = tvOperacao.text.toString()
            putNumber("-")
            tvNumeros.text = ""
            operacao = "-"
            btnIgual.isEnabled = true

        }

        btnSoma.setOnClickListener() {

            operando1 = tvOperacao.text.toString()
            putNumber("+")
            tvNumeros.text = ""
            operacao = "+"
            btnIgual.isEnabled = true

        }

        btnDivisao.setOnClickListener() {

            operando1 = tvOperacao.text.toString()
            putNumber("/")
            tvNumeros.text = ""
            operacao = "/"
            btnIgual.isEnabled = true

        }
        btnMultiplicacao.setOnClickListener() {

            operando1 = tvOperacao.text.toString()
            putNumber("x")
            tvNumeros.text = ""
            operacao = "x"
            btnIgual.isEnabled = true

        }

        btnLimpar.setOnClickListener() {

            tvOperacao.text = ""
            tvNumeros.text = ""
            btnLimpar.isEnabled = false
            btnPonto.isEnabled = false

        }

        btnIgual.setOnClickListener() {

            operando2 = tvNumeros.text.toString()

            if (operacao == "+"){
                resultado = operando1.toFloat() + operando2.toFloat()
            }

            if (operacao == "-"){
                resultado = operando1.toFloat() - operando2.toFloat()
            }

            if (operacao == "x"){
                resultado = operando1.toFloat() * operando2.toFloat()
            }

            if (operacao == "/"){
                resultado = operando1.toFloat() / operando2.toFloat()
            }

            tvNumeros.setText(resultado.toString().format("%.2f"))
        }

        btn0.setOnClickListener(){ putNumber("0") }
        btn1.setOnClickListener(){ putNumber("1") }
        btn2.setOnClickListener(){ putNumber("2") }
        btn3.setOnClickListener(){ putNumber("3") }
        btn4.setOnClickListener(){ putNumber("4") }
        btn5.setOnClickListener(){ putNumber("5") }
        btn6.setOnClickListener(){ putNumber("6") }
        btn7.setOnClickListener(){ putNumber("7") }
        btn8.setOnClickListener(){ putNumber("8") }
        btn9.setOnClickListener(){ putNumber("9") }
        btnPonto.setOnClickListener(){ putNumber("."); btnPonto.isEnabled = false; btnPonto.isEnabled = false}

    } //fim do create
} //fim do main