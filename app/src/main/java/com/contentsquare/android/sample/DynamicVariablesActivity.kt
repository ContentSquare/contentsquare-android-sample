package com.contentsquare.android.sample

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.contentsquare.android.sample.analytics.Analytics
import com.contentsquare.android.sample.databinding.ActivityDynamicVariablesBinding

class DynamicVariablesActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDynamicVariablesBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDynamicVariablesBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    fun onSendText(view: View) {
        Analytics.sendDynamicVar(binding.textKey.text.toString(), binding.textValue.text.toString())
    }

    fun onSendNumber(view: View) {
        Analytics.sendDynamicVar(
            binding.numericKey.text.toString(),
            binding.numericValue.text.toString().toLong()
        )
    }
}
