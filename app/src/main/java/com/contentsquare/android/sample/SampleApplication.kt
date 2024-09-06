package com.contentsquare.android.sample

import android.app.Activity
import android.app.Application
import android.os.Bundle
import com.contentsquare.android.sample.crash.CrashHelper

class SampleApplication : Application() {

    override fun onCreate() {
        super.onCreate()
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
