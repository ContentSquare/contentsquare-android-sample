package com.contentsquare.android.sample

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.contentsquare.android.sample.analytics.Analytics
import com.contentsquare.android.sample.databinding.ActivityCustomVariablesBinding
import com.contentsquare.api.model.CustomVar

class CustomVariablesActivity : AppCompatActivity() {

    private lateinit var binding: ActivityCustomVariablesBinding

    private var bannerType: BannerType = BannerType.CAROUSEL
    private var userLogged = true

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCustomVariablesBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    override fun onResume() {
        super.onResume()
        sendCustomVariables()
    }

    private fun sendCustomVariables() {
        // What is the current banner display mode?
        val bannerTypeCustomVar = CustomVar(
            index = 1,
            name = "banner_type",
            value = bannerType.name
        )
        // Is the user logged in?
        val loggingCustomVar = CustomVar(
            index = 5,
            name = "user_login_status",
            value = if (userLogged) "logged_in" else "logged_out"
        )
        Analytics.sendCustomVar(
            "CustomVariablesScreen",
            listOf(bannerTypeCustomVar, loggingCustomVar)
        )
    }
}

enum class BannerType {
    CAROUSEL,
    HORIZONTAL_LIST,
}
