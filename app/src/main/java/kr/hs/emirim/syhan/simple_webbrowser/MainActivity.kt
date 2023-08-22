package kr.hs.emirim.syhan.simple_webbrowser

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.Button
import android.widget.EditText

class MainActivity : AppCompatActivity() {
    lateinit var editUrl : EditText
    lateinit var btnGO : Button
    lateinit var btnBack : Button
    lateinit var webView : WebView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        editUrl = findViewById(R.id.editUrl)
        btnGO = findViewById(R.id.btnGo)
        btnBack = findViewById(R.id.btnBack)
        webView = findViewById(R.id.webView)

        webView.webViewClient = EmirimWebViewClient()

        var webSet = webView.settings
        webSet.builtInZoomControls = true

        btnGO.setOnClickListener {
            webView.loadUrl(editUrl.text.toString())
        }

        btnBack.setOnClickListener {
            webView.goBack()
        }

    }

    class EmirimWebViewClient : WebViewClient(){
        override fun shouldOverrideUrlLoading(view: WebView?, url: String?): Boolean {
            return super.shouldOverrideUrlLoading(view, url)
        }
    }
}