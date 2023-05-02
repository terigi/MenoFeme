package com.lavita.menofeme.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.github.barteksc.pdfviewer.PDFView
import com.lavita.menofeme.R

class Tcle : AppCompatActivity() {

    private lateinit var viewPdfTcle: PDFView

    private lateinit var btnProximo: androidx.appcompat.widget.AppCompatButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tcle)

        viewPdfTcle = findViewById(R.id.viewPdfTcle)
        btnProximo = findViewById(R.id.btnTcle)

        viewPdfTcle.fromAsset("TCLE.pdf").load()

        btnProximo.setOnClickListener {
            val intent = Intent(this, Cadastrar::class.java)
            intent.putExtra("Termos", "1")
            startActivity(intent)
            finish()
        }
    }
}