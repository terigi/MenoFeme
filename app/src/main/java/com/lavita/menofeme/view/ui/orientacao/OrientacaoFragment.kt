package com.lavita.menofeme.view.ui.orientacao

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.core.os.bundleOf
import androidx.fragment.app.setFragmentResult
import com.lavita.menofeme.R
import com.lavita.menofeme.view.ui.estagio.ResultadoEstagioFragment
import com.lavita.menofeme.view.ui.home.HomeFragment


class OrientacaoFragment : Fragment() {
    private lateinit var pegarView: View
    private lateinit var btnObs1: ImageButton
    private lateinit var btnObs2: ImageButton
    private lateinit var btnObs3: ImageButton
    private lateinit var btnObs4: ImageButton
    private lateinit var resultadoOrientacaoFragment:  ResultadoOrientacaoFragment

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        pegarView = inflater.inflate(R.layout.fragment_orientacao, container, false)

        btnObs1 = pegarView.findViewById(R.id.btnObs1)
        btnObs2 = pegarView.findViewById(R.id.btnObs2)
        btnObs3 = pegarView.findViewById(R.id.btnObs3)
        btnObs4 = pegarView.findViewById(R.id.btnObs4)
        resultadoOrientacaoFragment = ResultadoOrientacaoFragment()


        btnObs1.setOnClickListener {
            val result = "1"
            setFragmentResult("requestKey", bundleOf("Orientacao" to result))
            setFragment(resultadoOrientacaoFragment)
        }

        btnObs2.setOnClickListener {
            val result = "2"
            setFragmentResult("requestKey", bundleOf("Orientacao" to result))
            setFragment(resultadoOrientacaoFragment)
        }

        btnObs3.setOnClickListener {
            val result = "3"
            setFragmentResult("requestKey", bundleOf("Orientacao" to result))
            setFragment(resultadoOrientacaoFragment)
        }

        btnObs4.setOnClickListener {
            val result = "4"
            setFragmentResult("requestKey", bundleOf("Orientacao" to result))
            setFragment(resultadoOrientacaoFragment)
        }

        return pegarView
    }
    private fun setFragment(fragment: Fragment){
        val fT = requireActivity().supportFragmentManager.beginTransaction()
        fT.replace(R.id.nav_host_fragment_content_principal, fragment)
        fT.commit()
    }
}