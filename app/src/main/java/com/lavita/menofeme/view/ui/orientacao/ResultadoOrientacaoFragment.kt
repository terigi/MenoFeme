package com.lavita.menofeme.view.ui.orientacao

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.TextView
import androidx.fragment.app.setFragmentResultListener
import com.lavita.menofeme.R
import com.lavita.menofeme.view.ui.home.HomeFragment

class ResultadoOrientacaoFragment : Fragment() {

    private lateinit var pegarView: View
    private lateinit var txtResObs1: TextView
    private lateinit var txtResObs2: TextView
    private lateinit var txtResObs3: TextView
    private lateinit var txtResObs4: TextView
    private lateinit var linha1Duv1: String
    private lateinit var linha2Duv1: String
    private lateinit var linha3Duv1: String
    private lateinit var linha4Duv1: String
    private lateinit var linha1Duv2: String
    private lateinit var linha2Duv2: String
    private lateinit var linha1Duv3: String
    private lateinit var linha2Duv3: String
    private lateinit var linha3Duv3: String
    private lateinit var linha4Duv3: String
    private lateinit var linha1Duv4: String
    private lateinit var linha2Duv4: String
    private lateinit var linha3Duv4: String
    private lateinit var linha4Duv4: String
    private lateinit var btnHomeOrient: ImageButton
    private lateinit var homeFragment: HomeFragment


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        pegarView = inflater.inflate(R.layout.fragment_resultado_orientacao, container, false)
        txtResObs1 = pegarView.findViewById(R.id.txtResObs1)
        txtResObs1.setTextColor(resources.getColor(R.color.black))
        txtResObs2 = pegarView.findViewById(R.id.txtResObs2)
        txtResObs2.setTextColor(resources.getColor(R.color.black))
        txtResObs3 = pegarView.findViewById(R.id.txtResObs3)
        txtResObs3.setTextColor(resources.getColor(R.color.black))
        txtResObs4 = pegarView.findViewById(R.id.txtResObs4)
        txtResObs4.setTextColor(resources.getColor(R.color.black))
        btnHomeOrient = pegarView.findViewById(R.id.btnHomeOrient)
        homeFragment = HomeFragment()
        linha1Duv1 = getString(R.string.txtObs1)
        linha2Duv1 = getString(R.string.Linha1Duv1)
        linha3Duv1 = getString(R.string.Linha2Duv1)
        linha4Duv1 = getString(R.string.Linha3Duv1)
        linha1Duv2 = getString(R.string.txtObs2)
        linha2Duv2 = getString(R.string.Linha1Duv2)
        linha1Duv3 = getString(R.string.txtObs3)
        linha2Duv3 = getString(R.string.Linha1Duv3)
        linha3Duv3 = getString(R.string.Linha2Duv3)
        linha4Duv3 = getString(R.string.Linha3Duv3)
        linha1Duv4 = getString(R.string.txtObs4)
        linha2Duv4 = getString(R.string.Linha1Duv4)
        linha3Duv4 = getString(R.string.Linha2Duv4)
        linha4Duv4 = getString(R.string.Linha3Duv4)

        setFragmentResultListener("requestKey") { _, bundle ->
            val result = bundle.getString("Orientacao")
           if (result.toString().toInt() == 1) {
                txtResObs1.text = linha1Duv1
                txtResObs2.text = linha2Duv1
                txtResObs3.text = linha3Duv1
                txtResObs4.text = linha4Duv1
            }

            if (result.toString().toInt() == 2) {
                txtResObs1.text = linha1Duv2
                txtResObs2.text = linha2Duv2
                txtResObs3.visibility = View.INVISIBLE
                txtResObs4.visibility = View.INVISIBLE
            }

            if (result.toString().toInt() == 3) {
                txtResObs1.text = linha1Duv3
                txtResObs2.text = linha2Duv3
                txtResObs3.text = linha3Duv3
                txtResObs4.text = linha4Duv3
            }
            if (result.toString().toInt() == 4) {
                txtResObs1.text = linha1Duv4
                txtResObs2.text = linha2Duv4
                txtResObs3.text = linha3Duv4
                txtResObs4.text = linha4Duv4
            }
        }
        btnHomeOrient.setOnClickListener{
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