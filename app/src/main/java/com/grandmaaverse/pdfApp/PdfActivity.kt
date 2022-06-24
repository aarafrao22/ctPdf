package com.grandmaaverse.pdfApp

import android.app.ActionBar
import android.content.SharedPreferences
import android.graphics.Color
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.github.barteksc.pdfviewer.listener.OnPageChangeListener
import com.github.barteksc.pdfviewer.scroll.DefaultScrollHandle
import com.github.barteksc.pdfviewer.util.FitPolicy
import com.grandmaaverse.pdfApp.databinding.ActivityPdfBinding


class PdfActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding: ActivityPdfBinding

    private var list: List<Int>? = null;
    var nightMode: Boolean = false
    var position: Int = 0

    private lateinit var nightBtn: ImageView
    private lateinit var page: ImageView
    private var pg: Int = 0
    var isTrue = true


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        binding = ActivityPdfBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val chapter = intent.getStringExtra("chapterNo")

        when (chapter) {
            "1" -> openPdf("Title")
            "2" -> openPdf("Introduction")
            "3" -> openPdf("Journey to Finding")
            "4" -> openPdf("Cause of Suffering")
            "5" -> openPdf("Why Do We Think")
            "6" -> openPdf("Thoughts VS Thinking")
            "7" -> openPdf("If We Can")
            "8" -> openPdf("The Three Principles")
            "9" -> openPdf("Stop Thinking")
            "10" -> openPdf("How Can We")
            "11" -> openPdf("If We Stop")
            "12" -> openPdf("Unconditional")
            "13" -> openPdf("What Do U Do")
            "14" -> openPdf("Nothing")
            "15" -> openPdf("Do Without")
            "16" -> openPdf("Follow Intuition")
            "17" -> openPdf("Miracles")
            "18" -> openPdf("Obstacles")
            "19" -> openPdf("Now What")
            "20" -> openPdf("Non-Thinking")
            "21" -> openPdf("Guide to Stop")
            "22" -> openPdf("Guide to Creating")
        }


        nightBtn = findViewById(R.id.nightMode)
        binding.nightMode.setOnClickListener(this)


    }

    private fun openPdf(pdfName: String) {

        binding.pdfView.fromAsset(pdfName + ".pdf")
            .defaultPage(0)
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