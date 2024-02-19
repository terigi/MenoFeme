package com.lavita.menofeme.view.ui.diario

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.lavita.menofeme.R

class DiarioFragment : Fragment() {

    private lateinit var pegarView: View

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        pegarView = inflater.inflate(R.layout.fragment_diario, container, false)

        return pegarView
    }
}