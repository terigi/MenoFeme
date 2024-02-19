package com.lavita.menofeme.view.ui.estagio

import android.content.Intent
import android.content.Intent.ACTION_SEND
import android.content.Intent.getIntent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.activity.OnBackPressedCallback
import androidx.appcompat.app.ActionBar
import androidx.appcompat.app.AlertDialog
import androidx.core.os.bundleOf
import androidx.core.view.isInvisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.setFragmentResult
import androidx.fragment.app.setFragmentResultListener
import com.google.firebase.auth.ktx.auth
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.ktx.Firebase
import com.lavita.menofeme.R
import com.lavita.menofeme.view.ui.home.HomeFragment
import java.text.SimpleDateFormat
import java.util.*


class EstagioFragment : Fragment() {

    private lateinit var pegarView: View
    private lateinit var rdgUltima: RadioGroup
    private lateinit var rbSim: RadioButton
    private lateinit var rbNao: RadioButton
    private lateinit var rdgAtraso: RadioGroup
    private lateinit var rb2Sim: RadioButton
    private lateinit var rb2Nao: RadioButton
    private lateinit var txtDebug: TextView
    private lateinit var txtMenstruacao: TextView
    private lateinit var btnAnalise: androidx.appcompat.widget.AppCompatButton
    private lateinit var btnSaiba: androidx.appcompat.widget.AppCompatButton
    private lateinit var txtFsh: EditText
    private lateinit var txtEst1: String
    private lateinit var txtEst2: String
    private lateinit var txtEst3: String
    private lateinit var q1Est: String
    private lateinit var q2Est: String
    private val db = FirebaseFirestore.getInstance()
    private lateinit var termos: String
    private lateinit var dbEmail:String
    private lateinit var resultadoEstagio: ResultadoEstagioFragment
    private lateinit var estagio: EstagioFragment
    //private lateinit var home: HomeFragment


    private var posEstagio: Int = 0
    private var valorFsh: Int = 0
    private var infoEst: Int = 0


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        pegarView = inflater.inflate(R.layout.fragment_estagio, container, false)
        rdgUltima = pegarView.findViewById(R.id.rdgUltima)
        rbSim = pegarView.findViewById(R.id.rbSim)
        rbNao = pegarView.findViewById(R.id.rbNao)
        rdgAtraso = pegarView.findViewById(R.id.rdgAtraso)
        rb2Sim = pegarView.findViewById(R.id.rb2Sim)
        rb2Nao = pegarView.findViewById(R.id.rb2Nao)
        txtFsh = pegarView.findViewById(R.id.txtFsh)
        txtDebug = pegarView.findViewById(R.id.txtDegub)
        txtMenstruacao = pegarView.findViewById(R.id.txtMenstruacao)
        btnAnalise = pegarView.findViewById(R.id.btnAnalise)
        btnSaiba = pegarView.findViewById(R.id.btnSaiba)
        txtEst1 = getString(R.string.txtEst1)
        txtEst2 = getString(R.string.txtEst2)
        txtEst3 = getString(R.string.txtEst3)
        q1Est = getString(R.string.Q1Est)
        q2Est = getString(R.string.Q2Est)
        resultadoEstagio = ResultadoEstagioFragment()
        estagio = EstagioFragment()
        //home = HomeFragment()

        rdgAtraso.visibility = View.GONE
        txtMenstruacao.visibility = View.GONE
        txtDebug.visibility = View.GONE

        /*activity?.onBackPressedDispatcher?.addCallback(viewLifecycleOwner, object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
                setFragment(home)
            }
        })*/

        //Log.d("ACESSO", "Antes do usuário")
        val user1 = Firebase.auth.currentUser
        user1?.let {
            val email = it.email
                db.collection("User").document(email.toString())
                .addSnapshotListener { documento, _ ->
                    if (documento != null) {
                        val termo = documento.getString("Termos")
                        termos = termo.toString()
                        dbEmail = email.toString()
                    }
                }
        }
        setCheckedRbgUltima()
        setCheckedRbgAtraso()

        btnAnalise.setOnClickListener {
            txtDebug.visibility = View.VISIBLE
            valorFsh = if (txtFsh.text.isNotEmpty()) {
                txtFsh.text.toString().toInt()
            } else {
                0
            }
            if (posEstagio == 0) {
                Toast.makeText(requireContext(), q1Est, Toast.LENGTH_SHORT).show()
                txtDebug.visibility = View.GONE
            } else if ((posEstagio == 1)) {
                txtDebug.visibility = View.VISIBLE
                txtDebug.text = txtEst1
                btnSaiba.visibility = View.VISIBLE
                btnSaiba.isEnabled = true
                btnAnalise.visibility = View.GONE
                rbSim.isEnabled = false
                rbNao.isEnabled = false
                rb2Sim.isEnabled = false
                rb2Nao.isEnabled = false
                infoEst = 1
            } else if ((posEstagio == 2) and (valorFsh < 20)) {
                Toast.makeText(requireContext(), q2Est, Toast.LENGTH_SHORT).show()
                txtDebug.visibility = View.GONE
            } else if ((posEstagio == 3) or (valorFsh >= 20)) {
                txtDebug.visibility = View.VISIBLE
                txtDebug.text = txtEst2
                btnSaiba.visibility = View.VISIBLE
                btnSaiba.isEnabled = true
                btnAnalise.visibility = View.GONE
                rbSim.isEnabled = false
                rbNao.isEnabled = false
                rb2Sim.isEnabled = false
                rb2Nao.isEnabled = false
                txtFsh.isEnabled = false
                infoEst = 2
            } else if ((posEstagio == 4) and (valorFsh >= 20)) {
                txtDebug.visibility = View.VISIBLE
                txtDebug.text = txtEst2
                btnSaiba.visibility = View.VISIBLE
                btnSaiba.isEnabled = true
                btnAnalise.visibility = View.GONE
                rbSim.isEnabled = false
                rbNao.isEnabled = false
                rb2Sim.isEnabled = false
                rb2Nao.isEnabled = false
                txtFsh.isEnabled = false
                infoEst = 2
            } else if ((posEstagio == 4) and (valorFsh < 20)) {
                txtDebug.visibility = View.VISIBLE
                txtDebug.text = txtEst3
                btnSaiba.visibility = View.VISIBLE
                btnSaiba.isEnabled = true
                btnAnalise.visibility = View.GONE
                rbSim.isEnabled = false
                rbNao.isEnabled = false
                rb2Sim.isEnabled = false
                rb2Nao.isEnabled = false
                txtFsh.isEnabled = false
                infoEst = 3
            }
            val result = infoEst.toString()
            setFragmentResult("requestKey", bundleOf("Estagio" to result))
        }

