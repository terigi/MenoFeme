package com.lavita.menofeme.view.ui.sintomas

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.fragment.app.setFragmentResult
import com.google.firebase.auth.ktx.auth
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.ktx.Firebase
import com.lavita.menofeme.R


class SintomasFragment : Fragment() {
    private lateinit var pegarView: View
    private lateinit var btnSint1: ImageButton
    private lateinit var btnSint2: ImageButton
    private lateinit var btnSint3: ImageButton
    private lateinit var btnSint4: ImageButton
    private lateinit var btnSint5: ImageButton
    private lateinit var btnSint6: ImageButton
    private lateinit var btnSint7: ImageButton
    private lateinit var btnSint8: ImageButton
    private val db = FirebaseFirestore.getInstance()
    private lateinit var termos: String
    private lateinit var dbEmail:String
    private lateinit var sintomasFragment: SintomasFragment
    private lateinit var resultadoSintomasFragment: ResultadoSintomasFragment


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        pegarView = inflater.inflate(R.layout.fragment_sintomas, container, false)
        btnSint1 = pegarView.findViewById(R.id.btnSint1)
        btnSint2 = pegarView.findViewById(R.id.btnSint2)
        btnSint3 = pegarView.findViewById(R.id.btnSint3)
        btnSint4 = pegarView.findViewById(R.id.btnSint4)
        btnSint5 = pegarView.findViewById(R.id.btnSint5)
        btnSint6 = pegarView.findViewById(R.id.btnSint6)
        btnSint7 = pegarView.findViewById(R.id.btnSint7)
        btnSint8 = pegarView.findViewById(R.id.btnSint8)
        sintomasFragment = SintomasFragment()
        resultadoSintomasFragment = ResultadoSintomasFragment()

