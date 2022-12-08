package com.example.placar

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

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

        fun reiniciarJogo() {
            txtvPontosTime1.text = "0"
            txtvPontosTime2.text = "0"
            txtvSetPontosTime1.text = "0"
            txtvSetPontosTime2.text = "0"
        }

        fun validarSituacao(time: TextView, timeNumero: Int) {
            if (time.text.toString().toInt() >= 25){
                if (timeNumero == 1){
                    if ((time.text.toString().toInt() - txtvPontosTime2.text.toString().toInt()) >= 2) {
                        txtvPontosTime1.text = "0"
                        txtvPontosTime2.text = "0"
                        var Ponto = txtvSetPontosTime1.text.toString().toInt() + 1
                        txtvSetPontosTime1.text = Ponto.toString()

                    }
                } else if (timeNumero == 2) {
                    if ((time.text.toString().toInt() - txtvPontosTime1.text.toString().toInt()) >= 2) {
                        txtvPontosTime1.text = "0"
                        txtvPontosTime2.text = "0"
                        var Ponto = txtvSetPontosTime2.text.toString().toInt() + 1
                        txtvSetPontosTime2.text = Ponto.toString()
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

        fun setarSet(timeNumero: Int){
            txtvSets.text = "$timeNumero°"
            reiniciarJogo()
        }

        btnMaisTime1.setOnClickListener() { acrescentarPontos(txtvPontosTime1, 1) }
        btnMaisTime2.setOnClickListener() { acrescentarPontos(txtvPontosTime2, 2) }
        btnSet1.setOnClickListener() { setarSet(1) }
        btnSet3.setOnClickListener() { setarSet(3) }
        btnSet5.setOnClickListener() { setarSet(5) }


    }
}