package com.lavita.menofeme.view.ui.tratamentos

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import androidx.appcompat.app.AlertDialog
import androidx.core.os.bundleOf
import androidx.fragment.app.setFragmentResult
import com.google.firebase.auth.ktx.auth
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.ktx.Firebase
import com.lavita.menofeme.R

class TratamentosFragment : Fragment() {
    private lateinit var pegarView: View
    private lateinit var btnTipo1: ImageButton
    private lateinit var btnTipo2: ImageButton
    private lateinit var btnTipo3: ImageButton
    private val db = FirebaseFirestore.getInstance()
    private lateinit var termos: String
    private lateinit var dbEmail:String
    private lateinit var tratamentosFragment: TratamentosFragment
    private lateinit var resultadoTratamentosFragment: ResultadoTratamentosFragment


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        pegarView = inflater.inflate(R.layout.fragment_tratamentos, container, false)
        btnTipo1 = pegarView.findViewById(R.id.btnTipo1)
        btnTipo2 = pegarView.findViewById(R.id.btnTipo2)
        btnTipo3 = pegarView.findViewById(R.id.btnTipo3)
        tratamentosFragment = TratamentosFragment()
        resultadoTratamentosFragment = ResultadoTratamentosFragment()

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

        btnTipo1.setOnClickListener{
            if(termos != "1"){
                AlertDialog.Builder(requireContext())
                    .setTitle(R.string.menu_app)
                    .setMessage(R.string.txtTermoN)
                    .setPositiveButton(R.string.rbSim) { _, _ ->
                        db.collection("User").document(dbEmail)
                            .update("Termos", "1")
                        val result = "1"
                        setFragmentResult("requestKey", bundleOf("Tratamentos" to result))
                        setFragment(resultadoTratamentosFragment)
                    }
                    .setNegativeButton(R.string.rbNao) { _, _ ->
                        setFragment(tratamentosFragment)
                    }
                    .setIcon(R.drawable.ic_menstruacao)
                    .show()
            }else{
                val result = "1"
                setFragmentResult("requestKey", bundleOf("Tratamentos" to result))
                setFragment(resultadoTratamentosFragment)
            }
        }
        btnTipo2.setOnClickListener{
            if(termos != "1"){
                AlertDialog.Builder(requireContext())
                    .setTitle(R.string.menu_app)
                    .setMessage(R.string.txtTermoN)
                    .setPositiveButton(R.string.rbSim) { _, _ ->
                        db.collection("User").document(dbEmail)
                            .update("Termos", "1")
                        val result = "2"
                        setFragmentResult("requestKey", bundleOf("Tratamentos" to result))
                        setFragment(resultadoTratamentosFragment)
                    }
                    .setNegativeButton(R.string.rbNao) { _, _ ->
                        setFragment(tratamentosFragment)
                    }
                    .setIcon(R.drawable.ic_menstruacao)
                    .show()
            }else{
                val result = "2"
                setFragmentResult("requestKey", bundleOf("Tratamentos" to result))
                setFragment(resultadoTratamentosFragment)
            }
        }
        btnTipo3.setOnClickListener{
            if(termos != "1"){
                AlertDialog.Builder(requireContext())
                    .setTitle(R.string.menu_app)
                    .setMessage(R.string.txtTermoN)
                    .setPositiveButton(R.string.rbSim) { _, _ ->
                        db.collection("User").document(dbEmail)
                            .update("Termos", "1")
                        val result = "3"
                        setFragmentResult("requestKey", bundleOf("Tratamentos" to result))
                        setFragment(resultadoTratamentosFragment)
                    }
                    .setNegativeButton(R.string.rbNao) { _, _ ->
                        setFragment(tratamentosFragment)
                    }
                    .setIcon(R.drawable.ic_menstruacao)
                    .show()
            }else{
                val result = "3"
                setFragmentResult("requestKey", bundleOf("Tratamentos" to result))
                setFragment(resultadoTratamentosFragment)
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