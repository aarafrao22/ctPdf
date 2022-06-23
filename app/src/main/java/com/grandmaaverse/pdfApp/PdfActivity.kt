package com.grandmaaverse.pdfApp

import android.app.ActionBar
import android.content.SharedPreferences
import android.graphics.*
import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager.widget.ViewPager
import com.github.barteksc.pdfviewer.listener.OnPageChangeListener
import com.github.barteksc.pdfviewer.scroll.DefaultScrollHandle
import com.github.barteksc.pdfviewer.util.FitPolicy
import com.grandmaaverse.pdfApp.databinding.ActivityPdfBinding


class PdfActivity : AppCompatActivity(), OnPageChangeListener, View.OnClickListener {

    private lateinit var binding: ActivityPdfBinding
    private lateinit var sharedPref: SharedPreferences

    private var list: List<Int>? = null;
    private lateinit var editor: SharedPreferences.Editor
    var nightMode: Boolean = false
    var position: Int = 0

    private lateinit var nightBtn: ImageView
    private lateinit var page: ImageView
    private var pg: Int = 0
    var isTrue = true


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val decorView = window.decorView
        val uiOptions = View.SYSTEM_UI_FLAG_FULLSCREEN
        decorView.systemUiVisibility = uiOptions
        val actionBar: ActionBar? = actionBar
        actionBar?.hide()

        binding = ActivityPdfBinding.inflate(layoutInflater)
        setContentView(binding.root)


        nightBtn = findViewById(R.id.nightMode)

        setSupportActionBar(binding.toolbar)
        sharedPref = getSharedPreferences("myPref", MODE_PRIVATE)
        val pagesNo = sharedPref.getInt("page", 1)
        binding.nightMode.setOnClickListener(this)


        binding.pdfView.fromAsset("cashflow1.pdf")
            .defaultPage(pagesNo)
            .onPageChange(this)
            .swipeHorizontal(true)
            .pageSnap(true)
            .scrollHandle(DefaultScrollHandle(this, true))
            .autoSpacing(true)
            .enableAnnotationRendering(false)
            .pageFling(true)
            .pageFitPolicy(FitPolicy.BOTH)
            .nightMode(nightMode)
            .load()

    }

    override fun onPageChanged(page: Int, pageCount: Int) {
        isTrue = true
        editor = sharedPref.edit()
        editor.putInt("page", page)
        editor.apply()

    }

    override fun onClick(p0: View?) {

        when (p0?.id) {
            R.id.nightMode ->
                if (nightMode) {
                    // Turn off PDF night mode
                    binding.pdfView.setNightMode(false)
                    binding.pdfView.requestLayout()
                    nightMode = false
                    binding.mainBg.setBackgroundColor(Color.WHITE)
                    nightBtn.setImageResource(R.drawable.ic_moon)
                    Toast.makeText(this, "Day Mode Activated", Toast.LENGTH_SHORT).show()
                } else {
                    binding.pdfView.setNightMode(true)
                    nightMode = true
                    binding.mainBg.setBackgroundColor(Color.BLACK)
                    binding.pdfView.requestLayout()
                    nightBtn.setImageResource(R.drawable.ic_moonfilled)
                    Toast.makeText(this, "Night Mode Activated", Toast.LENGTH_SHORT).show()
                }


        }


    }


    private fun shiftChapters(chapterName: String) {
        when (chapterName) {
            "Why Don’t You Get a Job?" -> binding.pdfView.jumpTo(39, true)
            "Different Quadrants, Different People" -> binding.pdfView.jumpTo(23 + 28, true)
            "Security over Freedom" -> binding.pdfView.jumpTo(57 + 28, true)
            "The Three Kinds of Business Systems" -> binding.pdfView.jumpTo(81 + 28, true)
            "The Five Levels of Investors" -> binding.pdfView.jumpTo(95 + 28, true)
            "You Cannot See Money with Your Eyes" -> binding.pdfView.jumpTo(119 + 28, true)
            "Becoming Who You Are" -> binding.pdfView.jumpTo(149 + 28, true)
            "How Do I Get Rich?" -> binding.pdfView.jumpTo(165 + 28, true)
            "Be the Bank, Not the Banker" -> binding.pdfView.jumpTo(187 + 28, true)
            "Take Baby Steps" -> binding.pdfView.jumpTo(217 + 28, true)
            "Step 1: Time to Mind Own Business" -> binding.pdfView.jumpTo(233 + 28, true)
            "Step 2: Take Control of Your Cash Flow" -> binding.pdfView.jumpTo(239 + 28, true)
            "Step 3: Diff BW Risk and Risky" -> binding.pdfView.jumpTo(247 + 28, true)
            "Step 4: What Kind of Investor You r?" -> binding.pdfView.jumpTo(251 + 28, true)
            "Step 5: Seek Mentors" -> binding.pdfView.jumpTo(259 + 28, true)
            "Step 6: Disappointments, Your Strength" -> binding.pdfView.jumpTo(269 + 28, true)
            "Step 7: The Power of Faith" -> binding.pdfView.jumpTo(275 + 28, true)
            "In Summary" -> binding.pdfView.jumpTo(281 + 28, true)

        }
    }

}