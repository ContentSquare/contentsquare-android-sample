package com.contentsquare.android.sample

import android.app.Activity
import android.app.Application
import android.os.Bundle
import com.contentsquare.CSQ
import com.contentsquare.StartConfig
import com.contentsquare.android.sample.crash.CrashHelper
import com.contentsquare.api.model.AnalyticsOptions
import com.contentsquare.api.model.LogLevel
import com.contentsquare.api.model.ProductAnalyticsOptions

class SampleApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        // DEBUG log level is helpful for devs while implementing the SDK
        // should stay to INFO (default) in prod environment
        CSQ.debug.logLevel = LogLevel.DEBUG

        val analyticsOptions = AnalyticsOptions(
            enableViewAutocapture = true,
            disablePageviewAutocapture = true
        )
        CSQ.start(
            this,
            StartConfig.withEnvironmentId("3521501044", analyticsOptions)
        )
        CSQ.optIn()
        CrashHelper.init(this)

        registerActivityLifecycleCallbacks(object : ActivityLifecycleCallbacks {

            override fun onActivityResumed(activity: Activity) {
                CrashHelper.onActivityResumed(activity)
            }

            override fun onActivityStopped(activity: Activity) {
            }

            override fun onActivityCreated(activity: Activity, bundle: Bundle?) {
            }

            override fun onActivityStarted(activity: Activity) {
            }

            override fun onActivityPaused(activity: Activity) {
            }

            override fun onActivitySaveInstanceState(activity: Activity, bundle: Bundle) {
            }

            override fun onActivityDestroyed(activity: Activity) {
            }
        })
    }
}
