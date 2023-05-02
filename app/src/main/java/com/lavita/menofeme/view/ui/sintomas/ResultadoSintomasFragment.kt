package com.lavita.menofeme.view.ui.sintomas

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


@Suppress("DEPRECATION")
class ResultadoSintomasFragment : Fragment() {
    private lateinit var pegarView: View
    private lateinit var txtResSint1: TextView
    private lateinit var txtResSint2: TextView
    private lateinit var txtResSint3: TextView
    private lateinit var txtResSint4: TextView
    private lateinit var txtResSint5: TextView
    private lateinit var txtResSint6: TextView
    private lateinit var txtResSint7: TextView
    private lateinit var txtResSint8: TextView
    private lateinit var txtResSint9: TextView
    private lateinit var Linha1Sint1: String
    private lateinit var Linha2Sint1: String
    private lateinit var Linha3Sint1: String
    private lateinit var Linha4Sint1: String
    private lateinit var Linha5Sint1: String
    private lateinit var Linha6Sint1: String
    private lateinit var Linha7Sint1: String
    private lateinit var Linha8Sint1: String
    private lateinit var Linha9Sint1: String
    private lateinit var Linha1Sint2: String
    private lateinit var Linha2Sint2: String
    private lateinit var Linha3Sint2: String
    private lateinit var Linha4Sint2: String
    private lateinit var Linha5Sint2: String
    private lateinit var Linha6Sint2: String
    private lateinit var Linha7Sint2: String
    private lateinit var Linha1Sint3: String
    private lateinit var Linha2Sint3: String
    private lateinit var Linha3Sint3: String
    private lateinit var Linha4Sint3: String
    private lateinit var Linha5Sint3: String
    private lateinit var Linha6Sint3: String
    private lateinit var Linha7Sint3: String
    private lateinit var Linha1Sint4: String
    private lateinit var Linha2Sint4: String
    private lateinit var Linha3Sint4: String
    private lateinit var Linha4Sint4: String
    private lateinit var Linha5Sint4: String
    private lateinit var Linha6Sint4: String
    private lateinit var Linha7Sint4: String
    private lateinit var Linha1Sint5: String
    private lateinit var Linha2Sint5: String
    private lateinit var Linha3Sint5: String
    private lateinit var Linha4Sint5: String
    private lateinit var Linha5Sint5: String
    private lateinit var Linha6Sint5: String
    private lateinit var Linha1Sint6: String
    private lateinit var Linha2Sint6: String
    private lateinit var Linha3Sint6: String
    private lateinit var Linha4Sint6: String
    private lateinit var Linha5Sint6: String
    private lateinit var Linha6Sint6: String
    private lateinit var Linha7Sint6: String
    private lateinit var Linha1Sint7: String
    private lateinit var Linha2Sint7: String
    private lateinit var Linha3Sint7: String
    private lateinit var Linha4Sint7: String
    private lateinit var Linha5Sint7: String
    private lateinit var Linha6Sint7: String
    private lateinit var Linha1Sint8: String
    private lateinit var Linha2Sint8: String
    private lateinit var Linha3Sint8: String
    private lateinit var Linha4Sint8: String
    private lateinit var Linha5Sint8: String
    private lateinit var Linha6Sint8: String
    private lateinit var btnHomeSint: ImageButton
    private lateinit var homeFragment: HomeFragment


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        pegarView = inflater.inflate(R.layout.fragment_resultado_sintomas, container, false)
        txtResSint1 = pegarView.findViewById(R.id.txtResSint1)
        txtResSint1.setTextColor(resources.getColor(R.color.black))
        txtResSint2 = pegarView.findViewById(R.id.txtResSint2)
        txtResSint2.setTextColor(resources.getColor(R.color.black))
        txtResSint3 = pegarView.findViewById(R.id.txtResSint3)
        txtResSint3.setTextColor(resources.getColor(R.color.black))
        txtResSint4 = pegarView.findViewById(R.id.txtResSint4)
        txtResSint4.setTextColor(resources.getColor(R.color.black))
        txtResSint5 = pegarView.findViewById(R.id.txtResSint5)
        txtResSint5.setTextColor(resources.getColor(R.color.black))
        txtResSint6 = pegarView.findViewById(R.id.txtResSint6)
        txtResSint6.setTextColor(resources.getColor(R.color.black))
        txtResSint7 = pegarView.findViewById(R.id.txtResSint7)
        txtResSint7.setTextColor(resources.getColor(R.color.black))
        txtResSint8 = pegarView.findViewById(R.id.txtResSint8)
        txtResSint8.setTextColor(resources.getColor(R.color.black))
        txtResSint9 = pegarView.findViewById(R.id.txtResSint9)
        txtResSint9.setTextColor(resources.getColor(R.color.black))
        Linha1Sint1 = getString(R.string.Linha1Sint1)
        Linha2Sint1 = getString(R.string.Linha2Sint1)
        Linha3Sint1 = getString(R.string.Linha3Sint1)
        Linha4Sint1 = getString(R.string.Linha4Sint1)
        Linha5Sint1 = getString(R.string.Linha5Sint1)
        Linha6Sint1 = getString(R.string.Linha6Sint1)
        Linha7Sint1 = getString(R.string.Linha7Sint1)
        Linha8Sint1 = getString(R.string.Linha8Sint1)
        Linha9Sint1 = getString(R.string.Linha9Sint1)
        Linha1Sint2 = getString(R.string.Linha1Sint2)
        Linha2Sint2 = getString(R.string.Linha2Sint2)
        Linha3Sint2 = getString(R.string.Linha3Sint2)
        Linha4Sint2 = getString(R.string.Linha4Sint2)
        Linha5Sint2 = getString(R.string.Linha5Sint2)
        Linha6Sint2 = getString(R.string.Linha6Sint2)
        Linha7Sint2 = getString(R.string.Linha7Sint2)
        Linha1Sint3 = getString(R.string.Linha1Sint3)
        Linha2Sint3 = getString(R.string.Linha2Sint3)
        Linha3Sint3 = getString(R.string.Linha3Sint3)
        Linha4Sint3 = getString(R.string.Linha4Sint3)
        Linha5Sint3 = getString(R.string.Linha5Sint3)
        Linha6Sint3 = getString(R.string.Linha6Sint3)
        Linha7Sint3 = getString(R.string.Linha7Sint3)
        Linha1Sint4 = getString(R.string.Linha1Sint4)
        Linha2Sint4 = getString(R.string.Linha2Sint4)
        Linha3Sint4 = getString(R.string.Linha3Sint4)
        Linha4Sint4 = getString(R.string.Linha4Sint4)
        Linha5Sint4 = getString(R.string.Linha5Sint4)
        Linha6Sint4 = getString(R.string.Linha6Sint4)
        Linha7Sint4 = getString(R.string.Linha7Sint4)
        Linha1Sint5 = getString(R.string.Linha1Sint5)
        Linha2Sint5 = getString(R.string.Linha2Sint5)
        Linha3Sint5 = getString(R.string.Linha3Sint5)
        Linha4Sint5 = getString(R.string.Linha4Sint5)
        Linha5Sint5 = getString(R.string.Linha5Sint5)
        Linha6Sint5 = getString(R.string.Linha6Sint5)
        Linha1Sint6 = getString(R.string.Linha1Sint6)
        Linha2Sint6 = getString(R.string.Linha2Sint6)
        Linha3Sint6 = getString(R.string.Linha3Sint6)
        Linha4Sint6 = getString(R.string.Linha4Sint6)
        Linha5Sint6 = getString(R.string.Linha5Sint6)
        Linha6Sint6 = getString(R.string.Linha6Sint6)
        Linha7Sint6 = getString(R.string.Linha7Sint6)
        Linha1Sint7 = getString(R.string.Linha1Sint7)
        Linha2Sint7 = getString(R.string.Linha2Sint7)
        Linha3Sint7 = getString(R.string.Linha3Sint7)
        Linha4Sint7 = getString(R.string.Linha4Sint7)
        Linha5Sint7 = getString(R.string.Linha5Sint7)
        Linha6Sint7 = getString(R.string.Linha6Sint7)
        Linha1Sint8 = getString(R.string.Linha1Sint8)
        Linha2Sint8 = getString(R.string.Linha2Sint8)
        Linha3Sint8 = getString(R.string.Linha3Sint8)
        Linha4Sint8 = getString(R.string.Linha4Sint8)
        Linha5Sint8 = getString(R.string.Linha5Sint8)
        Linha6Sint8 = getString(R.string.Linha6Sint8)

