package com.contentsquare.android.sample.analytics

import android.content.Context
import android.util.Log
import com.contentsquare.CSQ

import com.contentsquare.api.model.CustomVar
import com.contentsquare.api.model.Transaction

object Analytics {

    private val TAG = Analytics::class.java.simpleName

    fun trackScreen(screenName: String) {
        Log.i(TAG, "Screen: $screenName")
        CSQ.trackScreenview(screenName)
    }

    fun pushTransaction(transaction: Transaction) {
        CSQ.trackTransaction(transaction)
        Log.i(TAG, "Transaction: ${transaction.value} - ID: ${transaction.id}")
    }

    fun stopTracking() {
        CSQ.stop()
    }

    fun resumeTracking() {
        CSQ.resumeTracking()
    }

    fun optIn(context: Context) {
        CSQ.optIn(context)
    }

    fun optOut() {
        CSQ.optOut()
    }

    fun provideUserId(): String {
        return CSQ.metadata.userId.orEmpty()
    }

    fun sendDynamicVar(key: String, value: String) {
        CSQ.addDynamicVar(key, value)
    }

    fun sendDynamicVar(key: String, value: Long) {
        CSQ.addDynamicVar(key, value)
    }

    fun sendCustomVar(screenName: String, customVar: List<CustomVar>) {
        CSQ.trackScreenview(screenName, customVar)
    }

    fun sendUserIdentifier(identifier: String) {
        CSQ.sendUserIdentifier(identifier)
    }
}