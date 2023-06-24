package com.example.demo

import android.net.Uri
import android.webkit.WebResourceRequest
import android.webkit.WebView
import android.webkit.WebViewClient

class MyWebViewClient : WebViewClient() {

    override fun shouldOverrideUrlLoading(view: WebView?, request: WebResourceRequest?): Boolean {
        if (request != null) {
            if (Uri.parse(request.url.toString()).host.equals("m.facebook.com")) {
                return true
            }
        }
        return false
    }
}