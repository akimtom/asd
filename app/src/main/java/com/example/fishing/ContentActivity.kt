package com.example.fishing

import android.os.Bundle
import android.os.PersistableBundle
import android.webkit.WebView
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class ContentActivity: AppCompatActivity() {
    lateinit var webView: WebView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.content2_layout)
        webView = findViewById(R.id.webV)

        //webView.loadUrl("file:///android_asset/itemh.html")
        webView.loadUrl("https://www.wildberries.ru/")
        /*var tvTitle = findViewById<TextView>(R.id.tvTitle)
        var tvDescr = findViewById<TextView>(R.id.tvContent)
        var  imgD = findViewById<ImageView>(R.id.imaContent)
        tvTitle.text = intent.getStringExtra("title")
        tvDescr.text = intent.getStringExtra("content")
        imgD.setImageResource(intent.getIntExtra("img",0))*/

    }
}