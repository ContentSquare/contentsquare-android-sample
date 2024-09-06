package com.contentsquare.android.sample.useridentifier

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.contentsquare.android.Contentsquare
import com.contentsquare.android.sample.analytics.Analytics
import com.contentsquare.android.sample.databinding.ActivityUserIdentifierBinding

class UserIdentifierActivity : AppCompatActivity() {

    private lateinit var binding: ActivityUserIdentifierBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityUserIdentifierBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.sendUserIdentifier.setOnClickListener {
            Analytics.sendUserIdentifier(binding.userIdentifierTextView.text.toString())
        }
    }
}