        val user = Firebase.auth.currentUser
        user?.let {
            val email = it.email
            db.collection("User").document(email.toString())
                .addSnapshotListener { documento, _ ->
                    if (documento != null) {
                        val teste = documento.getString("Termos")
                        termos = teste.toString()
                        dbEmail = email.toString()
                    }
                }
        }
        btnSint1.setOnClickListener{
            if(termos != "1"){
                AlertDialog.Builder(requireContext())
                    .setTitle(R.string.menu_app)
                    .setMessage(R.string.txtTermoN)
                    .setPositiveButton(R.string.rbSim) { _, _ ->
                        db.collection("User").document(dbEmail)
                            .update("Termos", "1")
                        val result = "1"
                        setFragmentResult("requestKey", bundleOf("Sintomas" to result))
                        setFragment(resultadoSintomasFragment)
                    }
                    .setNegativeButton(R.string.rbNao) { _, _ ->
                        setFragment(sintomasFragment)
                    }
                    .setIcon(R.drawable.ic_menstruacao)
                    .show()
            }else{
                val result = "1"
                setFragmentResult("requestKey", bundleOf("Sintomas" to result))
                setFragment(resultadoSintomasFragment)
            }
        }
        btnSint2.setOnClickListener{
            if(termos != "1"){
                AlertDialog.Builder(requireContext())
                    .setTitle(R.string.menu_app)
                    .setMessage(R.string.txtTermoN)
                    .setPositiveButton(R.string.rbSim) { _, _ ->
                        db.collection("User").document(dbEmail)
                            .update("Termos", "1")
                        val result = "2"
                        setFragmentResult("requestKey", bundleOf("Sintomas" to result))
                        setFragment(resultadoSintomasFragment)
                    }
                    .setNegativeButton(R.string.rbNao) { _, _ ->
                        setFragment(sintomasFragment)
                    }
                    .setIcon(R.drawable.ic_menstruacao)
                    .show()
            }else{
                val result = "2"
                setFragmentResult("requestKey", bundleOf("Sintomas" to result))
                setFragment(resultadoSintomasFragment)
            }
        }
        btnSint3.setOnClickListener{
            if(termos != "1"){
                AlertDialog.Builder(requireContext())
                    .setTitle(R.string.menu_app)
                    .setMessage(R.string.txtTermoN)
                    .setPositiveButton(R.string.rbSim) { _, _ ->
                        db.collection("User").document(dbEmail)
                            .update("Termos", "1")
                        val result = "3"
                        setFragmentResult("requestKey", bundleOf("Sintomas" to result))
                        setFragment(resultadoSintomasFragment)
                    }
                    .setNegativeButton(R.string.rbNao) { _, _ ->
                        setFragment(sintomasFragment)
                    }
                    .setIcon(R.drawable.ic_menstruacao)
                    .show()
            }else{
                val result = "3"
                setFragmentResult("requestKey", bundleOf("Sintomas" to result))
                setFragment(resultadoSintomasFragment)
            }
        }
        btnSint4.setOnClickListener{
            if(termos != "1"){
                AlertDialog.Builder(requireContext())
                    .setTitle(R.string.menu_app)
                    .setMessage(R.string.txtTermoN)
                    .setPositiveButton(R.string.rbSim) { _, _ ->
                        db.collection("User").document(dbEmail)
                            .update("Termos", "1")
                        val result = "4"
                        setFragmentResult("requestKey", bundleOf("Sintomas" to result))
                        setFragment(resultadoSintomasFragment)
                    }
                    .setNegativeButton(R.string.rbNao) { _, _ ->
                        setFragment(sintomasFragment)
                    }
                    .setIcon(R.drawable.ic_menstruacao)
                    .show()
            }else{
                val result = "4"
                setFragmentResult("requestKey", bundleOf("Sintomas" to result))
                setFragment(resultadoSintomasFragment)
            }
        }
        btnSint5.setOnClickListener{
            if(termos != "1"){
                AlertDialog.Builder(requireContext())
                    .setTitle(R.string.menu_app)
                    .setMessage(R.string.txtTermoN)
                    .setPositiveButton(R.string.rbSim) { _, _ ->
                        db.collection("User").document(dbEmail)
                            .update("Termos", "1")
                        val result = "5"
                        setFragmentResult("requestKey", bundleOf("Sintomas" to result))
                        setFragment(resultadoSintomasFragment)
                    }
                    .setNegativeButton(R.string.rbNao) { _, _ ->
                        setFragment(sintomasFragment)
                    }
                    .setIcon(R.drawable.ic_menstruacao)
                    .show()
            }else{
                val result = "5"
                setFragmentResult("requestKey", bundleOf("Sintomas" to result))
                setFragment(resultadoSintomasFragment)
            }
        }
        btnSint6.setOnClickListener{
            if(termos != "1"){
                AlertDialog.Builder(requireContext())
                    .setTitle(R.string.menu_app)
                    .setMessage(R.string.txtTermoN)
                    .setPositiveButton(R.string.rbSim) { _, _ ->
                        db.collection("User").document(dbEmail)
                            .update("Termos", "1")
                        val result = "6"
                        setFragmentResult("requestKey", bundleOf("Sintomas" to result))
                        setFragment(resultadoSintomasFragment)
                    }
                    .setNegativeButton(R.string.rbNao) { _, _ ->
                        setFragment(sintomasFragment)
                    }
                    .setIcon(R.drawable.ic_menstruacao)
                    .show()
            }else{
                val result = "6"
                setFragmentResult("requestKey", bundleOf("Sintomas" to result))
                setFragment(resultadoSintomasFragment)
            }
        }
        btnSint7.setOnClickListener{
            if(termos != "1"){
                AlertDialog.Builder(requireContext())
                    .setTitle(R.string.menu_app)
                    .setMessage(R.string.txtTermoN)
                    .setPositiveButton(R.string.rbSim) { _, _ ->
                        db.collection("User").document(dbEmail)
                            .update("Termos", "1")
                        val result = "7"
                        setFragmentResult("requestKey", bundleOf("Sintomas" to result))
                        setFragment(resultadoSintomasFragment)
                    }
                    .setNegativeButton(R.string.rbNao) { _, _ ->
                        setFragment(sintomasFragment)
                    }
                    .setIcon(R.drawable.ic_menstruacao)
                    .show()
            }else{
                val result = "7"
                setFragmentResult("requestKey", bundleOf("Sintomas" to result))
                setFragment(resultadoSintomasFragment)
            }
        }
        btnSint8.setOnClickListener{
            if(termos != "1"){
                AlertDialog.Builder(requireContext())
                    .setTitle(R.string.menu_app)
                    .setMessage(R.string.txtTermoN)
                    .setPositiveButton(R.string.rbSim) { _, _ ->
                        db.collection("User").document(dbEmail)
                            .update("Termos", "1")
                        val result = "8"
                        setFragmentResult("requestKey", bundleOf("Sintomas" to result))
                        setFragment(resultadoSintomasFragment)
                    }
                    .setNegativeButton(R.string.rbNao) { _, _ ->
                        setFragment(sintomasFragment)
                    }
                    .setIcon(R.drawable.ic_menstruacao)
                    .show()
            }else{
                val result = "8"
                setFragmentResult("requestKey", bundleOf("Sintomas" to result))
                setFragment(resultadoSintomasFragment)
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