        btnSaiba.setOnClickListener {
            txtFsh.text.isEmpty()
            Log.d("ACESSO", termos)
            if (termos != "1") {
                println("Entrou no if")
                AlertDialog.Builder(requireContext())
                    .setTitle(R.string.menu_app)
                    .setMessage(R.string.txtTermoN)
                    .setPositiveButton(R.string.rbSim) { _, _ ->
                        db.collection("User").document(dbEmail)
                            .update("Termos", "1")
                        //Criando um coleção
                        val user = Firebase.auth.currentUser
                        user?.let {
                            val email = it.email
                            db.collection("User").document(email.toString())
                                .addSnapshotListener { documento, _ ->
                                    if (documento != null) {
                                        val nome = documento.getString("Nome")
                                        val emailEst = documento.getString("Email")
                                        val txtData =
                                            SimpleDateFormat("dd/MM/yyyy", Locale.getDefault()).format(
                                                System.currentTimeMillis()
                                            )
                                        val txtHora = SimpleDateFormat(
                                            "HH:mm",
                                            Locale.getDefault()
                                        ).format(System.currentTimeMillis())
                                        val idEstagio = db.collection("Estagio").document().id

                                        val estagioMap = hashMapOf(
                                            "idEstagio" to idEstagio,
                                            "Nome" to nome.toString(),
                                            "Email" to emailEst.toString(),
                                            "Estagio" to infoEst.toString(),
                                            "Data" to txtData.toString(),
                                            "Hora" to txtHora.toString()
                                        )
                                        db.collection("Estagio").document(idEstagio)
                                            .set(estagioMap).addOnCompleteListener {

                                            }.addOnFailureListener {

                                            }
                                    }
                                }
                        }
                        setFragment(resultadoEstagio)
                    }
                    .setNegativeButton(R.string.rbNao) { _, _ ->
                        setFragment(estagio)
                    }
                    .setIcon(R.drawable.ic_menstruacao)
                    .show()
            } else {
                //Criando um coleção
                val user = Firebase.auth.currentUser
                user?.let {
                    val email = it.email

                    db.collection("User").document(email.toString())
                        .addSnapshotListener { documento, _ ->
                            if (documento != null) {
                                val nome = documento.getString("Nome")
                                val emailEst = documento.getString("Email")
                                val txtData =
                                    SimpleDateFormat("dd/MM/yyyy", Locale.getDefault()).format(
                                        System.currentTimeMillis()
                                    )
                                val txtHora = SimpleDateFormat(
                                    "HH:mm",
                                    Locale.getDefault()
                                ).format(System.currentTimeMillis())
                                val idEstagio = db.collection("Estagio").document().id

                                val estagioMap = hashMapOf(
                                    "idEstagio" to idEstagio,
                                    "Nome" to nome.toString(),
                                    "Email" to emailEst.toString(),
                                    "Estagio" to infoEst.toString(),
                                    "Data" to txtData.toString(),
                                    "Hora" to txtHora.toString()
                                )
                                db.collection("Estagio").document(idEstagio)
                                    .set(estagioMap).addOnCompleteListener {

                                    }.addOnFailureListener {

                                    }
                            }
                        }
                }
                setFragment(resultadoEstagio)
            }
        }
        return pegarView
    }

    private fun setCheckedRbgUltima() {
        rdgUltima.setOnCheckedChangeListener { _, checkedId ->
            if (R.id.rbSim == checkedId){
                posEstagio = 1
                rb2Sim.isEnabled = false
                rb2Nao.isEnabled = false
                rb2Sim.isChecked = false
                rb2Nao.isChecked = false
                txtFsh.visibility = View.GONE
                txtMenstruacao.visibility = View.GONE
                rdgAtraso.visibility = View.GONE
            }else if (R.id.rbNao == checkedId) {
                posEstagio = 2
                rb2Sim.isEnabled = true
                rb2Nao.isEnabled = true
                rb2Sim.isChecked = false
                rb2Nao.isChecked = false
                txtFsh.visibility = View.VISIBLE
                txtMenstruacao.visibility = View.VISIBLE
                rdgAtraso.visibility = View.VISIBLE
            }
        }
    }
    private fun setCheckedRbgAtraso() {
        rdgAtraso.setOnCheckedChangeListener { _, checkedId ->
            if (R.id.rb2Sim == checkedId){
                posEstagio = 3
            }else if (R.id.rb2Nao == checkedId){
                posEstagio = 4
            }
        }
    }
    private fun setFragment(fragment: Fragment){
        val fT = requireActivity().supportFragmentManager.beginTransaction()
        fT.replace(R.id.nav_host_fragment_content_principal, fragment)
        fT.commit()
    }
}