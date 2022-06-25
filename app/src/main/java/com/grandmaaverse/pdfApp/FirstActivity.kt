package com.grandmaaverse.pdfApp

import android.content.ActivityNotFoundException
import android.content.ComponentName
import android.content.ContentValues.TAG
import android.content.Context
import android.content.Intent
import android.content.pm.ResolveInfo
import android.net.Uri
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.google.android.gms.ads.*
import com.google.android.gms.ads.interstitial.InterstitialAd
import com.google.android.gms.ads.interstitial.InterstitialAdLoadCallback
import com.grandmaaverse.pdfApp.databinding.ActivityFirstBinding


class FirstActivity : AppCompatActivity() {
    private var mInterstitialAd: InterstitialAd? = null

    private lateinit var binding: ActivityFirstBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFirstBinding.inflate(layoutInflater)
        setContentView(binding.root)


        var adRequest1 = AdRequest.Builder().build()

        InterstitialAd.load(
            this,
            "ca-app-pub-8620621477902075/2069561655",
            adRequest1,
            object : InterstitialAdLoadCallback() {
                override fun onAdFailedToLoad(adError: LoadAdError) {
                    mInterstitialAd = null
                }

                override fun onAdLoaded(interstitialAd: InterstitialAd) {
                    mInterstitialAd = interstitialAd
                }
            })

        mInterstitialAd?.fullScreenContentCallback = object : FullScreenContentCallback() {
            override fun onAdClicked() {
                // Called when a click is recorded for an ad.
                Log.d(TAG, "Ad was clicked.")
            }

            override fun onAdDismissedFullScreenContent() {
                // Called when ad is dismissed.
                Log.d(TAG, "Ad dismissed fullscreen content.")
                mInterstitialAd = null
            }

            override fun onAdFailedToShowFullScreenContent(p0: AdError) {
                // Called when ad fails to show.
                Log.e(TAG, "Ad failed to show fullscreen content.")
                mInterstitialAd = null
            }

            override fun onAdImpression() {
                // Called when an impression is recorded for an ad.
                Log.d(TAG, "Ad recorded an impression.")
            }

            override fun onAdShowedFullScreenContent() {
                // Called when ad is shown.
                Log.d(TAG, "Ad showed fullscreen content.")
            }
        }

        val mAdView: AdView
        MobileAds.initialize(this) {}
        mAdView = findViewById(R.id.adView2)
        val adRequest = AdRequest.Builder().build()
        mAdView.loadAd(adRequest)

        binding.btnRead.setOnClickListener {
            if (mInterstitialAd != null) {
                mInterstitialAd?.show(this)
            } else {
                Log.d("TAG", "The interstitial ad wasn't ready yet.")
            }

            val intent: Intent = Intent(this, IndexActivity::class.java)
            startActivity(intent)

        }

        binding.btnReview.setOnClickListener {
            openAppRating(applicationContext)
        }

        binding.btnInsta.setOnClickListener {
            openInsta()
        }


    }

    private fun openInsta() {
        val uri = Uri.parse("https://www.instagram.com/psychologist_kashif/")
        val likeIng = Intent(Intent.ACTION_VIEW, uri)
        likeIng.setPackage("com.instagram.android")
        try {
            startActivity(likeIng)
        } catch (e: ActivityNotFoundException) {
            startActivity(
                Intent(
                    Intent.ACTION_VIEW,
                    Uri.parse("https://www.instagram.com/psychologist_kashif/")
                )
            )
        }
    }

    fun openAppRating(context: Context) {
        val appId: String = context.getPackageName()
        val rateIntent = Intent(
            Intent.ACTION_VIEW,
            Uri.parse("market://details?id=$appId")
        )
        var marketFound = false
        val otherApps: List<ResolveInfo> = context.getPackageManager()
            .queryIntentActivities(rateIntent, 0)
        for (otherApp in otherApps) {
            if (otherApp.activityInfo.applicationInfo.packageName
                == "com.android.vending"
            ) {
                val otherAppActivity = otherApp.activityInfo
                val componentName = ComponentName(
                    otherAppActivity.applicationInfo.packageName,
                    otherAppActivity.name
                )
                rateIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
                rateIntent.addFlags(Intent.FLAG_ACTIVITY_RESET_TASK_IF_NEEDED)
                rateIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
                rateIntent.component = componentName
                context.startActivity(rateIntent)
                marketFound = true
                break
            }
        }

        if (!marketFound) {
            val webIntent = Intent(
                Intent.ACTION_VIEW,
                Uri.parse("https://play.google.com/store/apps/details?id=$appId")
            )
            context.startActivity(webIntent)
        }
    }
}