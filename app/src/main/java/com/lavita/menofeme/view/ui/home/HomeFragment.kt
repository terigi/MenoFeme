package com.lavita.menofeme.view.ui.home

import android.app.AlertDialog
import android.content.DialogInterface
import android.os.Bundle
import android.util.Log
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
import com.lavita.menofeme.view.ui.questionarios.MenqolFragment
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
    //private lateinit var data_menqol: String
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
        //setupOnBackPressed()
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

        Log.d("TESTE", "Antes de chamar usuária")
        val user = Firebase.auth.currentUser
        user?.let {
            val email = it.email
            db.collection("User")
                .whereEqualTo("Email", email.toString())
                .get()
                .addOnSuccessListener { documents ->
                    Log.d("TESTE", "Pegando dados")
                    for (document in documents) {
                        lblNome.text = document.getString("Nome")
                        val teste = document.getString("Termos")
                        termos = teste.toString()
                        //data_menqol = document.getString("Data_Menqol").toString()
                    }
                }
        }
/*
        data_menqol = ""

        if (data_menqol.isEmpty()){
            val alertDialog: AlertDialog.Builder = AlertDialog.Builder()
            alertDialog.setTitle("Questionário Menqol")
            alertDialog.setMessage("Precisamos que preencha o questionário Menqol.")
            alertDialog.setPositiveButton(
                "OK"
            ) { _, _ ->
                if(termos != "1"){
                    androidx.appcompat.app.AlertDialog.Builder(requireContext())
                        .setTitle(R.string.menu_app)
                        .setMessage(R.string.txtTermoN)
                        .setPositiveButton(R.string.rbSim) { _, _ ->
                            db.collection("User").document(dbEmail)
                                .update("Termos", "1")
                            setFragment(menqolFragment)
                        }
                        .setNegativeButton(R.string.rbNao) { _, _ ->
                            setFragment(questionariosFragment)
                        }
                        .setIcon(R.drawable.ic_menstruacao)
                        .show()
                }else{
                    setFragment(menqolFragment)
                }
            }

            val alert: AlertDialog = alertDialog.create()
            alert.setCanceledOnTouchOutside(false)
            alert.show()
        }
        data_menqol = "12-08-2023"
        val sdf = SimpleDateFormat("dd-MM-yyyy")
        val dataAtual = sdf.format(Calendar.getInstance().time)
        //val dataMenqol = sdf.format(data_menqol)
        Log.d("ACESSO", dataAtual.toString())
        Log.d("ACESSO", data_menqol)
        val DI: Date = sdf.parse(data_menqol)
        val DF: Date = sdf.parse(dataAtual)
        val result = (DF.time-DI.time) / 1000 / 60 / 60 / 24
        Log.d("ACESSO", DI.toString())
        Log.d("ACESSO", DF.toString())
        Log.d("ACESSO", result.toString())
*/
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

    /*private fun setupOnBackPressed(){
        requireActivity().onBackPressedDispatcher.addCallback(object : OnBackPressedCallback(true){
            override fun handleOnBackPressed() {
                if(isEnabled){
                    isEnabled = false
                    requireActivity().onBackPressed()
                }
            }
        })
    }*/
    private fun setFragment(fragment: Fragment){
        val fT = requireActivity().supportFragmentManager.beginTransaction()
        fT.addToBackStack(fragment.toString())
        fT.replace(R.id.nav_host_fragment_content_principal, fragment,fragment.toString())
        fT.commit()
    }

}
