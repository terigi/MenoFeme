package com.lavita.menofeme.view.ui.tratamentos

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.TextView
import androidx.fragment.app.setFragmentResultListener
import com.lavita.menofeme.R
import com.lavita.menofeme.view.ui.home.HomeFragment

class ResultadoTratamentosFragment : Fragment() {
    private lateinit var pegarView: View
    private lateinit var txtResTrat1: TextView
    private lateinit var txtResTrat2: TextView
    private lateinit var btnHomeTrat: ImageButton
    private lateinit var Linha1Tipo1: String
    private lateinit var Linha2Tipo1: String
    private lateinit var Linha1Tipo2: String
    private lateinit var Linha2Tipo2: String
    private lateinit var Linha1Tipo3: String
    private lateinit var homeFragment: HomeFragment



    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        pegarView = inflater.inflate(R.layout.fragment_resultado_tratamentos, container, false)
        txtResTrat1 = pegarView.findViewById(R.id.txtResTrat1)
        txtResTrat1.setTextColor(resources.getColor(R.color.black))
        txtResTrat2 = pegarView.findViewById(R.id.txtResTrat2)
        txtResTrat2.setTextColor(resources.getColor(R.color.black))
        btnHomeTrat = pegarView.findViewById(R.id.btnHomeTrat)
        Linha1Tipo1 = getString(R.string.Linha1Tipo1)
        Linha2Tipo1 = getString(R.string.Linha2Tipo1)
        Linha1Tipo2 = getString(R.string.Linha1Tipo2)
        Linha2Tipo2 = getString(R.string.Linha2Tipo2)
        Linha1Tipo3 = getString(R.string.Linha1Tipo3)
        homeFragment = HomeFragment()

        setFragmentResultListener("requestKey") { _, bundle ->
            val result = bundle.getString("Tratamentos")
            if (result.toString().toInt() == 1) {
                txtResTrat1.text = Linha1Tipo1
                txtResTrat2.text = Linha2Tipo1
            } else if (result.toString().toInt() == 2) {
                txtResTrat1.text = Linha1Tipo2
                txtResTrat2.text = Linha2Tipo2
            } else if (result.toString().toInt() == 3) {
                txtResTrat1.text = Linha1Tipo3
                txtResTrat2.visibility = View.INVISIBLE
            }
        }
        btnHomeTrat.setOnClickListener{
            setFragment(homeFragment)
        }
        return pegarView
    }
    private fun setFragment(fragment: Fragment){
        val fT = requireActivity().supportFragmentManager.beginTransaction()
        fT.replace(R.id.nav_host_fragment_content_principal, fragment)
        fT.commit()
    }
}