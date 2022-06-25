package com.grandmaaverse.pdfApp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.AdSize
import com.google.android.gms.ads.AdView
import com.google.android.gms.ads.MobileAds

class IndexActivity : AppCompatActivity(), View.OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_index)

        val mAdView:AdView
        val mAdView1:AdView
        val mAdView2:AdView
        val mAdView3:AdView

        MobileAds.initialize(this) {}

        mAdView = findViewById(R.id.adView)
        mAdView1 = findViewById(R.id.adView2)
        mAdView2 = findViewById(R.id.adView3)
        mAdView3 = findViewById(R.id.adView4)
        val adRequest = AdRequest.Builder().build()
        mAdView.loadAd(adRequest)
        mAdView1.loadAd(adRequest)
        mAdView2.loadAd(adRequest)
        mAdView3.loadAd(adRequest)



        val ch1: Button = findViewById(R.id.ch1)
        val ch2: Button = findViewById(R.id.ch2)
        val ch3: Button = findViewById(R.id.ch3)
        val ch4: Button = findViewById(R.id.ch4)
        val ch5: Button = findViewById(R.id.ch5)
        val ch6: Button = findViewById(R.id.ch6)
        val ch7: Button = findViewById(R.id.ch7)
        val ch8: Button = findViewById(R.id.ch8)
        val ch9: Button = findViewById(R.id.ch9)
        val ch10: Button = findViewById(R.id.ch10)
        val ch11: Button = findViewById(R.id.ch11)
        val ch12: Button = findViewById(R.id.ch12)
        val ch13: Button = findViewById(R.id.ch13)
        val ch14: Button = findViewById(R.id.ch14)
        val ch15: Button = findViewById(R.id.ch15)
        val ch16: Button = findViewById(R.id.ch16)
        val ch17: Button = findViewById(R.id.ch17)
        val ch18: Button = findViewById(R.id.ch18)
        val ch19: Button = findViewById(R.id.ch19)
        val ch20: Button = findViewById(R.id.ch20)
        val ch21: Button = findViewById(R.id.ch21)
        val ch22: Button = findViewById(R.id.ch22)


        ch1.setOnClickListener(this)
        ch2.setOnClickListener(this)
        ch3.setOnClickListener(this)
        ch4.setOnClickListener(this)
        ch5.setOnClickListener(this)
        ch6.setOnClickListener(this)
        ch7.setOnClickListener(this)
        ch8.setOnClickListener(this)
        ch9.setOnClickListener(this)
        ch10.setOnClickListener(this)
        ch11.setOnClickListener(this)
        ch12.setOnClickListener(this)
        ch13.setOnClickListener(this)
        ch14.setOnClickListener(this)
        ch15.setOnClickListener(this)
        ch16.setOnClickListener(this)
        ch17.setOnClickListener(this)
        ch18.setOnClickListener(this)
        ch19.setOnClickListener(this)
        ch20.setOnClickListener(this)
        ch21.setOnClickListener(this)
        ch22.setOnClickListener(this)

    }

    override fun onClick(p0: View?) {

        when (p0?.id) {

            R.id.ch1 -> {
                val intent = Intent(this@IndexActivity, PdfActivity::class.java)
                intent.putExtra("chapterNo", "1")
                startActivity(intent)
            }
            R.id.ch2 -> {
                val intent = Intent(this@IndexActivity, PdfActivity::class.java)
                intent.putExtra("chapterNo", "2")
                startActivity(intent)
            }
            R.id.ch3 -> {
                val intent = Intent(this@IndexActivity, PdfActivity::class.java)
                intent.putExtra("chapterNo", "3")
                startActivity(intent)
            }
            R.id.ch4 -> {
                val intent = Intent(this@IndexActivity, PdfActivity::class.java)
                intent.putExtra("chapterNo", "4")
                startActivity(intent)
            }
            R.id.ch5 -> {
                val intent = Intent(this@IndexActivity, PdfActivity::class.java)
                intent.putExtra("chapterNo", "5")
                startActivity(intent)
            }
            R.id.ch6 -> {
                val intent = Intent(this@IndexActivity, PdfActivity::class.java)
                intent.putExtra("chapterNo", "6")
                startActivity(intent)
            }
            R.id.ch7 -> {
                val intent = Intent(this@IndexActivity, PdfActivity::class.java)
                intent.putExtra("chapterNo", "7")
                startActivity(intent)
            }
            R.id.ch8 -> {
                val intent = Intent(this@IndexActivity, PdfActivity::class.java)
                intent.putExtra("chapterNo", "8")
                startActivity(intent)
            }
            R.id.ch9 -> {
                val intent = Intent(this@IndexActivity, PdfActivity::class.java)
                intent.putExtra("chapterNo", "9")
                startActivity(intent)
            }
            R.id.ch10 -> {
                val intent = Intent(this@IndexActivity, PdfActivity::class.java)
                intent.putExtra("chapterNo", "10")
                startActivity(intent)
            }
            R.id.ch11 -> {
                val intent = Intent(this@IndexActivity, PdfActivity::class.java)
                intent.putExtra("chapterNo", "11")
                startActivity(intent)
            }
            R.id.ch12 -> {
                val intent = Intent(this@IndexActivity, PdfActivity::class.java)
                intent.putExtra("chapterNo", "12")
                startActivity(intent)
            }
            R.id.ch13 -> {
                val intent = Intent(this@IndexActivity, PdfActivity::class.java)
                intent.putExtra("chapterNo", "13")
                startActivity(intent)
            }
            R.id.ch14 -> {
                val intent = Intent(this@IndexActivity, PdfActivity::class.java)
                intent.putExtra("chapterNo", "14")
                startActivity(intent)
            }
            R.id.ch15 -> {
                val intent = Intent(this@IndexActivity, PdfActivity::class.java)
                intent.putExtra("chapterNo", "15")
                startActivity(intent)
            }
            R.id.ch16 -> {
                val intent = Intent(this@IndexActivity, PdfActivity::class.java)
                intent.putExtra("chapterNo", "16")
                startActivity(intent)
            }
            R.id.ch17 -> {
                val intent = Intent(this@IndexActivity, PdfActivity::class.java)
                intent.putExtra("chapterNo", "17")
                startActivity(intent)
            }
            R.id.ch18 -> {
                val intent = Intent(this@IndexActivity, PdfActivity::class.java)
                intent.putExtra("chapterNo", "18")
                startActivity(intent)
            }
            R.id.ch19 -> {
                val intent = Intent(this@IndexActivity, PdfActivity::class.java)
                intent.putExtra("chapterNo", "19")
                startActivity(intent)
            }

            R.id.ch20 -> {
                val intent = Intent(this@IndexActivity, PdfActivity::class.java)
                intent.putExtra("chapterNo", "20")
                startActivity(intent)
            }
            R.id.ch21 -> {
                val intent = Intent(this@IndexActivity, PdfActivity::class.java)
                intent.putExtra("chapterNo", "21")
                startActivity(intent)
            }
            R.id.ch22 -> {
                val intent = Intent(this@IndexActivity, PdfActivity::class.java)
                intent.putExtra("chapterNo", "22")
                startActivity(intent)
            }
        }
    }
}