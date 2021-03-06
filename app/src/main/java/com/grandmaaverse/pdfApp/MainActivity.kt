package com.grandmaaverse.pdfApp

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.AdView
import com.google.android.gms.ads.LoadAdError
import com.google.android.gms.ads.MobileAds
import com.google.android.gms.ads.interstitial.InterstitialAd
import com.google.android.gms.ads.interstitial.InterstitialAdLoadCallback
import com.grandmaaverse.pdfApp.R

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val SPLASH_DISPLAY_LENGTH: Long = 2200
        Handler().postDelayed({


            val mainIntent = Intent(this@MainActivity, FirstActivity::class.java)
            startActivity(mainIntent)
            finish()

        }, SPLASH_DISPLAY_LENGTH)

    }
}