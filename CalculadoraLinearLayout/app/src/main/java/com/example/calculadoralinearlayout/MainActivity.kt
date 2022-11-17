package com.example.calculadoralinearlayout

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var btnSoma = findViewById(R.id.btnSoma) as Button
        var btnSubtracao = findViewById(R.id.btnSubtrair) as Button
        var btnDivisao = findViewById(R.id.btnDividir) as Button
        var btnMultiplicacao = findViewById(R.id.btnMultiplicacao) as Button
        var btnLimpar = findViewById(R.id.btnLimpar) as Button
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
        var imgBtnBackspace = findViewById(R.id.imgBtnBackspace) as ImageButton
        var ponto: String = ""

        //Desabilitando botões para não ocasionar erros + variaveis anti-problema


        btnDivisao.isEnabled = false
        btnMultiplicacao.isEnabled = false
        btnDivisao.isEnabled = false
        btnSubtracao.isEnabled = false
        btnSoma.isEnabled = false
        btnLimpar.isEnabled = false
        btnPonto.isEnabled = false
        btnIgual.isEnabled = false
        var pontoVerify: Boolean = true
        var operando1: String = ""
        var operando2: String = ""
        var operacao: String = ""

        var resultado: Float = 0f
        var igualEnable: Boolean = false

        var aposResultado: Boolean = false //verifica se temos um resultado sendo apresentado

        fun putNumber(numero: String){

            if (tvNumeros.text.isEmpty()) {
                btnPonto.isEnabled = true
            }

            if (aposResultado == true) {
                pontoVerify = true
                tvOperacao.text = ""
                tvNumeros.text = ""
                btnLimpar.isEnabled = false
                btnPonto.isEnabled = false
                btnIgual.isEnabled = false
                operacao = ""
                aposResultado = false
                imgBtnBackspace.isEnabled = true
            }

            if (pontoVerify){
                btnPonto.isEnabled = true
                pontoVerify = false
            }

            if (igualEnable == true) {
                btnIgual.isEnabled = true
            }

            if (numero == ".") {
                btnPonto.isEnabled = false
            }

            if (operacao == ""){
                btnDivisao.isEnabled = true
                btnMultiplicacao.isEnabled = true
                btnDivisao.isEnabled = true
                btnSubtracao.isEnabled = true
                btnSoma.isEnabled = true
                btnLimpar.isEnabled = true
            }

            if (numero == "."){
                btnMultiplicacao.isEnabled = false
                btnDivisao.isEnabled = false
                btnSubtracao.isEnabled = false
                btnSoma.isEnabled = false
            }

            tvOperacao.setText(tvOperacao.text.toString() + numero)
            tvNumeros.setText(tvNumeros.text.toString() + numero)
        }

        imgBtnBackspace.setOnClickListener() {
            var TvNumerosTextLength = tvNumeros.text.toString().length

            if (TvNumerosTextLength == 0) {
                val duration = Toast.LENGTH_SHORT
                Toast.makeText(applicationContext, "Não foi possivel apagar", duration).show()
            } else {
                val textSomente = tvNumeros.text.toString()
                val textWithBack = textSomente.substring(0, textSomente.length - 1)
                val ultimaChar = textSomente[textSomente.length-1]
                if (ultimaChar == '.') {
                    btnPonto.isEnabled = true
                    btnMultiplicacao.isEnabled = true
                    btnDivisao.isEnabled = true
                    btnSubtracao.isEnabled = true
                    btnSoma.isEnabled = true
                }

                if (operando1.isNotEmpty()) {
                    tvNumeros.setText(textWithBack)
                    tvOperacao.setText(operando1 + operacao + textWithBack)
                } else {
                    tvNumeros.setText(textWithBack)
                    tvOperacao.setText(textWithBack)
                }
            }

            if (tvNumeros.text.isEmpty()) {
                btnPonto.isEnabled = false
                btnDivisao.isEnabled = false
                btnMultiplicacao.isEnabled = false
                btnSoma.isEnabled = false
                btnSubtracao.isEnabled = false
            }


        }

        btnSubtracao.setOnClickListener() {

            operando1 = tvOperacao.text.toString()
            putNumber("-")
            pontoVerify = true
            tvNumeros.text = ""
            operacao = "-"
            btnDivisao.isEnabled = false
            btnMultiplicacao.isEnabled = false
            btnDivisao.isEnabled = false
            btnSubtracao.isEnabled = false
            btnSoma.isEnabled = false
            igualEnable = true
            btnPonto.isEnabled = false

        }

        btnSoma.setOnClickListener() {

            operando1 = tvOperacao.text.toString()
            putNumber("+")
            pontoVerify = true
            tvNumeros.text = ""
            operacao = "+"
            btnDivisao.isEnabled = false
            btnMultiplicacao.isEnabled = false
            btnDivisao.isEnabled = false
            btnSubtracao.isEnabled = false
            btnSoma.isEnabled = false
            igualEnable = true
            btnPonto.isEnabled = false

        }

        btnDivisao.setOnClickListener() {

            operando1 = tvOperacao.text.toString()
            putNumber("/")
            pontoVerify = true
            tvNumeros.text = ""
            operacao = "/"
            btnDivisao.isEnabled = false
            btnMultiplicacao.isEnabled = false
            btnDivisao.isEnabled = false
            btnSubtracao.isEnabled = false
            btnSoma.isEnabled = false
            igualEnable = true
            btnPonto.isEnabled = false

        }
        btnMultiplicacao.setOnClickListener() {

            operando1 = tvOperacao.text.toString()
            putNumber("x")
            pontoVerify = true
            tvNumeros.text = ""
            operacao = "x"
            btnDivisao.isEnabled = false
            btnMultiplicacao.isEnabled = false
            btnDivisao.isEnabled = false
            btnSubtracao.isEnabled = false
            btnSoma.isEnabled = false
            igualEnable = true
            btnPonto.isEnabled = false

        }

        btnLimpar.setOnClickListener() {

            pontoVerify = true
            tvOperacao.text = ""
            tvNumeros.text = ""
            btnLimpar.isEnabled = false
            btnPonto.isEnabled = false
            btnIgual.isEnabled = false
            btnDivisao.isEnabled = false
            btnMultiplicacao.isEnabled = false
            btnSoma.isEnabled = false
            btnSubtracao.isEnabled = false
            operacao = ""
            imgBtnBackspace.isEnabled = true

        }

        btnIgual.setOnClickListener() {

            pontoVerify = true
            operando2 = tvNumeros.text.toString()

            if (operacao.isEmpty() || operando1.isEmpty() || operando2.isEmpty()){
                val duration = Toast.LENGTH_SHORT
                Toast.makeText(applicationContext, "Não foi possivel possivel realizar a operação", duration).show()
            } else {
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
                btnIgual.isEnabled = false
                igualEnable = false
                btnPonto.isEnabled = false
                aposResultado = true
                operando1 = ""
                operando2 = ""
                operacao = ""
                imgBtnBackspace.isEnabled = false
            }
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
        btnPonto.setOnClickListener(){ putNumber(".") }

    }
}