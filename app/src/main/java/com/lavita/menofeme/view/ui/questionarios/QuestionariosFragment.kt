package com.lavita.menofeme.view.ui.questionarios

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import androidx.appcompat.app.AlertDialog
import com.google.firebase.auth.ktx.auth
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.ktx.Firebase
import com.lavita.menofeme.R

class QuestionariosFragment : Fragment() {
    private lateinit var pegarView: View
    private lateinit var btnQuest1: ImageButton
    private lateinit var btnQuest2: ImageButton
    private val db = FirebaseFirestore.getInstance()
    private lateinit var termos: String
    private lateinit var dbEmail:String
    private lateinit var questionariosFragment: QuestionariosFragment
    private lateinit var menqolFragment: MenqolFragment
    private lateinit var mauqFragment: MauqFragment

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        pegarView = inflater.inflate(R.layout.fragment_questionarios, container, false)
        btnQuest1 = pegarView.findViewById(R.id.btnQuest1)
        btnQuest2 = pegarView.findViewById(R.id.btnQuest2)
        questionariosFragment = QuestionariosFragment()
        menqolFragment = MenqolFragment()
        mauqFragment = MauqFragment()

        val user = Firebase.auth.currentUser
        user?.let {
            val email = it.email
            db.collection("User").document(email.toString())
                .addSnapshotListener { documento, _ ->
                    if (documento != null) {
                        val teste = documento.getString("Termos")
                        termos = teste.toString()
                    }
                }
        }

        btnQuest1.setOnClickListener {
            if(termos != "1"){
                AlertDialog.Builder(requireContext())
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

        btnQuest2.setOnClickListener {
            if(termos != "1"){
                AlertDialog.Builder(requireContext())
                    .setTitle(R.string.menu_app)
                    .setMessage(R.string.txtTermoN)
                    .setPositiveButton(R.string.rbSim) { _, _ ->
                        db.collection("User").document(dbEmail)
                            .update("Termos", "1")
                        setFragment(mauqFragment)
                    }
                    .setNegativeButton(R.string.rbNao) { _, _ ->
                        setFragment(questionariosFragment)
                    }
                    .setIcon(R.drawable.ic_menstruacao)
                    .show()
            }else{
                setFragment(mauqFragment)
            }
        }
        return pegarView
    }
    private fun setFragment(fragment: Fragment){
        val fT = requireActivity().supportFragmentManager.beginTransaction()
        fT.replace(R.id.nav_host_fragment_content_principal, fragment)
        fT.commit()
    }
}