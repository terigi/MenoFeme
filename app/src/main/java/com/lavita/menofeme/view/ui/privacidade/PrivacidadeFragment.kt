package com.lavita.menofeme.view.ui.privacidade

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.github.barteksc.pdfviewer.PDFView
import com.lavita.menofeme.R

class PrivacidadeFragment : Fragment() {
    private lateinit var pegarView: View
    private lateinit var viewPdfTcle: PDFView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        pegarView = inflater.inflate(R.layout.fragment_privacidade, container, false)

        viewPdfTcle = pegarView.findViewById(R.id.viewPdfTcle)
        viewPdfTcle.fromAsset("Privacidade.pdf").load()

        return pegarView

    }
}