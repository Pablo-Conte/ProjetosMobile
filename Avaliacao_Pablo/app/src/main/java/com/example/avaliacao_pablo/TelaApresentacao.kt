package com.example.avaliacao_pablo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler

class TelaApresentacao : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tela_apresentacao)

        val tempoApresentacaoDaTela: Long = 2500
        Handler().postDelayed({
            val telaPrincipal = Intent(this@TelaApresentacao, MainActivity::class.java)
            startActivity(telaPrincipal)
            finish()
        }, tempoApresentacaoDaTela)
    }
}