package com.contentsquare.android.sample.fragment

import android.app.Dialog
import android.content.Context
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import com.contentsquare.CSQ
import com.contentsquare.android.sample.R

class CustomAlertDialog(
    context: Context,
    private val message: String,
    private val imageResId: Int = R.drawable.sense_ai_image,
    private val onOkPressed: (() -> Unit)? = null
) : Dialog(context) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.dialog_custom_alert)

        val messageView = findViewById<TextView>(R.id.alert_message)
        val imageView = findViewById<ImageView>(R.id.alert_image)
        val okButton = findViewById<Button>(R.id.alert_ok_button)

        messageView.text = message
        imageView.setImageResource(imageResId)
        okButton.setOnClickListener {
            onOkPressed?.invoke()
            dismiss()
        }
        // Apply Masking here
        CSQ.mask(messageView)
        CSQ.mask(imageView)
    }
}