        btnHomeSint= pegarView.findViewById(R.id.btnHomeSint)
        homeFragment = HomeFragment()

        setFragmentResultListener("requestKey") { _, bundle ->
            val result = bundle.getString("Sintomas")
            if (result.toString().toInt() == 1) {
                txtResSint1.text = Linha1Sint1
                txtResSint2.text = Linha2Sint1
                txtResSint3.text = Linha3Sint1
                txtResSint4.text = Linha4Sint1
                txtResSint5.text = Linha5Sint1
                txtResSint6.text = Linha6Sint1
                txtResSint7.text = Linha7Sint1
                txtResSint8.text = Linha8Sint1
                txtResSint9.text = Linha9Sint1
            }
            if(result.toString().toInt() == 2){
                txtResSint1.text = Linha1Sint2
                txtResSint2.text = Linha2Sint2
                txtResSint3.text = Linha3Sint2
                txtResSint4.text = Linha4Sint2
                txtResSint5.text = Linha5Sint2
                txtResSint6.text = Linha6Sint2
                txtResSint7.text = Linha7Sint2
                txtResSint8.visibility = View.INVISIBLE
                txtResSint9.visibility = View.INVISIBLE
            }

            if(result.toString().toInt() == 3){
                txtResSint1.text = Linha1Sint3
                txtResSint2.text = Linha2Sint3
                txtResSint3.text = Linha3Sint3
                txtResSint4.text = Linha4Sint3
                txtResSint5.text = Linha5Sint3
                txtResSint6.text = Linha6Sint3
                txtResSint7.text = Linha7Sint3
                txtResSint8.visibility = View.INVISIBLE
                txtResSint9.visibility = View.INVISIBLE
            }

            if(result.toString().toInt() == 4){
                txtResSint1.text = Linha1Sint4
                txtResSint2.text = Linha2Sint4
                txtResSint3.text = Linha3Sint4
                txtResSint4.text = Linha4Sint4
                txtResSint5.text = Linha5Sint4
                txtResSint6.text = Linha6Sint4
                txtResSint7.text = Linha7Sint4
                txtResSint8.visibility = View.INVISIBLE
                txtResSint9.visibility = View.INVISIBLE
            }

            if(result.toString().toInt() == 5){
                txtResSint1.text = Linha1Sint5
                txtResSint2.text = Linha2Sint5
                txtResSint3.text = Linha3Sint5
                txtResSint4.text = Linha4Sint5
                txtResSint5.text = Linha5Sint5
                txtResSint6.text = Linha6Sint5
                txtResSint7.visibility = View.INVISIBLE
                txtResSint8.visibility = View.INVISIBLE
                txtResSint9.visibility = View.INVISIBLE
            }

            if(result.toString().toInt() == 6){
                txtResSint1.text = Linha1Sint6
                txtResSint2.text = Linha2Sint6
                txtResSint3.text = Linha3Sint6
                txtResSint4.text = Linha4Sint6
                txtResSint5.text = Linha5Sint6
                txtResSint6.text = Linha6Sint6
                txtResSint7.text = Linha7Sint6
                txtResSint8.visibility = View.INVISIBLE
                txtResSint9.visibility = View.INVISIBLE
            }
            if(result.toString().toInt() == 7){
                txtResSint1.text = Linha1Sint7
                txtResSint2.text = Linha2Sint7
                txtResSint3.text = Linha3Sint7
                txtResSint4.text = Linha4Sint7
                txtResSint5.text = Linha5Sint7
                txtResSint6.text = Linha6Sint7
                txtResSint7.visibility = View.INVISIBLE
                txtResSint8.visibility = View.INVISIBLE
                txtResSint9.visibility = View.INVISIBLE
            }
            if(result.toString().toInt() == 8){
                txtResSint1.text = Linha1Sint8
                txtResSint2.text = Linha2Sint8
                txtResSint3.text = Linha3Sint8
                txtResSint4.text = Linha4Sint8
                txtResSint5.text = Linha5Sint8
                txtResSint6.text = Linha6Sint8
                txtResSint7.visibility = View.INVISIBLE
                txtResSint8.visibility = View.INVISIBLE
                txtResSint9.visibility = View.INVISIBLE
            }
        }

        btnHomeSint.setOnClickListener{
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