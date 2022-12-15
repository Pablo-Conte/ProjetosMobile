package com.example.placar

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var txtvPontosTime1 = findViewById(R.id.btnPontosTime1) as TextView
        var txtvPontosTime2 = findViewById(R.id.btnPontosTime2) as TextView
        var btnMaisTime1 = findViewById(R.id.btnMaisTime1) as Button
        var btnMaisTime2 = findViewById(R.id.btnMaisTime2) as Button
        var txtvSetPontosTime1 = findViewById(R.id.txtvSetPontosTime1) as TextView
        var txtvSetPontosTime2 = findViewById(R.id.txtvSetPontosTime2) as TextView
        var txtvSets = findViewById(R.id.txtvSetAtual) as TextView
        var btnSet1 = findViewById(R.id.btnSet1) as Button
        var btnSet3 = findViewById(R.id.btnSet3) as Button
        var btnSet5 = findViewById(R.id.btnSet5) as Button
        var btnEditar = findViewById(R.id.editar) as Button
        var btnMenosTime1 = findViewById(R.id.btnMenosTime1) as Button
        var btnMenosTime2 = findViewById(R.id.btnMenosTime2) as Button

        var set = 1
        var visivel = false
        var vencedorTime1 = "O time 1 Ganhou!"
        var vencedorTime2 = "O time 2 Ganhou!"

        fun reiniciarJogo() {
            txtvPontosTime1.text = "0"
            txtvPontosTime2.text = "0"
            txtvSetPontosTime1.text = "0"
            txtvSetPontosTime2.text = "0"
            txtvSets.text = "1"
        }

        fun anunciarVencedor(vencedor: String) {
            var toast = Toast.makeText(applicationContext, vencedor, Toast.LENGTH_LONG)
            toast.show()
        }

        fun reset() {
            btnSet1.setTextColor(Color.parseColor("#FFFFFF"))
            btnSet3.setTextColor(Color.parseColor("#0A071A"))
            btnSet5.setTextColor(Color.parseColor("#0A071A"))
        }

        fun validarSeGanhou(timeNumero: Int) {
            if (timeNumero == 1){
                if (set == 1 && txtvSetPontosTime1.text.toString().toInt() == 1) {
                    reiniciarJogo()
                    anunciarVencedor(vencedorTime1)
                    reset()
                } else if (set == 3 && txtvSetPontosTime1.text.toString().toInt() == 2) {
                    reiniciarJogo()
                    anunciarVencedor(vencedorTime1)
                    reset()
                } else if (set == 5 && txtvSetPontosTime1.text.toString().toInt() == 3) {
                    reiniciarJogo()
                    anunciarVencedor(vencedorTime1)
                    reset()
                }
            } else if (timeNumero == 2) {
                if (set == 1 && txtvSetPontosTime2.text.toString().toInt() == 1) {
                    reiniciarJogo()
                    anunciarVencedor(vencedorTime2)
                    reset()
                } else if (set == 3 && txtvSetPontosTime2.text.toString().toInt() == 2) {
                    reiniciarJogo()
                    anunciarVencedor(vencedorTime2)
                    reset()
                } else if (set == 5 && txtvSetPontosTime2.text.toString().toInt() == 3){
                    reiniciarJogo()
                    anunciarVencedor(vencedorTime2)
                    reset()
                }
            }
        }

        fun validarSituacao(time: TextView, timeNumero: Int) {
            if (time.text.toString().toInt() >= 25){
                if (timeNumero == 1){
                    if ((time.text.toString().toInt() - txtvPontosTime2.text.toString().toInt()) >= 2) {
                        txtvPontosTime1.text = "0"
                        txtvPontosTime2.text = "0"
                        var Ponto = txtvSetPontosTime1.text.toString().toInt() + 1
                        txtvSetPontosTime1.text = Ponto.toString()
                        var txtSets = txtvSets.text.toString().toInt() + 1
                        txtvSets.text = txtSets.toString()
                        validarSeGanhou(timeNumero)
                    }
                } else if (timeNumero == 2) {
                    if ((time.text.toString().toInt() - txtvPontosTime1.text.toString().toInt()) >= 2) {
                        txtvPontosTime1.text = "0"
                        txtvPontosTime2.text = "0"
                        var Ponto = txtvSetPontosTime2.text.toString().toInt() + 1
                        txtvSetPontosTime2.text = Ponto.toString()
                        var txtSets = txtvSets.text.toString().toInt() + 1
                        txtvSets.text = txtSets.toString()
                        validarSeGanhou(timeNumero)
                    }
                }
            }
        }



        fun acrescentarPontos(time: TextView, timeNumero: Int) {

            var numeroPontosTime = time.text.toString().toInt()
            numeroPontosTime = numeroPontosTime + 1
            time.text = numeroPontosTime.toString()
            validarSituacao(time, timeNumero)
        }

        btnMaisTime1.setOnClickListener() { acrescentarPontos(txtvPontosTime1, 1) }
        btnMaisTime2.setOnClickListener() { acrescentarPontos(txtvPontosTime2, 2) }
        btnSet1.setOnClickListener() {
            btnSet1.setTextColor(Color.parseColor("#FFFFFF"))
            btnSet3.setTextColor(Color.parseColor("#0A071A"))
            btnSet5.setTextColor(Color.parseColor("#0A071A"))
            reiniciarJogo()
            set = 1
        }
        btnSet3.setOnClickListener() {
            btnSet1.setTextColor(Color.parseColor("#0A071A"))
            btnSet3.setTextColor(Color.parseColor("#FFFFFF"))
            btnSet5.setTextColor(Color.parseColor("#0A071A"))
            reiniciarJogo()
            set = 3
        }
        btnSet5.setOnClickListener() {
            btnSet1.setTextColor(Color.parseColor("#0A071A"))
            btnSet3.setTextColor(Color.parseColor("#0A071A"))
            btnSet5.setTextColor(Color.parseColor("#FFFFFF"))
            reiniciarJogo()
            set = 5
        }
        btnEditar.setOnClickListener() {
            if (visivel == false){
                btnMenosTime1.visibility = View.VISIBLE
                btnMenosTime2.visibility = View.VISIBLE
                visivel = true
            } else if (visivel == true) {
                btnMenosTime1.visibility = View.INVISIBLE
                btnMenosTime2.visibility = View.INVISIBLE
                visivel = false
            }

        }

        btnMenosTime1.setOnClickListener() {
            var Ponto = txtvPontosTime1.text.toString().toInt() - 1
            if (Ponto < 0) {
                Ponto = 0
            }
            txtvPontosTime1.text = Ponto.toString()
        }

        btnMenosTime2.setOnClickListener() {
            var Ponto = txtvPontosTime2.text.toString().toInt() - 1
            if (Ponto < 0) {
                Ponto = 0
            }
            txtvPontosTime2.text = Ponto.toString()
        }


    }
}