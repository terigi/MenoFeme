package com.lavita.menofeme.view.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.google.firebase.auth.ktx.auth
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.ktx.Firebase
import com.lavita.menofeme.R
import com.lavita.menofeme.view.ui.estagio.EstagioFragment
import com.lavita.menofeme.view.ui.orientacao.OrientacaoFragment
import com.lavita.menofeme.view.ui.questionarios.QuestionariosFragment
import com.lavita.menofeme.view.ui.sintomas.SintomasFragment
import com.lavita.menofeme.view.ui.tratamentos.TratamentosFragment


class HomeFragment : Fragment() {
    private lateinit var pegarView: View
    private lateinit var lblNome: TextView
    private lateinit var btnEstagio: androidx.appcompat.widget.AppCompatButton
    private lateinit var btnOrientacoes: androidx.appcompat.widget.AppCompatButton
    private lateinit var btnSintomas: androidx.appcompat.widget.AppCompatButton
    private lateinit var btnTratamento: androidx.appcompat.widget.AppCompatButton
    private lateinit var btnQuestionarios: androidx.appcompat.widget.AppCompatButton
    private lateinit var btnDiario: androidx.appcompat.widget.AppCompatButton
    private lateinit var termos: String
    private lateinit var estagioFragment: EstagioFragment
    private lateinit var orientacaoFragment: OrientacaoFragment
    private lateinit var sintomasFragment: SintomasFragment
    private lateinit var tratamentosFragment: TratamentosFragment
    private lateinit var questionariosFragment: QuestionariosFragment
    private val db = FirebaseFirestore.getInstance()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        pegarView = inflater.inflate(R.layout.fragment_home, container, false)
        lblNome = pegarView.findViewById(R.id.lblNome)
        btnEstagio = pegarView.findViewById(R.id.btnEstagio)
        btnOrientacoes = pegarView.findViewById(R.id.btnOrientacoes)
        btnSintomas = pegarView.findViewById(R.id.btnSintomas)
        btnTratamento = pegarView.findViewById(R.id.btnTratamento)
        btnQuestionarios = pegarView.findViewById(R.id.btnQuestionarios)
        btnDiario = pegarView.findViewById(R.id.btnDiario)
        estagioFragment = EstagioFragment()
        orientacaoFragment = OrientacaoFragment()
        sintomasFragment = SintomasFragment()
        tratamentosFragment = TratamentosFragment()
        questionariosFragment = QuestionariosFragment()

        val user = Firebase.auth.currentUser
        user?.let {
            val email = it.email
            db.collection("User")
                .whereEqualTo("Email", email.toString())
                .get()
                .addOnSuccessListener { documents ->
                    for (document in documents) {
                        lblNome.text = document.getString("Nome")
                        val teste = document.getString("Termos")
                        termos = teste.toString()

                    }
                }
        }
        btnEstagio.setOnClickListener {
            setFragment(estagioFragment)
        }

        btnOrientacoes.setOnClickListener {
            setFragment(orientacaoFragment)
        }

        btnSintomas.setOnClickListener {
            setFragment(sintomasFragment)
        }

        btnTratamento.setOnClickListener {
            setFragment(tratamentosFragment)
        }

        btnQuestionarios.setOnClickListener {
            setFragment(questionariosFragment)
        }

        btnDiario.setOnClickListener {
            Toast.makeText(requireContext(), "Esta função está sendo implementada", Toast.LENGTH_SHORT)
                .show()
        }

        return pegarView
    }
    private fun setFragment(fragment: Fragment){

        val fT = requireActivity().supportFragmentManager.beginTransaction()
        fT.replace(R.id.nav_host_fragment_content_principal, fragment)
        fT.commit()
    }
}
