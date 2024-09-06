package com.contentsquare.android.sample.network

interface NetworkIntegration {
    fun sendRequest(
        url: String,
        clientCallTimeoutMs: Long = 10000,
        httpMethod: NetworkAnalysisActivity.HttpMethod,
        callback: (String) -> Unit
    )
}
