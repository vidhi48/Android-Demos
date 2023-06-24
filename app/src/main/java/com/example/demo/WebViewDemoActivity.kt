package com.example.demo

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.KeyEvent
import com.example.androidproject.databinding.ActivityWebViewDemoBinding

class WebViewDemoActivity : AppCompatActivity() {

    private lateinit var binding: ActivityWebViewDemoBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityWebViewDemoBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setupWebView()
    }

    @SuppressLint("SetJavaScriptEnabled")
    private fun setupWebView() {
        val webViewSetting = binding.webView.settings
        webViewSetting.javaScriptEnabled = true
        val webViewClient = MyWebViewClient()
        binding.webView.webViewClient = webViewClient
        binding.webView.loadUrl("https://www.google.com")
    }

    override fun onKeyDown(keyCode: Int, event: KeyEvent?): Boolean {
        if (keyCode == KeyEvent.KEYCODE_BACK && binding.webView.canGoBack()) {
            binding.webView.goBack()
            return true
        }
        return super.onKeyDown(keyCode, event)
    }
}