package com.contentsquare.android.sample

import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.contentsquare.CSQ

import com.contentsquare.android.sample.analytics.Analytics
import com.contentsquare.android.sample.databinding.ActivityMaskingScenariosBinding

class MaskingScenariosActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMaskingScenariosBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMaskingScenariosBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    override fun onResume() {
        super.onResume()
        Analytics.trackScreen("Masking-Scenarios-Activity")
    }

    fun onSetDefaultMaskingOn(view: View) {
        CSQ.setDefaultMasking(true)
    }

    fun onSetDefaultMaskingOff(view: View) {
        CSQ.setDefaultMasking(false)
    }

    fun onMaskAllTextView(view: View) {
        CSQ.mask(TextView::class.java)
    }

    fun onUnmaskAllTextView(view: View) {
        CSQ.unmask(TextView::class.java)
    }

    fun onMaskAllImageView(view: View) {
        CSQ.mask(ImageView::class.java)
    }

    fun onUnmaskAllImageView(view: View) {
        CSQ.unmask(ImageView::class.java)
    }

    fun onUnmaskRedImageView(view: View) {
        CSQ.mask(binding.redImageView)
    }

    fun onMaskRedImageView(view: View) {
        CSQ.mask(binding.redImageView)
    }
}