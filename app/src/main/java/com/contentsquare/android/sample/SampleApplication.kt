package com.contentsquare.android.sample

import android.app.Activity
import android.app.Application
import android.os.Bundle
import com.contentsquare.CSQ
import com.contentsquare.android.sample.crash.CrashHelper
import com.contentsquare.api.model.ProductAnalyticsOptions

class SampleApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        CSQ.configureProductAnalytics(
            context = this,
            envId = "3521501044",
            options = ProductAnalyticsOptions(
                enableViewAutocapture = true,
                // Pageview capture is turned off in favor of manual screen tracking in this sample.
                disablePageviewAutocapture = true
            )
        )
        CSQ.start(this)
        CSQ.optIn(this)
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
