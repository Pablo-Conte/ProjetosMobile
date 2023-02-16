package com.example.telaapresentacao

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler

class splash : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        val maxSplashTime: Long = 3000

        Handler().postDelayed({
            val telaPrincipal = Intent(this@splash, MainActivity::class.java)
            startActivity(telaPrincipal)
            finish()
        }, maxSplashTime)
    } // FIM
} // FIM