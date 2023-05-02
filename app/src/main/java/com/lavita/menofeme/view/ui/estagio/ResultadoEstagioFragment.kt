package com.lavita.menofeme.view.ui.estagio

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

class ResultadoEstagioFragment : Fragment() {
    private lateinit var pegarView: View
    private lateinit var txtResEst1: TextView
    private lateinit var txtResEst2: TextView
    private lateinit var txtResEst3: TextView
    private lateinit var txtResEst4: TextView
    private lateinit var linha1Est1: String
    private lateinit var linha2Est1: String
    private lateinit var linha3Est1: String
    private lateinit var linha4Est1: String
    private lateinit var linha1Est2: String
    private lateinit var linha2Est2: String
    private lateinit var linha3Est2: String
    private lateinit var linha4Est2: String
    private lateinit var linha1Est3: String
    private lateinit var linha2Est3: String
    private lateinit var linha3Est3: String
    private lateinit var linha4Est3: String
    private lateinit var btnHomeEst: ImageButton
    private lateinit var homeFragment: HomeFragment

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        pegarView = inflater.inflate(R.layout.fragment_resultado_estagio, container, false)
        txtResEst1 = pegarView.findViewById(R.id.Linha1Est)
        txtResEst1.setTextColor(resources.getColor(R.color.black))
        txtResEst2 = pegarView.findViewById(R.id.Linha2Est)
        txtResEst2.setTextColor(resources.getColor(R.color.black))
        txtResEst3 = pegarView.findViewById(R.id.Linha3Est)
        txtResEst3.setTextColor(resources.getColor(R.color.black))
        txtResEst4 = pegarView.findViewById(R.id.Linha4Est)
        txtResEst4.setTextColor(resources.getColor(R.color.black))
        linha1Est1 = getString(R.string.txtEst1)
        linha2Est1 = getString(R.string.linha2Est1)
        linha3Est1 = getString(R.string.linha3Est1)
        linha4Est1 = getString(R.string.app_name)
        linha1Est2 = getString(R.string.txtEst2)
        linha2Est2 = getString(R.string.linha2Est2)
        linha3Est2 = getString(R.string.linha3Est2)
        linha4Est2 = getString(R.string.linha4Est2)
        linha1Est3 = getString(R.string.txtEst3)
        linha2Est3 = getString(R.string.linha2Est3)
        linha3Est3 = getString(R.string.linha3Est3)
        linha4Est3 = getString(R.string.linha4Est3)
        btnHomeEst = pegarView.findViewById(R.id.btnHomeEst)
        homeFragment = HomeFragment()


        setFragmentResultListener("requestKey") { _, bundle ->
            val result = bundle.getString("Estagio")
            if(result.toString().toInt() == 1){
                txtResEst1.text = linha1Est1
                txtResEst2.text = linha2Est1
                txtResEst3.text = linha3Est1
                txtResEst4.visibility = View.INVISIBLE
            }
            if(result.toString().toInt()== 2){
                txtResEst1.text = linha1Est2
                txtResEst2.text = linha2Est2
                txtResEst3.text = linha3Est2
                txtResEst4.text = linha4Est2
            }
            if(result.toString().toInt() == 3) {
                txtResEst1.text = linha1Est3
                txtResEst2.text = linha2Est3
                txtResEst3.text = linha3Est3
                txtResEst4.text = linha4Est3
            }
        }
        btnHomeEst.setOnClickListener{
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