package com.grandmaaverse.pdfApp

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity
import com.grandmaaverse.pdfApp.R

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val SPLASH_DISPLAY_LENGTH: Long = 2200
        Handler().postDelayed({
            val mainIntent = Intent(this@MainActivity, FirstActivity::class.java)
            startActivity(mainIntent)

        }, SPLASH_DISPLAY_LENGTH)

    }
}