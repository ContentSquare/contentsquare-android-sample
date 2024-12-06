package com.contentsquare.android.sample

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.contentsquare.android.Contentsquare
import com.contentsquare.android.sample.analytics.Analytics
import com.contentsquare.android.sample.databinding.ActivityEventTriggeredReplayBinding

class EventTriggeredReplayActivity : AppCompatActivity() {

    private lateinit var binding: ActivityEventTriggeredReplayBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityEventTriggeredReplayBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    override fun onResume() {
        super.onResume()
        Analytics.trackScreen("Event-Triggered-Replay-Activity")
    }

    fun triggerReplayForCurrentScreen(view: View) {
        Contentsquare.triggerReplayForCurrentScreen("etr-screen-name")
    }

    fun triggerReplayForCurrentSession(view: View) {
        Contentsquare.triggerReplayForCurrentSession("etr-session-name")
    }
}
